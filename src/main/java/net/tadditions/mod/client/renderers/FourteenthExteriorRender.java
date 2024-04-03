package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.model.FourteenthExteriorModel;
import net.tadditions.mod.tileentity.FourteenthPoliceBoxExteriorTile;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.misc.WorldText;

public class FourteenthExteriorRender extends ExteriorRenderer<FourteenthPoliceBoxExteriorTile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID,
            "textures/exteriors/fourteenthexterior.png");
    public static final WorldText TEXT = new WorldText(1.1F, 0.125F, 0.015F, 0xFFFFFF);

    private FourteenthExteriorModel model = new FourteenthExteriorModel();

    public FourteenthExteriorRender(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void renderExterior(FourteenthPoliceBoxExteriorTile tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, float alpha) {
        matrixStackIn.push();

        ResourceLocation texture = TEXTURE;
        if(tile.getVariant() != null)
            texture = tile.getVariant().getTexture();

        matrixStackIn.translate(0, -0.32, 0); // Translation must be negative as models are loaded in upside down.
        matrixStackIn.scale(0.55f, 0.55f, 0.55f); //Scales the model down by 4
        this.model.render(tile, 0.55F, matrixStackIn, bufferIn.getBuffer(TRenderTypes.getTardis(texture)), combinedLightIn, combinedOverlayIn, alpha);
        matrixStackIn.pop();



        //Front
        matrixStackIn.push();
        matrixStackIn.translate(-0.45, -1.96, -12.175 / 16.0F);
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

        //Left text
        matrixStackIn.push();
        matrixStackIn.translate(-0.77, -1.96, 7.25 / 16.0F);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90));
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

        //Right text
        matrixStackIn.push();
        matrixStackIn.translate(0.77, -1.96, -7.25 / 16.0F);
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90));
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

        //BACK text
        matrixStackIn.push();
        matrixStackIn.translate(0.45, -1.96, 12.175 / 16.0F);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180));
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

    }

}
