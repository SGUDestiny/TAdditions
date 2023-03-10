package net.tadditions.mod.sound;

import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class BackMusic {

    public static final BackgroundMusicSelector VERWORLD_MUSIC = getDefaultBackgroundMusicSelector(MSounds.VERAMB1.get());
    public static final BackgroundMusicSelector VERWORLD_MUSIC2 = getDefaultBackgroundMusicSelector(MSounds.VERAMB2.get());


    public static BackgroundMusicSelector getDefaultBackgroundMusicSelector(SoundEvent soundEvent) {
        return new BackgroundMusicSelector(soundEvent, 12000, 24000, false);
    }
}
