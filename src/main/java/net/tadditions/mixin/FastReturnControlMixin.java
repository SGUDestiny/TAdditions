package net.tadditions.mixin;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.tardis.mod.controls.BaseControl;
import net.tardis.mod.controls.FastReturnControl;
import net.tardis.mod.entity.ControlEntity;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FastReturnControl.class)
public abstract class FastReturnControlMixin extends BaseControl {

    public FastReturnControlMixin(ControlRegistry.ControlEntry entry, ConsoleTile console, ControlEntity entity) {
        super(entry, console, entity);
    }

    @Shadow(remap = false) public abstract EntitySize getSize();

    /**
     * @author Zolton
     * @reason FastReturn
     */
    @Overwrite(remap = false)
    public boolean onRightClicked(ConsoleTile console, PlayerEntity player) {
        if(!console.getWorld().isRemote() && console.getLandTime() <= 0) {
            if(console.getCurrentLocation() == console.getDestinationPosition()) {
                SpaceTimeCoord coord = console.getReturnLocation();
                RegistryKey<World> worldKey = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, coord.getDimRL());
                console.setDestination(worldKey, coord.getPos());
                console.setExteriorFacingDirection(coord.getFacing());
                this.startAnimation();
            }
            else{
                console.setDestination(console.getCurrentDimension(),console.getCurrentLocation());
                console.setExteriorFacingDirection(console.getExteriorFacingDirection());
            }
        }
        return true;
    }

    @Shadow(remap = false) public abstract Vector3d getPos();
    @Shadow(remap = false) public abstract SoundEvent getFailSound(ConsoleTile console);
    @Shadow(remap = false) public abstract SoundEvent getSuccessSound(ConsoleTile console);
    @Shadow(remap = false) public abstract CompoundNBT serializeNBT();
    @Shadow(remap = false) public abstract void deserializeNBT(CompoundNBT nbt);
}
