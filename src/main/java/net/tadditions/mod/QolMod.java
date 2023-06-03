package net.tadditions.mod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.cap.*;
import net.tadditions.mod.config.MConfigs;
import net.tadditions.mod.container.MContainers;
import net.tadditions.mod.events.CommonEvents;
import net.tadditions.mod.flightevents.MFlightEvent;
import net.tadditions.mod.fluids.MFluids;
import net.tadditions.mod.helper.*;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.items.Murasama;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.protocol.MProtocolRegistry;
import net.tadditions.mod.recipe.TARecipeSerialisers;
import net.tadditions.mod.sound.MSounds;
import net.tadditions.mod.tileentity.ModTileEntitys;
import net.tadditions.mod.traits.MTraits;
import net.tadditions.mod.upgrades.MUpgradeRegistry;
import net.tadditions.mod.world.biomes.MBiomes;
import net.tadditions.mod.world.carver.MCarvers;
import net.tadditions.mod.world.features.MFeatures;
import net.tadditions.mod.world.structures.MStructures;
import net.tadditions.mod.world.surfacebuilders.MCSB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(QolMod.MOD_ID)
public class QolMod
{
    public static final String MOD_ID = "tadditions";


    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    public QolMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(eventBus);
        MUpgradeRegistry.UPGRADES.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModTileEntitys.TILES.register(eventBus);
        MFlightEvent.FLIGHT_EVENTS.register(eventBus);
        MContainers.CONTAINERS.register(eventBus);
        MTraits.TRAITS.register(eventBus);
        MProtocolRegistry.PROTOCOLS.register(eventBus);
        TARecipeSerialisers.RECIPE_SERIALISERS.register(eventBus);
        MBiomes.BIOMES.register(eventBus);
        MFluids.register(eventBus);
        MFeatures.FEATURES.register(eventBus);
        MCarvers.CARVERS.register(eventBus);
        MStructures.Structures.STRUCTURES.register(eventBus);
        MCSB.SurfaceBuilders.SURFACE_BUILDERS.register(eventBus);
        MExteriorAnimationRegistry.EXTERIOR_ANIMATIONS.register(eventBus);
        MSoundSchemeRegistry.SOUND_SCHEMES.register(eventBus);
        MExteriorRegistry.EXTERIORS.register(eventBus);
        MSounds.SOUND_EVENT.register(eventBus);




        eventBus.addListener(this::setup);

        eventBus.addListener(this::enqueueIMC);

        eventBus.addListener(this::processIMC);

        eventBus.addListener(this::doClientStuff);


        MNetwork.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MConfigs.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MConfigs.SERVER_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
                {
                    MFlightEvent.registerRandomEntries();
                    MBiomes.registerBiomeKeys();
                    MTraits.registerRarities();
                    MStructures.setupStructures();
                    MStructures.ConfiguredStructures.registerConfiguredStructures();
                    MFeatures.registerConfiguredFeatures();
                });
        CommonEvents.getAllMappingEntries();
        CraftingHelper.register(TrueConCondition.Serializer.INSTANCE);
        CapabilityManager.INSTANCE.register(IOneRemote.class, new IOneRemote.Storage(), () -> new OneUseRemoteCapability(null));
        CapabilityManager.INSTANCE.register(IOpener.class, new IOpener.Storage(), () -> new TagreaOpenerCap(null));
        CapabilityManager.INSTANCE.register(IQuant.class, new IQuant.Storage(), () -> new QuantCapability(null));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        RenderTypeLookup.setRenderLayer(ModBlocks.foodmaker.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.advanced_quantiscope_iron.get(), RenderType.getCutout());

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

        InterModComms.sendTo("tadditions", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        }
    }

}