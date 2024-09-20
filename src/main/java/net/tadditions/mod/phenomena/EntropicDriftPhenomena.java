package net.tadditions.mod.phenomena;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;
import net.tadditions.mod.flight_effects.EntropicDriftingEffect;
import net.tadditions.mod.init.UpgradeInit;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.misc.tardis.vortex.VortexPhenomenaType;
import net.tardis.mod.misc.tardis.vortex.VortexPheonomena;

public class EntropicDriftPhenomena extends VortexPheonomena
{
    public EntropicDriftPhenomena(VortexPhenomenaType<?> type, ChunkPos pos)
    {
        super(type, pos, 4);
    }

    @Override
    public void onTardisEnter(ITardisLevel tardis)
    {
        if(tardis.getUpgrades().stream().noneMatch(upgrade -> UpgradeInit.TARDIS_DRIFT.get().canBeUsed(upgrade.getInstance())))
            return;

        tardis.addFlightDurationEffect(new EntropicDriftingEffect());
    }

    @Override
    public void onTardisLeave(ITardisLevel tardis)
    {

    }



    @Override
    public CompoundTag serializeNBT()
    {
        return super.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {

    }
}
