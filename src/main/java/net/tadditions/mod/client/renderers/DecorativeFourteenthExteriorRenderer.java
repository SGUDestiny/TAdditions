package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.FakeFourteenthPoliceBoxBlock;
import net.tadditions.mod.client.model.DecorativeFourteenthExteriorModel;
import net.tadditions.mod.tileentity.FourteenthPoliceBoxDecoTile;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.misc.WorldText;

public class DecorativeFourteenthExteriorRenderer extends TileEntityRenderer<FourteenthPoliceBoxDecoTile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID,
            "textures/exteriors/fourteenthexterior.png");
    public static final WorldText TEXT = new WorldText(1.1F, 0.125F, 0.015F, 0xFFFFFF);

    private DecorativeFourteenthExteriorModel model = new DecorativeFourteenthExteriorModel();

    public DecorativeFourteenthExteriorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(FourteenthPoliceBoxDecoTile tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();

        applyTransforms(matrixStackIn, tile);

        float alpha = 1.0F;

        this.renderExterior(tile, partialTicks, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, alpha);

        matrixStackIn.pop();
    }

    public void renderExterior(FourteenthPoliceBoxDecoTile tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, float alpha){
        matrixStackIn.push();

        matrixStackIn.translate(0, -1.32, 0);
        matrixStackIn.scale(0.55f, 0.55f, 0.55f);
        this.model.render(matrixStackIn, bufferIn.getBuffer(TRenderTypes.getTardis(TEXTURE)), combinedLightIn, combinedOverlayIn, 1F, 1F, 1F, alpha);
        matrixStackIn.pop();
    }

    public static void applyTransforms(MatrixStack matrixStack, FourteenthPoliceBoxDecoTile tile) {
        matrixStack.translate(0.5, -0.5, 0.5);
        matrixStack.rotate(Vector3f.ZN.rotationDegrees(180));

        if (tile.getBlockState() != null && tile.getBlockState().getBlock() instanceof FakeFourteenthPoliceBoxBlock) {
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
