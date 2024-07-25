package net.tadditions.mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tadditions.mod.client.level.TADimensionSpecialEffects;
import net.tadditions.mod.init.*;
import net.tardis.mod.item.components.ArtronCapacitorItem;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TemporalAdditionsMod.MOD_ID)
public class TemporalAdditionsMod {
    public static final String MOD_ID = "tadditions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TemporalAdditionsMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);
        StructureInit.register(modEventBus);

        BlockEntityInit.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {



    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {

        if(event.getTab() == TabInit.TADDITIONS_TAB) {
            event.accept(ItemInit.ARTRON_CAPACITOR_TEMPORAL);
            event.accept(ItemInit.ARTRON_CAPACITOR_ULTRA);
            event.accept(ItemInit.ARTRON_CAPACITOR_SPEED);
            event.accept(BlockInit.ASH);
            event.accept(BlockInit.DENSE_ASH);
            ItemStack stack = new ItemStack(ItemInit.ARTRON_CAPACITOR_TEMPORAL.get());
            if(stack.getItem() instanceof ArtronCapacitorItem capacitor)
                capacitor.setDamage(stack, 100);
            event.accept(stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

        @SubscribeEvent
        public static void registerDimensionalEffects(RegisterDimensionSpecialEffectsEvent event)
        {
            TADimensionSpecialEffects.registerTemporalAdditionsEffects(event);
        }
    }
}
