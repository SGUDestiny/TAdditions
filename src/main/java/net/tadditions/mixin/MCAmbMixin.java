package net.tadditions.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.client.gui.screen.WinGameScreen;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.tardis.mod.tileentities.ConsoleTile;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Minecraft.class)
public class MCAmbMixin {

    public BackgroundMusicSelector getBackgroundMusicSelector() {
        if (((Minecraft) (Object) this).currentScreen instanceof WinGameScreen) {
            return BackgroundMusicTracks.CREDITS_MUSIC;
        } else if (((Minecraft) (Object) this).player != null) {
            if (((Minecraft) (Object) this).player.world.getDimensionKey() == World.THE_END) {
                return ((Minecraft) (Object) this).ingameGUI.getBossOverlay().shouldPlayEndBossMusic() ? BackgroundMusicTracks.DRAGON_FIGHT_MUSIC : BackgroundMusicTracks.END_MUSIC;
            } else {
                Biome.Category biome$category = ((Minecraft) (Object) this).player.world.getBiome(((Minecraft) (Object) this).player.getPosition()).getCategory();
                if (!((Minecraft) (Object) this).getMusicTicker().isBackgroundMusicPlaying(BackgroundMusicTracks.UNDER_WATER_MUSIC) && (!((Minecraft) (Object) this).player.canSwim() || biome$category != Biome.Category.OCEAN && biome$category != Biome.Category.RIVER)) {
                    return ((Minecraft) (Object) this).player.world.getDimensionKey() != World.THE_NETHER && ((Minecraft) (Object) this).player.abilities.isCreativeMode && ((Minecraft) (Object) this).player.abilities.allowFlying ? BackgroundMusicTracks.CREATIVE_MODE_MUSIC : ((Minecraft) (Object) this).world.getBiomeManager().getBiomeAtPosition(((Minecraft) (Object) this).player.getPosition()).getBackgroundMusic().orElse(BackgroundMusicTracks.WORLD_MUSIC);
                } else {
                    return BackgroundMusicTracks.UNDER_WATER_MUSIC;
                }
            }
        } else {
            return BackgroundMusicTracks.MAIN_MENU_MUSIC;
        }
    }

}
