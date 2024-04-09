package net.tadditions.mod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tadditions.mod.TemporalAdditionsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = TemporalAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TACreativeModeTabs {
    public static CreativeModeTab TADDITIONS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TADDITIONS_TAB = event.registerCreativeModeTab(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "tadditions_tab"),
                builder -> builder.icon(() -> new ItemStack(TAItems.ARTRON_CAPACITOR_TEMPORAL.get()))
                        .title(Component.translatable("creativemodetab.tadditions_tab")));
    }
}
