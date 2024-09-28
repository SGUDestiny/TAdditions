package net.tadditions.mod.flight_effects;

import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.cap.level.TardisCap;
import net.tardis.mod.misc.tardis.IFlightDurationEffect;

public class TimeStormEffect implements IFlightDurationEffect
{
    public int timePassed = 0;

    @Override
    public void onFlightTick(ITardisLevel tardis)
    {
        timePassed++;
        if(timePassed/20 > 60)
            ((TardisCap) tardis).effects.remove(this);
    }

    @Override
    public void onTardisLand(ITardisLevel tardis)
    {

    }
}
