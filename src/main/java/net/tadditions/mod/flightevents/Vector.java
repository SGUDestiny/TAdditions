package net.tadditions.mod.flightevents;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class Vector extends FlightEvent {

    public Vector(FlightEventFactory entry, ArrayList<ResourceLocation> loc) {
        super(entry, loc);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.X.get().getRegistryName(),
            ControlRegistry.Y.get().getRegistryName(),
            ControlRegistry.Z.get().getRegistryName()
    );

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        Random rand = tile.getWorld().rand;
        tile.setDestination(tile.getDestinationDimension(), tile.getDestinationPosition().add(-10 + rand.nextInt(1000), -10 + rand.nextInt(1000), -10 + rand.nextInt(1000)));

    }
}
