package net.tadditions.mod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tadditions.mod.TemporalAdditionsMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static net.tadditions.mod.TemporalAdditionsMod.MOD_ID;
import static net.tadditions.mod.TemporalAdditionsMod.STARGATE_JOURNEY;

public class TabInit {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> ItemInit.ARTRON_CAPACITOR_TEMPORAL.get().getDefaultInstance())
                    .title(Component.translatable("tabs.thaumaturgy.main_tab"))
                    .displayItems((parameters, output) ->
                    {
                        output.accept(ItemInit.ARTRON_CAPACITOR_TEMPORAL.get());

                        Item opener = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MOD_ID, "verge_gate_opener"));
                        if(ModList.get().isLoaded(STARGATE_JOURNEY) && opener != null)
                            output.accept(opener);
                    })
                    .build());

    public static void register(IEventBus bus)
    {
        TABS.register(bus);
    }
}
