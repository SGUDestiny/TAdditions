package net.tadditions.mod.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tadditions.mod.TemporalAdditionsMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(modid = TemporalAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TabInit {
    public static CreativeModeTab TADDITIONS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        TADDITIONS_TAB = event.registerCreativeModeTab(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "tadditions_tab"),
                builder -> builder.icon(() -> new ItemStack(ItemInit.ARTRON_CAPACITOR_TEMPORAL.get()))
                        .title(Component.translatable("creativemodetab.tadditions_tab")));
    }
}
