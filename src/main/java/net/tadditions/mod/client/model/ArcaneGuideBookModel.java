package net.tadditions.mod.client.model;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.ArcaneGuidebookItem;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.List;

public class ArcaneGuideBookModel extends AnimatedGeoModel<ArcaneGuidebookItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/arcane_guidebook.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/arcane_guidebook_anims.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/item/arcane_guidebook.png");
    private int tickCount = 0;
    private int currentIndex = 0;


    @Override
    public ResourceLocation getModelLocation(ArcaneGuidebookItem object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(ArcaneGuidebookItem object) {
       return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ArcaneGuidebookItem object) {
        return animationResource;
    }

}
