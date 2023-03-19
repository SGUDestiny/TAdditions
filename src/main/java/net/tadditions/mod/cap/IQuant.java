package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.tardis.mod.misc.SpaceTimeCoord;

public interface IQuant extends INBTSerializable<CompoundNBT> {

    int getTimer();

    void setTimer(int time);

    boolean getGenerated();

    void setGenerated(boolean generated);

    void setPaused(boolean paused);

    boolean isPaused();


    void tick(World world, Entity ent);


    public static class Storage implements Capability.IStorage<IQuant> {

        @Override
        public INBT writeNBT(Capability<IQuant> capability, IQuant instance, Direction side) {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IQuant> capability, IQuant instance, Direction side, INBT nbt) {
            if (nbt instanceof CompoundNBT)
                instance.deserializeNBT((CompoundNBT) nbt);
        }

    }

    class Provider implements ICapabilitySerializable<CompoundNBT> {

        IQuant remote;

        public Provider(IQuant rem) {
            this.remote = rem;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == MCapabilities.QUANT_CAPABILITY ? (LazyOptional<T>) LazyOptional.of(() -> remote) : LazyOptional.empty();
        }

        @Override
        public CompoundNBT serializeNBT() {
            return remote.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundNBT nbt) {
            remote.deserializeNBT(nbt);
        }

    }
}
