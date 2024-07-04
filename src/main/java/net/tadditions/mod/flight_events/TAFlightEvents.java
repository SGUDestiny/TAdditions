package net.tadditions.mod.flight_events;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tardis.mod.flight_event.AddArtronFlightEvent;
import net.tardis.mod.flight_event.FlightEventType;
import net.tardis.mod.flight_event.TimeWindsEvent;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.registry.FlightEventRegistry;

import java.util.function.Supplier;

public class TAFlightEvents {
    public static final DeferredRegister<FlightEventType> FLIGHT_EVENTS = DeferredRegister.create(Helper.createRL("flight_event"), TemporalAdditionsMod.MOD_ID);
    public static final Supplier<IForgeRegistry<FlightEventType>> REGISTRY;
    public static final RegistryObject<FlightEventType> CENTRIFUGAL_OVERDRIVE;

    public TAFlightEvents()
    {}

    static {
        REGISTRY = FLIGHT_EVENTS.makeRegistry(RegistryBuilder::new);
        CENTRIFUGAL_OVERDRIVE = FLIGHT_EVENTS.register("centrifugal_overdrive", () -> new FlightEventType(2.0F, CentrifugalOverdriveEvent::new, CentrifugalOverdriveEvent.SHOULD_HAPPEN));
    }
}
