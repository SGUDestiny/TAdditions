package net.tadditions.mod.client;

import com.google.common.collect.Maps;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.client.model.CoralInteriorDoors;
import net.tadditions.mod.client.model.FourteenthInteriorDoors;
import net.tadditions.mod.client.model.ToyotaInteriorDoor;
import net.tadditions.mod.client.renderers.*;
import net.tadditions.mod.container.MContainers;
import net.tadditions.mod.helper.IMDoorType;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.screens.AdvQuantiscopeWeldScreen;
import net.tadditions.mod.screens.DataDriveScreen;
import net.tadditions.mod.screens.misc.AdvQuantiscopePage;
import net.tadditions.mod.screens.misc.AdvQuantiscopeScreenType;
import net.tadditions.mod.tileentity.ModTileEntitys;
import net.tadditions.mod.world.MDimensions;
import net.tadditions.mod.world.MarsSkyProperty;
import net.tadditions.mod.world.VergeSkyProperty;
import net.tardis.mod.client.TClientRegistry;

import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = QolMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MClientRegistry extends TClientRegistry {


    public static final EnumMap<AdvQuantiscopeScreenType, AdvQuantiscopePage> ADVQUANTISCOPE_SCREENS = Maps.newEnumMap(AdvQuantiscopeScreenType.class);


    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        registerTileRenderers();
        registerScreens();
        registerInteriorDoorRenderers();
        DimensionRenderInfo.field_239208_a_.put(MDimensions.MARS_SKY_PROPERTY_KEY, new MarsSkyProperty());
        DimensionRenderInfo.field_239208_a_.put(MDimensions.THE_VERG_SKY_PROPERTY_KEY, new VergeSkyProperty());
        event.enqueueWork(() -> {
            //Block Render Layers
            RenderTypeLookup.setRenderLayer(ModBlocks.electromagnetic_solenoid_container.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.filled_electromagnetic_solenoid_container.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.exterior_toyota_police_box.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.exterior_fourteenth_police_box.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.exterior_coral_police_box.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.decorative_toyota_police_box.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.sanguine_door.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.sanguine_trapdoor.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ancient_keyholder.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ancient_door.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.lightbox.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.containment_chamber.get(), RenderType.getCutout()); });

        ItemModelsProperties.registerProperty(ModItems.DATA_DRIVE.get(), new ResourceLocation(QolMod.MOD_ID, "used"),
                (stack, clientWorld, entity) -> {
                    AtomicInteger integer = new AtomicInteger(0);
                    stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                        if(cap.getHandler().getStackInSlot(0).getItem().equals(ModItems.BURNED_DATA_CRYSTAL.get())) {
                            integer.set(1);
                        }
                    });
                    return integer.get();
                });
        ItemModelsProperties.registerProperty(ModItems.DATA_DRIVE.get(), new ResourceLocation(QolMod.MOD_ID, "coord"),
                (stack, clientWorld, entity) -> {
                    AtomicInteger integer = new AtomicInteger(0);
                    stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                        if (cap.getHandler().getStackInSlot(0).getItem().equals(ModItems.COORDINATE_DATA_CRYSTAL.get())) {
                            integer.set(1);
                        }
                    });
                    return integer.get();
                });
        ItemModelsProperties.registerProperty(ModItems.DATA_DRIVE.get(), new ResourceLocation(QolMod.MOD_ID, "dim"),
                (stack, clientWorld, entity) -> {
                    AtomicInteger integer = new AtomicInteger(0);
                    stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                        if (cap.getHandler().getStackInSlot(0).getItem().equals(ModItems.DIMENSIONAL_DATA_CRYSTAL.get())) {
                            integer.set(1);
                        }
                    });
                    return integer.get();
                });
        ItemModelsProperties.registerProperty(ModItems.DATA_DRIVE.get(), new ResourceLocation(QolMod.MOD_ID, "empty"),
                (stack, clientWorld, entity) -> {
                    AtomicInteger integer = new AtomicInteger(0);
                    stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                        if(cap.getHandler().getStackInSlot(0).isEmpty()) {
                            integer.set(1);
                        }
                    });
                    return integer.get();
                });
    }


    private static void registerTileRenderers() {
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.EXTERIOR_TOYOTA_POLICE_BOX.get(), ToyotaExteriorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.EXTERIOR_FOURTEENTH_POLICE_BOX.get(), FourteenthExteriorRender::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.EXTERIOR_CORAL_POLICE_BOX.get(), CoralExteriorRender::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.FOURTEENTH_CONSOLE.get(), FourteenthConsoleRender::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.WPH.get(), WeaponHolderRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.CONTAINMENT_CHAMBER.get(), ContainmentChamberRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.SolenoidFilled.get(), SolenoidFilledRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.DECORATIVE_TOYOTA_POLICE_BOX.get(), DecorativeToyotaExteriorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntitys.DECORATIVE_FOURTEENTH_POLICE_BOX.get(), DecorativeFourteenthExteriorRenderer::new);
    }

    private static void registerInteriorDoorRenderers() {
        IMDoorType.EnumDoorType.TOYOTA.setInteriorDoorModel(new ToyotaInteriorDoor());
        IMDoorType.EnumDoorType.FOURTEENTH.setInteriorDoorModel(new FourteenthInteriorDoors());
        IMDoorType.EnumDoorType.CORAL.setInteriorDoorModel(new CoralInteriorDoors());
    }

    public static void registerScreens() {
        ScreenManager.registerFactory(MContainers.ADVQUANTISCOPE_WELD.get(), AdvQuantiscopeWeldScreen::new);
        ScreenManager.registerFactory(MContainers.DATADRIVE.get(), DataDriveScreen::new);
    }
}




