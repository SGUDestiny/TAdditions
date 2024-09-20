package net.tadditions.mod.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.povstalec.sgjourney.common.block_entities.stargate.AbstractStargateEntity;
import net.povstalec.sgjourney.common.data.StargateNetwork;
import net.povstalec.sgjourney.common.data.Universe;
import net.povstalec.sgjourney.common.events.custom.StargateEvent;
import net.povstalec.sgjourney.common.stargate.Address;
import net.povstalec.sgjourney.common.stargate.Stargate;
import net.povstalec.sgjourney.common.stargate.StargateConnection;
import net.tadditions.mod.TemporalAdditionsMod;

import java.util.Optional;
import java.util.Random;

public class StargateJourney
{
    public static void stargate()
    {
        MinecraftForge.EVENT_BUS.register(new StargateJourney());
        TemporalAdditionsMod.LOGGER.info("Stargate Journey detected! Enabling Compatability Features");
    }

    @SubscribeEvent
    public static void onStargateConnect(final StargateEvent.Connect event)
    {
        Random random = new Random();
        if (event.getConnectedStargate().getDimension().location().equals(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "the_verge_of_reality")))
        {
            event.setCanceled(true);
            event.getStargate().getStargateEntity(event.getServer()).ifPresent(stargate -> stargate.resetStargate(Stargate.Feedback.UNKNOWN_ERROR));
        }
        if(event.getStargate().getDimension().location().equals(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "the_verge_of_reality")))
        {
            event.setCanceled(true);
            event.getServer().overworld().getPlayers(player -> true);
        }
        if(random.nextBoolean())
        {
            event.setCanceled(true);
            Universe.get(event.getServer()).getSolarSystemFromExtragalacticAddress(new Address.Immutable(new Address(new int[]{0}))).ifPresent(system -> StargateNetwork.findStargates(event.getServer().getLevel(system.getDimensions().get(0))));
            Optional<Stargate> stargate = Universe.get(event.getServer()).getSolarSystemFromExtragalacticAddress(new Address.Immutable(new Address(new int[]{0}))).flatMap(solarSystemFromExtragalacticAddress -> solarSystemFromExtragalacticAddress.getRandomStargate(event.getServer().getLevel(event.getStargate().getDimension()).getSeed()));
            AbstractStargateEntity sg = stargate.flatMap(optionalStargate -> optionalStargate.getStargateEntity(event.getServer())).get();
            StargateConnection connection = StargateConnection.create(StargateConnection.Type.INTERSTELLAR, event.getStargate().getStargateEntity(event.getServer()).get(), sg, true);
            StargateNetwork.get(event.getServer()).addConnection(connection);
        }
    }
}
