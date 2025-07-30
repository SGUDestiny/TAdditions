package net.tadditions.mod.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.povstalec.sgjourney.common.block_entities.stargate.AbstractStargateEntity;
import net.povstalec.sgjourney.common.data.StargateNetwork;
import net.povstalec.sgjourney.common.data.Universe;
import net.povstalec.sgjourney.common.events.custom.StargateEvent;
import net.povstalec.sgjourney.common.sgjourney.Address;
import net.povstalec.sgjourney.common.sgjourney.StargateConnection;
import net.povstalec.sgjourney.common.sgjourney.StargateInfo;
import net.povstalec.sgjourney.common.sgjourney.stargate.Stargate;
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
    public void onStargateConnect(final StargateEvent.Connect event)
    {

    }
}
