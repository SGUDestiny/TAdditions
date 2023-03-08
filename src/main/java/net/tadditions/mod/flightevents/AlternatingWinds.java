package net.tadditions.mod.flightevents;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.ArrayList;
import java.util.function.Supplier;

public class AlternatingWinds extends FlightEvent {

    public AlternatingWinds(FlightEventFactory entry, ArrayList<ResourceLocation> loc) {
        super(entry, loc);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.THROTTLE.get().getRegistryName(),
            ControlRegistry.RANDOM.get().getRegistryName()
    );

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.setDestinationReachedTick(tile.getReachDestinationTick() + 400);
    }
}
