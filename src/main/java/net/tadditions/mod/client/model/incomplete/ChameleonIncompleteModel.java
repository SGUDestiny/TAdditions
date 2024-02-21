package net.tadditions.mod.client.model.incomplete;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.compat.create.AnimatedSequenceAssemblyItem;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.List;

public class ChameleonIncompleteModel extends AnimatedGeoModel<AnimatedSequenceAssemblyItem> {
    private static final ResourceLocation modelResource = new ResourceLocation(QolMod.MOD_ID, "geo/chameleon_circuit_incomplete.geo.json");
    private static final ResourceLocation animationResource = new ResourceLocation(QolMod.MOD_ID, "animations/chameleon_circuit.animation.json");
    private static final ResourceLocation textureResource = new ResourceLocation(QolMod.MOD_ID, "textures/itemanim/chameleon/chameleon_circuit_frame_1.png");


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
