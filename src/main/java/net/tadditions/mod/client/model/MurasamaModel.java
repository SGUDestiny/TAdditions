package net.tadditions.mod.client.model;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.List;

public class MurasamaModel extends AnimatedGeoModel<SubsysItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/murasama.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/item/murasama.png");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/murasama.animation.json");


    @Override
    public ResourceLocation getModelLocation(SubsysItem object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(SubsysItem object) {
       return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SubsysItem object) {
        return animationResource;
    }

}
