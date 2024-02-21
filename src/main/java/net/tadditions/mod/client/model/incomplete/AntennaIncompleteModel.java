package net.tadditions.mod.client.model.incomplete;

import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AntennaIncompleteModel extends AnimatedGeoModel<AnimatedSequenceAssemblyItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/interstitial_antenna_incomplete.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/interstitial_antenna.animation.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/itemanim/antenna/antenna_frame_1.png");
    @Override
    public ResourceLocation getModelLocation(AnimatedSequenceAssemblyItem object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(AnimatedSequenceAssemblyItem object) {
       return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AnimatedSequenceAssemblyItem object) {
        return animationResource;
    }

}
