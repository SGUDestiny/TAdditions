package net.tadditions.mod.helper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.sound.SoundSchemeFull;
import net.tardis.mod.Tardis;
import net.tardis.mod.registries.SoundSchemeRegistry;
import net.tardis.mod.sounds.*;

import java.util.function.Supplier;

public class MSoundSchemeRegistry extends SoundSchemeRegistry {

	public static final DeferredRegister<AbstractSoundScheme> SOUND_SCHEMES = DeferredRegister.create(AbstractSoundScheme.class, QolMod.MOD_ID);

	public static final RegistryObject<AbstractSoundScheme> FULL = SOUND_SCHEMES.register("fullnewwho", ()-> new SoundSchemeFull());
}
