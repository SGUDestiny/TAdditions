package net.tadditions.mod.client.level;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.tadditions.mod.TemporalAdditionsMod;
import org.joml.Matrix4f;

public class TADimensionSpecialEffects extends DimensionSpecialEffects {

    public static final ResourceLocation VERGE_EFFECTS = new ResourceLocation(TemporalAdditionsMod.MOD_ID, "the_verge_of_reality");


    public TADimensionSpecialEffects(float cloudLevel, boolean hasGround, SkyType skyType,
                                            boolean forceBrightLightmap, boolean constantAmbientLight)
    {
        super(cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 biomeFogColor, float daylight)
    {
        return biomeFogColor.multiply((double)(daylight * 0.94F + 0.06F), (double)(daylight * 0.94F + 0.06F), (double)(daylight * 0.91F + 0.09F));
    }

    @Override
    public boolean isFoggyAt(int x, int y)
    {
        return false;
    }

    @Override
    public boolean renderClouds(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, double camX, double camY, double camZ, Matrix4f projectionMatrix)
    {
        return false;
    }

    @Override
    public boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog)
    {
        return false;
    }

    @Override
    public boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ)
    {
        return false;
    }

    public static class Verge extends TADimensionSpecialEffects
    {
        public Verge()
        {
            super(Float.NaN, true, SkyType.NONE, false, true);
        }



        @Override
        public Vec3 getBrightnessDependentFogColor(Vec3 biomeFogColor, float daylight) {
            return biomeFogColor;
        }

        @Override
        public boolean isFoggyAt(int x, int y) {
            return false;
        }
    }


    public static void registerTemporalAdditionsEffects(RegisterDimensionSpecialEffectsEvent event)
    {
        event.register(TADimensionSpecialEffects.VERGE_EFFECTS, new TADimensionSpecialEffects.Verge());
    }
}
