package net.tadditions.mod.client.model;

import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.tileentity.ZPFChamberBrokenTile;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZPFChamberBrokenModel extends AnimatedGeoModel<ZPFChamberBrokenTile> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/zero_point_field_chamber_broken.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/zero_point_field_chamber_broken.animation.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/block/zpfc_broken.png");

    @Override
    public ResourceLocation getModelLocation(ZPFChamberBrokenTile object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(ZPFChamberBrokenTile object) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ZPFChamberBrokenTile object) {
        return animationResource;
    }

}
