package net.tadditions.mod.sound;

import net.minecraft.client.audio.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;

public class MSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, QolMod.MOD_ID);

    public static final RegistryObject<SoundEvent> FULLREMA =
            soundEventRegister("remasound");

    public static final RegistryObject<SoundEvent> DISC1 =
            soundEventRegister("disc1");

    public static final RegistryObject<SoundEvent> DISC2 =
            soundEventRegister("disc2");

    public static final RegistryObject<SoundEvent> DISC3 =
            soundEventRegister("disc3");

    public static final RegistryObject<SoundEvent> DISC4 =
            soundEventRegister("disc4");

    public static final RegistryObject<SoundEvent> VERAMB1 =
            soundEventRegister("verge_ambient");

    public static final RegistryObject<SoundEvent> MURASAMA =
            soundEventRegister("murasama");

    public static final RegistryObject<SoundEvent> DESPITEITALL =
            soundEventRegister("despite_it_all");

    public static final RegistryObject<SoundEvent> YEAR_20 =
            soundEventRegister("20_year");

    public static final RegistryObject<SoundEvent> WAYS_TO_SHOW =
            soundEventRegister("ways_to_show_the_awful");




    public static RegistryObject<SoundEvent> soundEventRegister(String name) {
        return SOUND_EVENT.register(name, () -> new SoundEvent(new ResourceLocation(QolMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENT.register(eventBus);
    }
}
