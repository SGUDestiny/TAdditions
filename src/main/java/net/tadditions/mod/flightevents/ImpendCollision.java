package net.tadditions.mod.flightevents;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Explosion;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.misc.CrashType;
import net.tardis.mod.misc.ObjectWrapper;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ImpendCollision extends FlightEvent {

    public ImpendCollision(FlightEventFactory entry, ArrayList<ResourceLocation> loc) {
        super(entry, loc);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.STABILIZERS.get().getRegistryName(),
            ControlRegistry.TELEPATHIC.get().getRegistryName(),
            ControlRegistry.THROTTLE.get().getRegistryName()
    );

    public boolean onComplete(ConsoleTile tile) {
        boolean complete = super.onComplete(tile);

        if(complete) {

            tile.damage(800F);
            tile.setDestination(MDimensions.TAGREA, tile.getDestinationPosition());
            tile.setDestinationReachedTick(200);
            tile.updateClient();
        }

        return complete;
    }

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.damage(1200F);
        tile.setDestination(MDimensions.TAGREA, tile.getDestinationPosition());
        tile.setDestinationReachedTick(200);
        tile.crash(new CrashType(100,100F,true));
        tile.getWorld().createExplosion(tile.getEntity(), 10,10,10,10, Explosion.Mode.NONE);
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
