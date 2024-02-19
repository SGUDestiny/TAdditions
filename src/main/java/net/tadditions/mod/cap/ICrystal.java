package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public interface ICrystal extends INBTSerializable<CompoundNBT> {

    void setCoords(BlockPos pos);
    BlockPos getCoords();
    int getType();
    void setType(int type);
    void setDimData(RegistryKey<World> world);
    boolean getUsed();
    void setUsed(boolean used);
    RegistryKey<World> getDimData();
    void tick(World world, Entity entity);

    public static class Storage implements Capability.IStorage<ICrystal> {

        @Override
        public INBT writeNBT(Capability<ICrystal> capability, ICrystal instance, Direction side) {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<ICrystal> capability, ICrystal instance, Direction side, INBT nbt) {
            if (nbt instanceof CompoundNBT)
                instance.deserializeNBT((CompoundNBT) nbt);
        }

    }

    class Provider implements ICapabilitySerializable<CompoundNBT> {

        ICrystal remote;

        public Provider(ICrystal rem) {
            this.remote = rem;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == MCapabilities.CRYSTAL_CAPABILITY ? (LazyOptional<T>) LazyOptional.of(() -> remote) : LazyOptional.empty();
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
