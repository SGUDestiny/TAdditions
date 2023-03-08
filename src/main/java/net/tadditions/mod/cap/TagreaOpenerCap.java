package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.tadditions.mod.config.MConfigs;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.subsystem.StabilizerSubsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.Objects;

public class TagreaOpenerCap implements IOpener {

    private boolean dimdata;
    private ItemStack remote;

    public TagreaOpenerCap(ItemStack stack) {
        this.remote = stack;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putBoolean("dimdata", this.dimdata);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = nbt.getBoolean("dimdata");
    }

    @Override
    public boolean isDimdata() {
        return this.dimdata;
    }

    @Override
    public void setDimdata(boolean dimdata1) {
        this.dimdata = dimdata1;
    }

    @Override
    public void tick(World worldIn, Entity entityIn) {
        if (!worldIn.isRemote) {
            if (worldIn.getGameTime() % 20 == 0) {
                this.dimdata = isDimdata();
                this.serializeNBT();
            }
        }
    }
}
