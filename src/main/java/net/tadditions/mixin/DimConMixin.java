package net.tadditions.mixin;

import net.minecraft.advancements.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.helper.IConsoleHelp;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.cap.entity.PlayerDataCapability;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.DimensionControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.ConsoleUpdateMessage;
import net.tardis.mod.network.packets.console.DataTypes;
import net.tardis.mod.network.packets.console.DimensionData;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.consoles.*;
import org.spongepowered.asm.mixin.Mixin;

import java.util.ArrayList;
import java.util.Optional;

@Mixin(DimensionControl.class)
public abstract class DimConMixin extends BaseControl {

    private static final String MESSAGE = "message.tardis.control.dimchange";
    public ArrayList<ServerWorld> dimList = new ArrayList<ServerWorld>();
    private int index = 0;

    public DimConMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }

    @Override
    public Vector3d getPos() {
        if(this.getConsole() instanceof NemoConsoleTile)
            return new Vector3d(0, 12 / 16.0, 8 / 16.0);

        if(this.getConsole() instanceof GalvanicConsoleTile)
            return new Vector3d(0.004546756986454792, 0.5499999970197678, 0.43130290108982927);


        if(getConsole() instanceof CoralConsoleTile){
            return new Vector3d(-0.1918160605288799, 0.28125, 0.85162353648727);
        }

        if(this.getConsole() instanceof HartnellConsoleTile)
            return new Vector3d(0.605, 0.469, -0.516);

        if(this.getConsole() instanceof ToyotaConsoleTile)
            return new Vector3d(-0.557, 0.438, -0.313);

        if(this.getConsole() instanceof XionConsoleTile)
            return new Vector3d(-0.4978632379852379, 0.5, 0.30190849470534653);

        if(this.getConsole() instanceof NeutronConsoleTile)
            return new Vector3d(0.04, 0.40625, 0.8683701375027411);

        if(this.getConsole() instanceof KeltConsoleTile)
            return new Vector3d(-0.9009227420613739, 0.28125, -0.5234101003733683);

        return new Vector3d(-0.1 / 16.0, 7 / 16.0, 12 / 16.0);
    }

    private boolean doDimChangeAction(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote() && console.getLandTime() <= 0) {
            this.createDimListIfEmptyConsole(console);
            if(!this.dimList.isEmpty()) {
                this.modIndex(player.isSneaking() ? -1 : 1);
                ServerWorld type = this.dimList.get(index);
                console.setDestination(type.getDimensionKey(), console.getDestinationPosition());
                player.sendStatusMessage(new TranslationTextComponent(MESSAGE).appendSibling(new StringTextComponent(WorldHelper.formatDimName(type.getDimensionKey())).mergeStyle(TextFormatting.LIGHT_PURPLE)), true);
                this.startAnimation();

                ConsoleTile tile = this.getConsole();
                if(tile != null)
                    Network.sendToTrackingTE(new ConsoleUpdateMessage(DataTypes.DIMENSION_LIST, new DimensionData(this.dimList.size(), this.index)), tile);
            }
            else index = 0;
            return true;
        }
        return false;
    }

    private void modIndex(int i) {
        if(this.index + i >= this.dimList.size()) {
            this.index = 0;
            return;
        }
        if(this.index + i < 0) {
            this.index = this.dimList.size() - 1;
            return;
        }
        this.index += i;
    }

    private void createDimListIfEmptyConsole(ConsoleTile console){
        if(this.dimList.isEmpty()){
            ServerLifecycleHooks.getCurrentServer().getWorlds().forEach(world -> {
                if (WorldHelper.canTravelToDimension(world))
                dimList.add(world);
                ((IConsoleHelp) console).getBlocked().forEach(blocked -> {
                    Optional<World> key = DynamicRegistries.func_239770_b_().getRegistry(Registry.WORLD_KEY).getOptional(ResourceLocation.tryCreate(blocked));
                    if (key.isPresent()) {
                        Optional<RegistryKey<World>> worldKey = DynamicRegistries.func_239770_b_().getRegistry(Registry.WORLD_KEY).getOptionalKey(key.get());
                        worldKey.ifPresent(worldRegistryKey -> dimList.remove(ServerLifecycleHooks.getCurrentServer().getWorld(worldRegistryKey)));
                    }

                });
            });
        }
    }

    @Override
    public SoundEvent getFailSound(ConsoleTile console) {
        return TSounds.SONIC_FAIL.get();
    }

    @Override
    public SoundEvent getSuccessSound(ConsoleTile console) {
        return TSounds.DIMENSION.get();
    }

    @Override
    public void deserializeNBT(CompoundNBT tag) {}

    @Override
    public CompoundNBT serializeNBT() {
        return new CompoundNBT();
    }

    public boolean hasFreeTheEndAdvancement(ServerPlayerEntity player) {
        AdvancementManager manager = player.getServer().getAdvancementManager();
        Advancement advancement = manager.getAdvancement(new ResourceLocation("minecraft:end/kill_dragon"));
        AdvancementProgress progress = player.getAdvancements().getProgress(advancement);
        return progress.isDone();
    }
}
