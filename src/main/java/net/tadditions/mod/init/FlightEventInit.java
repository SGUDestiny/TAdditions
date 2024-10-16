package net.tadditions.mod.init;

import net.minecraft.core.Direction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.flight_events.TimeStormFlightEvent;
import net.tadditions.mod.flight_events.VectorCalculationErrorFlightEvent;
import net.tardis.mod.Tardis;
import net.tardis.mod.flight_event.AxisMissFlightEvent;
import net.tardis.mod.flight_event.FlightEventType;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.registry.ControlRegistry;
import net.tardis.mod.registry.FlightEventRegistry;

public class FlightEventInit
{
    public static final DeferredRegister<FlightEventType> FLIGHT_EVENTS = DeferredRegister.create(FlightEventRegistry.REGISTRY.get(), TemporalAdditionsMod.MOD_ID);

    public static final RegistryObject<FlightEventType> VECTOR_CALCULATION_ERROR  = FLIGHT_EVENTS.register("vector_calculation_error", () -> new FlightEventType(0.15F, VectorCalculationErrorFlightEvent::new));

    public static final RegistryObject<FlightEventType> TIME_STORM = FLIGHT_EVENTS.register("time_storm", () -> new FlightEventType(0.0F, TimeStormFlightEvent::new).notNatural());

    public static void register(IEventBus bus)
    {
        FLIGHT_EVENTS.register(bus);
    }
}
