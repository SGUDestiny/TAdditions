package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.client.model.DematModel;
import net.tadditions.mod.client.model.MurasamaModel;
import net.tadditions.mod.items.Murasama;
import net.tadditions.mod.items.SubsysItem;
import software.bernie.geckolib3.core.util.Color;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import javax.annotation.Nullable;

public class MurasamaRenderer extends GeoItemRenderer<Murasama> {
    public MurasamaRenderer() {
        super(new MurasamaModel());
    }
}
