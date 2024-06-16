package net.tadditions.mod.client.model;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ContainmentChamberBlock;
import net.tadditions.mod.tileentity.ContainmentChamberTile;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.List;

public class ContainmentChamberModel extends AnimatedGeoModel<ContainmentChamberTile> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/containment_chamber.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/containment_chamber.animation.json");
    private static final List<ResourceLocation> animo = Lists.newArrayList(new ResourceLocation(QolMod.MOD_ID, "textures/blockanim/containment_chamber/frame_1.png"), new ResourceLocation(QolMod.MOD_ID, "textures/blockanim/containment_chamber/frame_2.png"), new ResourceLocation(QolMod.MOD_ID, "textures/blockanim/containment_chamber/frame_3.png"), new ResourceLocation(QolMod.MOD_ID, "textures/blockanim/containment_chamber/frame_4.png"), new ResourceLocation(QolMod.MOD_ID, "textures/blockanim/containment_chamber/frame_5.png"));
    private int tickCount = 0;
    private int currentIndex = 0;


    @Override
    public ResourceLocation getModelLocation(ContainmentChamberTile object) {
        if(object.getBlockState().get(ContainmentChamberBlock.BROKEN))
            return new ResourceLocation(QolMod.MOD_ID, "geo/containment_chamber_broken.geo.json");
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(ContainmentChamberTile object) {
        if(object.getBlockState().get(ContainmentChamberBlock.BROKEN))
            return new ResourceLocation(QolMod.MOD_ID, "textures/block/containment_chamber_broken.png");
        return animateTexture(animo);
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ContainmentChamberTile object) {
        if(object.getBlockState().get(ContainmentChamberBlock.BROKEN))
           return new ResourceLocation(QolMod.MOD_ID, "animations/containment_chamber_broken.animation.json");
        return animationResource;
    }

    public ResourceLocation animateTexture(List<ResourceLocation> list){
        tickCount++;
        if (tickCount >= 70) {
            tickCount = 0;
            currentIndex++;
            if (currentIndex >= list.size()) {
                currentIndex = 0;
            }
        }

        return list.get(currentIndex);
    }
}
