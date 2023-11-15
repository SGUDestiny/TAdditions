package net.tadditions.mod.flightevents;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.misc.CrashTypes;
import net.tardis.mod.misc.ObjectWrapper;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.ArrayList;
import java.util.function.Supplier;

public class TimeStorm extends FlightEvent {

    public TimeStorm(FlightEventFactory entry, ArrayList<ResourceLocation> loc) {
        super(entry, loc);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.RANDOM.get().getRegistryName(),
            ControlRegistry.INC_MOD.get().getRegistryName(),
            ControlRegistry.THROTTLE.get().getRegistryName()
    );

    public boolean onComplete(ConsoleTile tile) {
        boolean complete = super.onComplete(tile);

        if(complete) {

            tile.setDestinationReachedTick((int) (tile.getReachDestinationTick()*0.98));
            tile.updateClient();
        }

        return complete;
    }

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.damage(150F);
        tile.crash(CrashTypes.DEFAULT);
        tile.updateClient();
    }

    @Override
    public int calcTime(ConsoleTile console) {

        ObjectWrapper<Float> wrapper = new ObjectWrapper<Float>(0.0F);

        console.getControl(ThrottleControl.class).ifPresent(throt -> wrapper.setValue(throt.getAmount()));
        float amt = wrapper.getValue();

        int seconds = TConfig.SERVER.controlTime.get() * 60;

        //flight time + 5 seconds for base + 0-5 seconds depending on throttle
        return this.timeUntilMiss = console.flightTicks + seconds + (int)Math.floor((1.0F - amt) * seconds);
    }
}
