package net.tadditions.mod.world;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tadditions.mod.client.renderers.sky.MarsSkyRenderer;
import net.tardis.mod.world.dimensions.SpaceSkyProperty;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT) //This is one of the few cases where we can be using OnlyIn - Vanilla uses this is a marker hack to strip bytecode from one side (server or client)
public class MarsSkyProperty extends DimensionRenderInfo {



	public MarsSkyProperty() {
		super(Float.NaN, true, FogType.NONE, true, false);
		this.setSkyRenderHandler(new MarsSkyRenderer());
	}
	
    public MarsSkyProperty(float cloudLevel, boolean hasGround, FogType skyType, boolean forceBrightLightmap,
                           boolean constantAmbientLight) {
        super(cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight);
    }

    //adjustSkyColor
    @Override
    public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
        return new Vector3d(0.57,0.454901960784,0.6);
    }

    //isFoggyAt
    @Override
    public boolean func_230493_a_(int camX, int camY) {
        return false;
    }

    @Nullable
    @Override
    public float[] func_230492_a_(float p_230492_1_, float p_230492_2_) {
        return SpaceSkyProperty.SUNSET_COLORS;
    }
}