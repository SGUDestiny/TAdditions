package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public interface IOpener extends INBTSerializable<CompoundNBT> {


    RegistryKey<World> getDimdata();

    ItemStackHandler getHandler();
    void setDimdata(RegistryKey<World> type);

    void tick(World worldIn, Entity entityIn);

    public static class Storage implements Capability.IStorage<IOpener> {

        @Override
        public INBT writeNBT(Capability<IOpener> capability, IOpener instance, Direction side) {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IOpener> capability, IOpener instance, Direction side, INBT nbt) {
            if (nbt instanceof CompoundNBT)
                instance.deserializeNBT((CompoundNBT) nbt);
        }

    }

    class Provider implements ICapabilitySerializable<CompoundNBT> {

        IOpener remote;

        public Provider(IOpener rem) {
            this.remote = rem;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == MCapabilities.OPENER_CAPABILITY ? (LazyOptional<T>) LazyOptional.of(() -> remote) : LazyOptional.empty();
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
