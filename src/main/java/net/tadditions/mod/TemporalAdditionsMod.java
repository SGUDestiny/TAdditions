package net.tadditions.mod;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.tadditions.mod.client.level.TADimensionSpecialEffects;
import net.tadditions.mod.client.phenomena.EntropicDriftPhenomenaRenderer;
import net.tadditions.mod.client.phenomena.TimeStormPhenomenaRenderer;
import net.tadditions.mod.compat.StargateJourney;
import net.tadditions.mod.init.*;
import net.tadditions.mod.item.VergeGateOpener;
import net.tardis.mod.client.gui.monitor.MonitorFlightCourseScreen;
import net.tardis.mod.item.ItemRegistry;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TemporalAdditionsMod.MOD_ID)
public class TemporalAdditionsMod {
    public static final String MOD_ID = "tadditions";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String STARGATE_JOURNEY = "sgjourney";

    public TemporalAdditionsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);
        StructureInit.register(modEventBus);
        PhenomenaInit.register(modEventBus);
        FlightEventInit.register(modEventBus);
        UpgradeInit.register(modEventBus);

        BlockEntityInit.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::register);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        if(ModList.get().isLoaded(STARGATE_JOURNEY))
            StargateJourney.stargate();
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == TabInit.TADDITIONS_TAB) {
            event.accept(ItemInit.ARTRON_CAPACITOR_TEMPORAL);
            event.accept(ItemInit.ARTRON_CAPACITOR_QUANTUM);
            event.accept(ItemInit.ARTRON_CAPACITOR_VORTEX);
            //event.accept(ItemInit.UPGRADE_ENTROPIC_DRIFTING);
            event.accept(BlockInit.ASH);
            event.accept(BlockInit.DENSE_ASH);
            event.accept(BlockInit.FROSTBEARING_DUST);
            event.accept(BlockInit.FROSTBEARING_ROCK);

            Item opener = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MOD_ID, "verge_gate_opener"));
            if(ModList.get().isLoaded(STARGATE_JOURNEY) && opener != null)
                event.accept(opener);
        }
    }

    public void register(RegisterEvent event)
    {
        if(ModList.get().isLoaded(STARGATE_JOURNEY))
        {
            event.register(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation(MOD_ID, "verge_gate_opener"), () -> new VergeGateOpener(new Item.Properties().stacksTo(1)));
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MonitorFlightCourseScreen.registerVortexPhenomenaRenderer(new EntropicDriftPhenomenaRenderer());
            MonitorFlightCourseScreen.registerVortexPhenomenaRenderer(new TimeStormPhenomenaRenderer());
        }

        @SubscribeEvent
        public static void registerDimensionalEffects(RegisterDimensionSpecialEffectsEvent event)
        {
            TADimensionSpecialEffects.registerTemporalAdditionsEffects(event);
        }
    }
}
