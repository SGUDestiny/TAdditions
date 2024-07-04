package net.tadditions.mod.event;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.povstalec.sgjourney.common.block_entities.stargate.AbstractStargateEntity;
import net.povstalec.sgjourney.common.data.StargateNetwork;
import net.povstalec.sgjourney.common.data.Universe;
import net.povstalec.sgjourney.common.events.custom.StargateEvent;
import net.povstalec.sgjourney.common.stargate.Address;
import net.povstalec.sgjourney.common.stargate.SolarSystem;
import net.povstalec.sgjourney.common.stargate.Stargate;
import net.povstalec.sgjourney.common.stargate.StargateConnection;
import net.tadditions.mod.TemporalAdditionsMod;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Mod.EventBusSubscriber(modid = TemporalAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onStargateConnect(final StargateEvent.Connect event) {
        Random random = new Random();
        if (event.getConnectedStargate().getDimension().location().equals(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "the_verge_of_reality"))) {
            event.setCanceled(true);
            event.getStargate().getStargateEntity(event.getServer()).ifPresent(stargate -> stargate.resetStargate(Stargate.Feedback.UNKNOWN_ERROR));
        }
        if(event.getStargate().getDimension().location().equals(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "the_verge_of_reality"))){
           event.setCanceled(true);
           List<ResourceKey<Level>> dimensions = Universe.get(event.getServer()).getDimensionsWithGeneratedSolarSystems();
           SolarSystem.Serializable system = Universe.get(event.getServer()).getSolarSystemFromDimension(dimensions.get(random.nextInt(dimensions.size()))).get();
           Stargate stargate = system.getRandomStargate(event.getServer().getLevel(event.getStargate().getDimension()).getSeed()).get();
           StargateConnection connection = StargateConnection.create(StargateConnection.Type.INTERSTELLAR, event.getStargate().getStargateEntity(event.getServer()).get(), stargate.getStargateEntity(event.getServer()).get(), true);
           StargateNetwork.get(event.getServer()).addConnection(connection);
           stargate.getStargateEntity(event.getServer()).ifPresent(cap -> cap.setEngagedChevrons(new int[]{}));
        }
        if(random.nextBoolean()){
            event.setCanceled(true);
            Universe.get(event.getServer()).getSolarSystemFromExtragalacticAddress(new Address.Immutable(new Address(new int[]{0}))).ifPresent(system -> StargateNetwork.findStargates(event.getServer().getLevel(system.getDimensions().get(0))));
            Optional<Stargate> stargate = Universe.get(event.getServer()).getSolarSystemFromExtragalacticAddress(new Address.Immutable(new Address(new int[]{0}))).get().getRandomStargate(event.getServer().getLevel(event.getStargate().getDimension()).getSeed());
            AbstractStargateEntity sg = stargate.get().getStargateEntity(event.getServer()).get();
            StargateConnection connection = StargateConnection.create(StargateConnection.Type.INTERSTELLAR, event.getStargate().getStargateEntity(event.getServer()).get(), sg, true);
            StargateNetwork.get(event.getServer()).addConnection(connection);
        }
    }

}
