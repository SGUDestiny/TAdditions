package net.tadditions.mod.event;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.client.screens.PhasingQuantascopeScreen;
import net.tadditions.mod.client.screens.SonicQuantascopeScreen;
import net.tadditions.mod.client.screens.SonicUpgradeQuantascopeScreen;
import net.tadditions.mod.client.screens.WeldingQuantascopeScreen;
import net.tadditions.mod.init.MenuInit;

@Mod.EventBusSubscriber(modid = TemporalAdditionsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        MenuScreens.register(MenuInit.PHASING_QUANTASCOPE.get(), PhasingQuantascopeScreen::new);
        MenuScreens.register(MenuInit.SONIC_QUANTASCOPE.get(), SonicQuantascopeScreen::new);
        MenuScreens.register(MenuInit.SONIC_UPGRADE_QUANTASCOPE.get(), SonicUpgradeQuantascopeScreen::new);
        MenuScreens.register(MenuInit.WELDING_QUANTASCOPE.get(), WeldingQuantascopeScreen::new);
    }
}
