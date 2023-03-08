package net.tadditions.mod.flightevents;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.config.MConfigs;
import net.tardis.mod.flight.*;
import net.tardis.mod.flight.FlightEventFactory.IFlightEventFactory;
import net.tardis.mod.registries.FlightEventRegistry;

import java.util.ArrayList;
import java.util.function.Supplier;

public class MFlightEvent extends FlightEventRegistry{


    public static final DeferredRegister<FlightEventFactory> FLIGHT_EVENTS = DeferredRegister.create(FlightEventFactory.class, QolMod.MOD_ID);

    public static final RegistryObject<FlightEventFactory> ALTIMEWIND = FLIGHT_EVENTS.register("alternating_time_wind", () -> setupFlightEvent(AlternatingWinds::new, AlternatingWinds.CONTROLS));
    public static final RegistryObject<FlightEventFactory> TIMESTORM = FLIGHT_EVENTS.register("time_storm", () -> setupFlightEvent(TimeStorm::new, TimeStorm.CONTROLS));
    public static final RegistryObject<FlightEventFactory> VECTOR = FLIGHT_EVENTS.register("vector", () -> setupFlightEvent(Vector::new, Vector.CONTROLS));
    public static final RegistryObject<FlightEventFactory> DRIVECORE = FLIGHT_EVENTS.register("drive", () -> setupFlightEvent(DriveCore::new, DriveCore.CONTROLS, false));
    public static final RegistryObject<FlightEventFactory> BASINS = FLIGHT_EVENTS.register("basins", () -> setupFlightEvent(Basins::new, Basins.CONTROLS, false));
    public static final RegistryObject<FlightEventFactory> HULLBREACH = FLIGHT_EVENTS.register("hullbreach", () -> setupFlightEvent(HullBreach::new, HullBreach.CONTROLS, false));
    public static final RegistryObject<FlightEventFactory> COLLISION = FLIGHT_EVENTS.register("collision", () -> setupFlightEvent(ImpendCollision::new, ImpendCollision.CONTROLS, false));


    public static FlightEventFactory setupFlightEvent(IFlightEventFactory<FlightEvent> event, Supplier<ArrayList<ResourceLocation>> sequence){
        FlightEventFactory fact = new FlightEventFactory(event, sequence);
        return fact;
    }
    
    public static FlightEventFactory setupFlightEvent(IFlightEventFactory<FlightEvent> event, Supplier<ArrayList<ResourceLocation>> sequence, boolean normal) {
        FlightEventFactory fact = setupFlightEvent(event, sequence);
        fact.setNormal(false);
        return fact;
    }

    //Call in server setup or FMLStartupEvent
    public static void addRandomEvent(int weight, FlightEventFactory event){
        FlightEventRegistry.RANDOM_EVENTS.addChance(weight, event);
    }

    public static void registerRandomEntries() {
        addRandomEvent(MConfigs.COMMON.AlternatingWindRarity.get(), ALTIMEWIND.get());
        addRandomEvent(MConfigs.COMMON.VectorErrorRarity.get(), VECTOR.get());
        addRandomEvent(MConfigs.COMMON.StormRarity.get(), TIMESTORM.get());
    }
}
