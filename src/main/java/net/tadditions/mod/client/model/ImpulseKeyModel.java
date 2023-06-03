package net.tadditions.mod.client.model;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.CoreKeyItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.ArrayList;
import java.util.List;

public class ImpulseKeyModel extends AnimatedGeoModel<CoreKeyItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/impulsekey.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/item/impulsekey.png");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/impulse_key.animation.json");
    private static final List<ResourceLocation> animo = Lists.newArrayList(textureResource, textureResource);

    @Override
    public ResourceLocation getModelLocation(CoreKeyItem object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(CoreKeyItem object) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CoreKeyItem object) {
        return animationResource;
    }
}
