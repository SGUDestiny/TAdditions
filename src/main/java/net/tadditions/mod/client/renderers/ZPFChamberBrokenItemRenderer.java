package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.client.model.ZPFChamberBrokenItemModel;
import net.tadditions.mod.client.model.ZPFChamberBrokenModel;
import net.tadditions.mod.items.AnimatedBlockItem;
import net.tadditions.mod.items.AnimatedMultiblockBlockItem;
import net.tadditions.mod.tileentity.ZPFChamberBrokenTile;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import javax.annotation.Nullable;

public class ZPFChamberBrokenItemRenderer extends GeoItemRenderer<AnimatedMultiblockBlockItem> {
    public ZPFChamberBrokenItemRenderer() {
        super(new ZPFChamberBrokenItemModel());
    }

    @Override
    public RenderType getRenderType(AnimatedMultiblockBlockItem animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(textureLocation);
    }

}
