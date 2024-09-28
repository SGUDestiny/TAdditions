package net.tadditions.mod.flight_events;

import net.tadditions.mod.flight_effects.TimeStormEffect;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.control.ControlType;
import net.tardis.mod.control.datas.ControlData;
import net.tardis.mod.flight_event.FlightEvent;
import net.tardis.mod.flight_event.FlightEventType;
import net.tardis.mod.misc.landing.TardisLandingContext;
import net.tardis.mod.registry.ControlRegistry;

import java.util.List;

public class TimeStormFlightEvent extends FlightEvent
{
    public List<ControlType<?>> controls = List.of(ControlRegistry.RANDOMIZER.get(), ControlRegistry.INCREMENT.get(), ControlRegistry.THROTTLE.get());

    public TimeStormFlightEvent(FlightEventType type, ITardisLevel level)
    {
        super(type, level);
    }

    @Override
    public boolean onControlUse(ControlData<?> control)
    {
        if(controls.get(0).equals(control.getType()) && controls.remove(control.getType()))
        {
            if(controls.isEmpty())
                this.complete();

            return true;
        }
        else tardis.crash(TardisLandingContext.basic(tardis));


        return false;
    }

    @Override
    public void complete()
    {
        super.complete();
        this.tardis.addFlightDurationEffect(new TimeStormEffect());
    }

    @Override
    public void onFail()
    {
        super.onFail();
        this.tardis.crash(TardisLandingContext.basic(tardis));
    }

    @Override
    public void onStart()
    {

    }
}
