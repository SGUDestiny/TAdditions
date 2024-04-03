package net.tadditions.mod.client.model;

import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.AnimatedBlockItem;
import net.tadditions.mod.tileentity.ZPFChamberBrokenTile;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZPFChamberBrokenItemModel extends AnimatedGeoModel<AnimatedBlockItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/zero_point_field_chamber_broken.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/zero_point_field_chamber_broken.animation.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/block/zpfc_broken.png");

    @Override
    public ResourceLocation getModelLocation(AnimatedBlockItem object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(AnimatedBlockItem object) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AnimatedBlockItem object) {
        return animationResource;
    }

}
