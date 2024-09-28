package net.tadditions.mod.flight_events;

import net.minecraft.core.Direction;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.control.ControlType;
import net.tardis.mod.control.datas.ControlData;
import net.tardis.mod.flight_event.FlightEvent;
import net.tardis.mod.flight_event.FlightEventType;
import net.tardis.mod.registry.ControlRegistry;
import net.tardis.mod.registry.SubsystemRegistry;

import java.util.List;

public class VectorCalculationErrorFlightEvent extends FlightEvent
{

    public List<ControlType<?>> controls = List.of(ControlRegistry.X.get(), ControlRegistry.Y.get(), ControlRegistry.Z.get());

    public VectorCalculationErrorFlightEvent(FlightEventType type, ITardisLevel level)
    {
        super(type, level);
    }

    @Override
    public boolean onControlUse(ControlData<?> control)
    {
        if(controls.remove(control.getType()))
        {
            if(controls.isEmpty())
                this.complete();

            return true;
        }

        return false;
    }

    @Override
    public void onFail()
    {
        super.onFail();
        this.tardis.getSubsystem(SubsystemRegistry.NAV_COM.get()).ifPresent(sys -> sys.damage(3 + tardis.getLevel().random.nextInt(5)));
        this.tardis.setDestination(this.tardis.getDestination().randomize(this.tardis.getLevel().random, 30));

    }

    @Override
    public void onStart()
    {

    }
}
