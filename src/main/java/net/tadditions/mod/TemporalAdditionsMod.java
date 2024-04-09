package net.tadditions.mod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tadditions.mod.block.TABlocks;
import net.tadditions.mod.item.TACreativeModeTabs;
import net.tadditions.mod.item.TAItems;
import net.tadditions.mod.worldgen.structures.TAStructures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TemporalAdditionsMod.MOD_ID)
public class TemporalAdditionsMod {
    public static final String MOD_ID = "tadditions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TemporalAdditionsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TAItems.register(modEventBus);
        TABlocks.register(modEventBus);
        TAStructures.register(modEventBus);

        //ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if(event.getTab() == TACreativeModeTabs.TADDITIONS_TAB) {
            event.accept(TAItems.ARTRON_CAPACITOR_TEMPORAL);
            event.accept(TAItems.ARTRON_CAPACITOR_ULTRA);
            event.accept(TAItems.ARTRON_CAPACITOR_SPEED);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}