package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.client.model.ContainmentChamberModel;
import net.tadditions.mod.tileentity.ContainmentChamberTile;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

public class ContainmentChamberRenderer extends GeoBlockRenderer<ContainmentChamberTile> {
    public ContainmentChamberRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new ContainmentChamberModel());
    }

    @Override
    public RenderType getRenderType(ContainmentChamberTile animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(textureLocation);
    }

    @Override
    public float getHeightScale(ContainmentChamberTile entity) {
        return 0.65F;
    }

    @Override
    public float getWidthScale(ContainmentChamberTile animatable2) {
        return 0.65F;
    }
}
