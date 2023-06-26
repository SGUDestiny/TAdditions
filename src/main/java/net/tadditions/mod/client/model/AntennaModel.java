package net.tadditions.mod.client.model;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.List;

public class AntennaModel extends AnimatedGeoModel<SubsysItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/interstitial_antenna.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/interstitial_antenna.animation.json");
    private static final List<ResourceLocation> animo = Lists.newArrayList(new ResourceLocation(QolMod.MOD_ID, "textures/itemanim/antenna/antenna_frame_1.png"), new ResourceLocation(QolMod.MOD_ID, "textures/itemanim/antenna/antenna_frame_2.png"), new ResourceLocation(QolMod.MOD_ID, "textures/itemanim/antenna/antenna_frame_3.png"), new ResourceLocation(QolMod.MOD_ID, "textures/itemanim/antenna/antenna_frame_4.png"));
    private int tickCount = 0;
    private int currentIndex = 0;


    @Override
    public ResourceLocation getModelLocation(SubsysItem object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(SubsysItem object) {
       return animateTexture(animo);
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SubsysItem object) {
        return animationResource;
    }

    public ResourceLocation animateTexture(List<ResourceLocation> list){
        tickCount++;
        if (tickCount >= 100) {
            tickCount = 0;
            currentIndex++;
            if (currentIndex >= list.size()) {
                currentIndex = 0;
            }
        }

        return list.get(currentIndex);
    }
}
