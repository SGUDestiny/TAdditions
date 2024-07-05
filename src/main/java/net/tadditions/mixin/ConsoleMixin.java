package net.tadditions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.tadditions.mod.enchantments.TAEnchants;
import net.tadditions.mod.flightevents.MFlightEvent;
import net.tadditions.mod.helper.*;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.misc.*;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.tileentities.inventory.PanelInventory;
import net.tardis.mod.world.dimensions.TDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.*;

@Mixin(ConsoleTile.class)
public abstract class ConsoleMixin implements IConsoleHelp {
    @Shadow(remap = false) public abstract LazyOptional<ExteriorTile> getOrFindExteriorTile();
    @Shadow(remap = false) public int flightTicks;
    @Shadow(remap = false) private float max_artron;
    @Shadow(remap = false) private float artron;
    @Shadow(remap = false) private float rechargeMod;
    @Shadow(remap = false) private FlightEvent currentEvent;
    @Shadow(remap = false) protected TexVariant[] variants = {};
    @Shadow(remap = false) private boolean isBeingTowed = false;
    @Shadow(remap = false) public abstract boolean isInFlight();

    private final List<RegistryKey<World>> available = MHelper.availableDimensions();
    private boolean cloakState = false;
    private boolean timeStormCompleted = false;
    private int timeStormCountdown = 0;

    @Inject(method = "tick()V", at = @At("HEAD"), remap = false)
    public void tick(CallbackInfo ci) {
        if(this.getRecentTimeStormCompletion())
            timeStormCountdown();

        this.getOrFindExteriorTile().ifPresent(ex -> {
            World world = ex.getWorld();
            if (WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) {
                TardisHelper.getConsoleInWorld(world).ifPresent(tile -> {
                    if(tile.shouldStartChangingInterior()){
                        tile.setStartChangingInterior(false);
                    }
                });
            }
        });

        if(((ConsoleTile) (Object) this).getExteriorManager().getExteriorAnimation().equals(MExteriorAnimationRegistry.FULLNEW_WHO.getId()) && ((ConsoleTile) (Object) this).getSoundScheme() != MSoundSchemeRegistry.FULL.get()){
            ((ConsoleTile) (Object) this).setSoundScheme(MSoundSchemeRegistry.FULL.get());
        }
    }

    @Inject(method = "read(Lnet/minecraft/block/BlockState;Lnet/minecraft/nbt/CompoundNBT;)V", at = @At("TAIL"), remap = false)
    public void read(BlockState state, CompoundNBT compound, CallbackInfo ci) {
        this.cloakState = compound.getBoolean("cloakState");

        ListNBT dimBlockedList = compound.getList("available", Constants.NBT.TAG_STRING);
        for (INBT base : dimBlockedList) {
            StringNBT nbt = (StringNBT) base;
            RegistryKey<World> worlds = WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(nbt.getString()));
            if(!available.contains(worlds)) {
                available.add(worlds);
            }
        }

        this.timeStormCompleted = compound.getBoolean("recentTimeStormCompletion");
        this.timeStormCountdown = compound.getInt("timeStormBoostTime");
    }

    @Inject(method = "write(Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;", at = @At("TAIL"), remap = false)
    public void write(CompoundNBT compound, CallbackInfoReturnable<CompoundNBT> cir) {
        compound.putBoolean("cloakState", this.cloakState);

        compound.putBoolean("recentTimeStormCompletion", this.timeStormCompleted);
        compound.putInt("timeStormBoostTime", this.timeStormCountdown);

        ListNBT dimBlockedList = new ListNBT();
        this.available.forEach(world -> {
            StringNBT nbt = StringNBT.valueOf(world.getLocation().toString());
            if(!dimBlockedList.contains(nbt)) {
                dimBlockedList.add(nbt);
            }
        });
        compound.put("available", dimBlockedList);
    }

    @Inject(method = "fly()V", at = @At("HEAD"), remap = false)
    public void fly(CallbackInfo ci) {
        if (!((ConsoleTile) (Object) this).getWorld().isRemote && this.isInFlight() && !this.isBeingTowed && currentEvent != null && this.currentEvent.getMissedTime() < this.flightTicks && currentEvent.getEntry().equals(MFlightEvent.TIMESTORM.get()))
            this.setRecentTimeStormCompletion(true);
    }

    /**
     * @author mistersecret312
     * @reason ArtronCapacitor enchantments
     */
    @Overwrite(remap = false)
    public void updateArtronValues() {

        ((ConsoleTile) (Object) this).getWorld().getCapability(Capabilities.TARDIS_DATA).ifPresent(cap -> {

            float newMax = 0;
            float rate = 0;

            int numCap = 0;

            PanelInventory inv = cap.getEngineInventoryForSide(Direction.WEST);
            for(int i = 0; i < inv.getSlots(); ++i) {
                ItemStack stack = inv.getStackInSlot(i);
                if(stack.getItem() instanceof ArtronCapacitorItem) {

                    int enchantLevelR = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_LINK.get(), stack);
                    int enchantLevelS = EnchantmentHelper.getEnchantmentLevel(TAEnchants.SUBSPACE_POCKET.get(), stack);

                    int r = 0;
                    int s = 0;

                    if(enchantLevelR > 0){
                        r = enchantLevelR;
                    }
                    if(enchantLevelS > 0){
                        s = enchantLevelS*128;
                    }

                    ArtronCapacitorItem item = (ArtronCapacitorItem)stack.getItem();
                    newMax += item.getMaxStorage()+s;
                    rate += item.getRechargeModifier()+r;
                    ++numCap;
                }
            }

            this.max_artron = newMax;

            this.rechargeMod = (rate / (float)numCap);

            if(artron > this.max_artron)
                this.artron = this.max_artron;

        });
    }

    @Override
    public List<RegistryKey<World>> getAvailable() {
        return this.available;
    }

    @Override
    public void removeAvailable(RegistryKey<World> type){
        available.remove(type);
    }

    @Override
    public void addAvailable(RegistryKey<World> type){
        available.add(type);
    }

    public void timeStormCountdown(){
        if(this.getTimeStormBoostTime()<200){
            this.setTimeStormBoostTime(this.getTimeStormBoostTime()+1);
        }
        else{
            this.setTimeStormBoostTime(0);
            this.setRecentTimeStormCompletion(false);
        }
    }
    @Override
    public boolean getCloakState() {
        return cloakState;
    }

    @Override
    public void setCloakState(boolean state) {
        this.cloakState = state;
    }

    @Override
    public void setRecentTimeStormCompletion(boolean value) {
        this.timeStormCompleted = value;
    }

    @Override
    public boolean getRecentTimeStormCompletion() {
        return this.timeStormCompleted;
    }

    @Override
    public int getTimeStormBoostTime() {
        return this.timeStormCountdown;
    }

    @Override
    public void setTimeStormBoostTime(int value) {
        this.timeStormCountdown = value;
    }
}

