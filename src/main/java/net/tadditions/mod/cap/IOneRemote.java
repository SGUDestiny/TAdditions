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
import net.tardis.mod.artron.IArtronItemStackBattery;
import net.tardis.mod.misc.SpaceTimeCoord;

public interface IOneRemote extends INBTSerializable<CompoundNBT>, IArtronItemStackBattery {

	ResourceLocation getTardis();
	void setTardis(ResourceLocation tardis);
    SpaceTimeCoord getExteriorLocation();

    float getCharge();
    void setCharge(float charge);

    void setExteriorLocation(SpaceTimeCoord coord);

    double getJourney();

    void setJourneyTime(double time);

    BlockPos getExteriorPos();

    RegistryKey<World> getExteriorDim();

    boolean isInFlight();

    float getFuel();

    void onClick(World world, PlayerEntity player, BlockPos pos);

    void tick(World world, Entity ent);

    /**
     * One time call for if the owner of the Tardis is not set yet
     *
     * @param world
     */
    void findTardis(World world);

    public static class Storage implements Capability.IStorage<IOneRemote> {

        @Override
        public INBT writeNBT(Capability<IOneRemote> capability, IOneRemote instance, Direction side) {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IOneRemote> capability, IOneRemote instance, Direction side, INBT nbt) {
            if (nbt instanceof CompoundNBT)
                instance.deserializeNBT((CompoundNBT) nbt);
        }

    }

    class Provider implements ICapabilitySerializable<CompoundNBT> {

        IOneRemote remote;

        public Provider(IOneRemote rem) {
            this.remote = rem;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == MCapabilities.ONE_REMOTE_CAPABILITY ? (LazyOptional<T>) LazyOptional.of(() -> remote) : LazyOptional.empty();
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
