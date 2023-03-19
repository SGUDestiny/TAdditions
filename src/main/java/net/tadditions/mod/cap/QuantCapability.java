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
import java.util.Random;

public class QuantCapability implements IQuant {


    private final ItemStack remote;
    private int time = 0;
    private boolean generated = false;
    private boolean paused = false;

    public QuantCapability(ItemStack stack) {
        this.remote = stack;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("time", this.time);
        tag.putBoolean("generated", this.generated);
        tag.putBoolean("paused", this.paused);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.generated = nbt.getBoolean("generated");
        this.time = nbt.getInt("time");
        this.paused = nbt.getBoolean("paused");
    }

    @Override
    public int getTimer() {
        return this.time;
    }

    @Override
    public void setTimer(int time) {
        this.time = time;
    }

    @Override
    public boolean getGenerated() {
        return this.generated;
    }

    @Override
    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    @Override
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    @Override
    public boolean isPaused() {
        return this.paused;
    }


    @Override
    public void tick(World world, Entity ent) {
        Random random = world.rand;
        if (!world.isRemote) {
            if (world.getGameTime() % 40 == 0) {
                if (this.getGenerated()) {
                    if (this.isPaused()) {
                        this.setTimer(this.getTimer());
                    }
                    if (!this.isPaused()) {
                        this.setTimer(this.getTimer() - 1);
                    }
                }
                if(!this.getGenerated()){
                    this.setTimer((int) (random.nextFloat() * 100));
                    this.setGenerated(true);
                }
                if(this.getTimer() == 0 && this.getGenerated()){
                    this.remote.shrink(1);
                    this.setGenerated(false);
                }
            }
        }
    }


}
