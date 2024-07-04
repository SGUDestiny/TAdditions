package net.tadditions.mod.flight_events;

import net.tadditions.mod.item.TAItems;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.control.ControlType;
import net.tardis.mod.control.datas.ControlData;
import net.tardis.mod.control.datas.ControlDataFloat;
import net.tardis.mod.flight_event.FlightEvent;
import net.tardis.mod.flight_event.FlightEventType;
import net.tardis.mod.misc.tardis.TardisEngine;
import net.tardis.mod.registry.ControlRegistry;

import java.util.function.Predicate;

public class CentrifugalOverdriveEvent extends FlightEvent {
    public static final Predicate<ITardisLevel> SHOULD_HAPPEN = (tardis) -> tardis.getEngine().getInventoryFor(TardisEngine.EngineSide.SUBSYSTEMS).getStackInSlot(0).getItemHolder().get().equals(TAItems.ARTRON_CAPACITOR_TEMPORAL.get());

    public CentrifugalOverdriveEvent(FlightEventType type, ITardisLevel level) {
        super(type, level);
    }

    @Override
    public boolean onControlUse(ControlData<?> controlData) {
        return false;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFail() {
        super.onFail();
        this.tardis.getEmotionalHandler().modMood(-100);
    }
}
