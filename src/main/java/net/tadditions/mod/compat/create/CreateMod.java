package net.tadditions.mod.compat.create;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tadditions.mod.QolMod;

public class CreateMod {

    public static void create() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        QolMod.LOGGER.info("Create Mod Detected! Enabling Compatibility Features!");

        CreateItems.register(eventBus);
    }

}
