package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.DoorControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(DoorControl.class)
public abstract class DoorControlMixin extends BaseControl {
    public DoorControlMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }

    /**
     * @author Zolton21
     * @reason Control didn't lock exterior doors
     */
    @Overwrite(remap = false)
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {
        boolean lock = player.isSneaking();
        if(!console.getWorld().isRemote()) {
            for(DoorEntity ent : console.getWorld().getEntitiesWithinAABB(DoorEntity.class, new AxisAlignedBB(console.getPos()).grow(25))) {
                if(lock) {
                    if (ent.isDeadLocked()) {
                        player.sendStatusMessage(ExteriorBlock.DEADLOCKED, true);
                    }
                    else {
                        ent.setLocked(!ent.isLocked());
                        ent.playSound(ent.isLocked() ? TSounds.DOOR_LOCK.get() : TSounds.DOOR_UNLOCK.get(), 1F, 1F);
                        player.sendStatusMessage(ent.isLocked() ? ExteriorBlock.LOCKED : ExteriorBlock.UNLOCKED, true);
                        ent.setOpenState(EnumDoorState.CLOSED);
                        ent.updateExteriorDoorData();
                        break;
                    }
                }
                if(!ent.isDeadLocked()){
                    if (!ent.isLocked()) {
                        if(ent.getOpenState() == EnumDoorState.CLOSED)
                            ent.setOpenState(EnumDoorState.BOTH);
                        else ent.setOpenState(EnumDoorState.CLOSED);
                        ent.playSound(ent.getOpenState() == EnumDoorState.CLOSED ? TSounds.DOOR_CLOSE.get() : TSounds.DOOR_OPEN.get(), 1F, 1F);
                        this.startAnimation();
                    }
                    else player.sendStatusMessage(ExteriorBlock.LOCKED, true);
                }
                else {
                    player.sendStatusMessage(ExteriorBlock.DEADLOCKED, true);
                }
                ent.updateExteriorDoorData();
            }
        }
        return true;
    }

    @Shadow public abstract Vector3d getPos();
    @Shadow public abstract SoundEvent getFailSound(ConsoleTile console);
    @Shadow public abstract SoundEvent getSuccessSound(ConsoleTile console);
    @Shadow public abstract CompoundNBT serializeNBT();
    @Shadow public abstract void deserializeNBT(CompoundNBT nbt);
}
