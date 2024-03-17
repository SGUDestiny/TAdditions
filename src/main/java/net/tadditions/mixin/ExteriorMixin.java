package net.tadditions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.helper.IExteriorHelp;
import net.tardis.mod.Tardis;
import net.tardis.mod.boti.BotiHandler;
import net.tardis.mod.boti.WorldShell;
import net.tardis.mod.client.animation.IExteriorAnimation;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.energy.TardisEnergy;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.misc.TexVariant;
import net.tardis.mod.registries.ExteriorAnimationRegistry;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mixin(ExteriorTile.class)
public class ExteriorMixin implements IExteriorHelp {

    private boolean cloaked;

    @Inject(at = @At(value = "HEAD"), method = "read(Lnet/minecraft/block/BlockState;Lnet/minecraft/nbt/CompoundNBT;)V")
    public void read(BlockState state, CompoundNBT compound, CallbackInfo ci) {
        this.cloaked = compound.getBoolean("cloaked");
    }

    @Inject(at = @At(value = "HEAD"), method = "write(Lnet/minecraft/nbt/CompoundNBT;)Lnet/minecraft/nbt/CompoundNBT;")
    public void write(CompoundNBT compound, CallbackInfoReturnable<CompoundNBT> cir) {
        compound.putBoolean("cloaked", this.cloaked);
    }

    @Override
    public boolean getCloaked() {
        return cloaked;
    }

    @Override
    public void setCloaked(boolean cloakedState) {
        this.cloaked = cloakedState;
    }
}
