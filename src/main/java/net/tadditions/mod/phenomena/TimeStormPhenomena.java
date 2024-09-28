package net.tadditions.mod.phenomena;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.tadditions.mod.init.FlightEventInit;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.misc.tardis.vortex.VortexPhenomenaType;
import net.tardis.mod.misc.tardis.vortex.VortexPheonomena;

public class TimeStormPhenomena extends VortexPheonomena
{

    public TimeStormPhenomena(VortexPhenomenaType<?> type, ChunkPos pos)
    {
        super(type, pos, 30);
    }

    @Override
    public void onGenerated(ServerLevel level)
    {
        super.onGenerated(level);

    }

    @Override
    public void onTardisEnter(ITardisLevel tardis)
    {
        tardis.setCurrentFlightEvent(FlightEventInit.TIME_STORM.get());
    }

    @Override
    public void onTardisLeave(ITardisLevel tardis)
    {

    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {

    }
}
