package net.tadditions.mod.helper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tardis.mod.misc.Console;
import net.tardis.mod.registries.ConsoleRegistry;


public class MConsoleRegistry {
    public static final DeferredRegister<Console> CONSOLES = DeferredRegister.create(Console.class, QolMod.MOD_ID);

    public static final RegistryObject<Console> FOURTEENTH = CONSOLES.register("voyager", () -> new ModConsoles(() -> ModBlocks.fourteenth_console.get().getDefaultState(), "fourteenth"));
}
