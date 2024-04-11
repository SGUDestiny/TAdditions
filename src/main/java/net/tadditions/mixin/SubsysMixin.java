package net.tadditions.mixin;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.ITardisWorldData;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.items.TItems;
import net.tardis.mod.registries.TardisStatistics;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.subsystem.SubsystemEntry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.inventory.PanelInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(Subsystem.class)
public abstract class SubsysMixin {

    @Shadow(remap = false) protected boolean canBeUsed;
    @Shadow(remap = false)private boolean isActivated;
    private Item parents;

    @Shadow(remap = false)public abstract SubsystemEntry getEntry();

    @Shadow(remap = false)private Item itemKey;

    @Shadow(remap = false)public abstract void onBreak();

    @Shadow(remap = false)protected abstract void updateClientIfNeeded();

    @Shadow(remap = false)public abstract Item getItemKey();

    @Shadow(remap = false) public abstract void setActivated(boolean active);


    protected ConsoleTile console;

    public ItemStack getItem() {
        if(this.console != null && console.hasWorld()) {
            ITardisWorldData data = this.console.getWorld().getCapability(Capabilities.TARDIS_DATA).orElse(null);
            if(data != null) {
                PanelInventory inv = data.getEngineInventoryForSide(Direction.NORTH);
                for(int i = 0; i < inv.getSlots(); ++i) {
                    if(itemKey == TItems.FLUID_LINK.get()){
                        parents = ModItems.FLUID_LINKMK2.get();
                    } else if(itemKey == TItems.DEMAT_CIRCUIT.get()){
                        parents = ModItems.DEMAT_CIRCUITMK2.get();
                    } else if(itemKey == TItems.NAV_COM.get()){
                        parents = ModItems.NAV_COMMK2.get();
                    } else if(itemKey == TItems.STABILIZERS.get()){
                        parents = ModItems.STABILIZERSMK2.get();
                    } else if(itemKey == TItems.INTERSTITIAL_ANTENNA.get()){
                        parents = ModItems.INTERSTITIAL_ANTENNAMK2.get();
                    } else if(itemKey == TItems.CHAMELEON_CIRCUIT.get()){
                        parents = ModItems.CHAMELEON_CIRCUITMK2.get();
                    } else if(itemKey == TItems.SHEILD_GENERATOR.get()){
                        parents = ModItems.SHEILD_GENERATORMK2.get();
                    } else if(itemKey == TItems.TEMPORAL_GRACE.get()){
                        parents = ModItems.TEMPORAL_GRACEMK2.get();
                    }
                    if(inv.getStackInSlot(i).getItem() == this.itemKey || inv.getStackInSlot(i).getItem() == this.parents){
                        return inv.getStackInSlot(i);
                    }

                }
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean canBeUsed() {

        if(console.getWorld().isRemote) {
            updateClientIfNeeded();
            return this.canBeUsed;
        }

        if(!this.isActivated()){

            return false;
        }

        if(this.getItem().isEmpty()) {
            return false;
        }

        return (this.canBeUsed = this.getItem().getDamage() < this.getItem().getMaxDamage());
    }

    public void damage(@Nullable ServerPlayerEntity player, int amt) {
        if(this.console != null && this.console.isBeingTowed())
            return;
        this.getItem().attemptDamageItem(amt, console.getWorld().rand, player);

        //Removes it if less than 0 health
        if(this.getItem().getDamage() >= this.getItem().getMaxDamage())
            this.console.getWorld().getCapability(Capabilities.TARDIS_DATA).ifPresent(cap -> {
                PanelInventory inv = cap.getEngineInventoryForSide(Direction.NORTH);
                for(int i = 0; i < inv.getSlots(); ++i) {
                    if(inv.getStackInSlot(i).getItem() == this.getItemKey() || inv.getStackInSlot(i).getItem() == parents) {
                        inv.setStackInSlot(i, ItemStack.EMPTY);
                        Helper.addTardisStatistic(player, TardisStatistics.SUBSYSTEMS_BROKEN);
                        break;
                    }
                }
            });
        if(!this.canBeUsed()) {
            this.onBreak();
        }

        this.updateClientIfNeeded();
    }

    public boolean isActivated() {
        return this.isActivated;
    }

}
