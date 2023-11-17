package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.FakeToyotaBlock;
import net.tadditions.mod.client.model.DecorativeToyotaExteriorModel;
import net.tadditions.mod.client.model.ToyotaExteriorModel;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxDecoTile;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxExteriorTile;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.items.TItems;
import net.tardis.mod.misc.WorldText;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

public class DecorativeToyotaExteriorRenderer extends TileEntityRenderer<ToyotaPoliceBoxDecoTile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID,
            "textures/exteriors/toyota_exterior.png");
    public static final WorldText TEXT = new WorldText(1.1F, 0.125F, 0.015F, 0xFFFFFF);

    private DecorativeToyotaExteriorModel model = new DecorativeToyotaExteriorModel();

    public DecorativeToyotaExteriorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(ToyotaPoliceBoxDecoTile tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();

        applyTransforms(matrixStackIn, tile);

        float alpha = 1.0F;

        this.renderExterior(tile, partialTicks, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, alpha);

        matrixStackIn.pop();
    }

    public void renderExterior(ToyotaPoliceBoxDecoTile tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, float alpha){
        matrixStackIn.push();

        matrixStackIn.translate(0, -2.15, 0);
        matrixStackIn.scale(1.1f, 1.1f, 1.1f);
        this.model.render(matrixStackIn, bufferIn.getBuffer(TRenderTypes.getTardis(TEXTURE)), combinedLightIn, combinedOverlayIn, 1F, 1F, 1F, alpha);
        matrixStackIn.pop();
    }

    public static void applyTransforms(MatrixStack matrixStack, ToyotaPoliceBoxDecoTile tile) {
        matrixStack.translate(0.5, -0.5, 0.5);
        matrixStack.rotate(Vector3f.ZN.rotationDegrees(180));

        if (tile.getBlockState() != null && tile.getBlockState().getBlock() instanceof FakeToyotaBlock) {
            Direction face = tile.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
            matrixStack.rotate(Vector3f.YP.rotationDegrees(face.getHorizontalAngle() - 180));
        }
        if (tile.getWorld() != null && tile.getWorld().getBlockState(tile.getPos().down(2)).isAir()) {
            double offY = Math.cos(Minecraft.getInstance().world.getGameTime() * 0.05) * 0.06;
            double offX = Math.cos(Minecraft.getInstance().world.getGameTime() * 0.05) * 0.07;
            double offZ = Math.cos(Minecraft.getInstance().world.getGameTime() * 0.05) * 0.07;
            matrixStack.translate(offX, offY, offZ);
        }
    }
}
