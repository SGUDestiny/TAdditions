package net.tadditions.mod.client;

import com.google.common.collect.Maps;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.renderers.sky.TagreaSkyRenderer;
import net.tadditions.mod.container.MContainers;
import net.tadditions.mod.screens.AdvQuantiscopeWeldScreen;
import net.tadditions.mod.screens.misc.AdvQuantiscopePage;
import net.tadditions.mod.screens.misc.AdvQuantiscopeScreenType;
import net.tadditions.mod.world.MDimensions;
import net.tadditions.mod.world.MarsSkyProperty;
import net.tadditions.mod.world.TagreaSkyProperty;
import net.tardis.mod.client.TClientRegistry;
import net.tardis.mod.entity.TEntities;
import net.tardis.mod.world.dimensions.MoonSkyProperty;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.EnumMap;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = QolMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MClientRegistry extends TClientRegistry {


    public static final EnumMap<AdvQuantiscopeScreenType, AdvQuantiscopePage> ADVQUANTISCOPE_SCREENS = Maps.newEnumMap(AdvQuantiscopeScreenType.class);


    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        registerScreens();
        DimensionRenderInfo.field_239208_a_.put(MDimensions.MARS_SKY_PROPERTY_KEY, new MarsSkyProperty());
        DimensionRenderInfo.field_239208_a_.put(MDimensions.TAGREA_SKY_PROPERTY_KEY, new TagreaSkyProperty());
    }


    private static void registerTileRenderers() {
    }


    public static void registerScreens() {
        ScreenManager.registerFactory(MContainers.ADVQUANTISCOPE_WELD.get(), AdvQuantiscopeWeldScreen::new);
    }
}




