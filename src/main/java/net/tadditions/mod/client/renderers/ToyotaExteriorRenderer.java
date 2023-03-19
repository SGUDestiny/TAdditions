package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.model.ToyotaExteriorModel;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxExteriorTile;
import net.tardis.mod.Tardis;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.client.models.exteriors.ModernPoliceBoxExteriorModel;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.misc.WorldText;
import net.tardis.mod.tileentities.exteriors.ModernPoliceBoxExteriorTile;

public class ToyotaExteriorRenderer extends ExteriorRenderer<ToyotaPoliceBoxExteriorTile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID,
            "textures/toyota_exterior.png");
    public static final WorldText TEXT = new WorldText(1.1F, 0.125F, 0.015F, 0xFFFFFF);

    private ToyotaExteriorModel model = new ToyotaExteriorModel();

    public ToyotaExteriorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void renderExterior(ToyotaPoliceBoxExteriorTile tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, float alpha) {
        matrixStackIn.push();
        /*We want to shift the render up in this case
        so that when we place the exterior two blocks up from the ground,
        the base of the exterior will be rendered as standing on the ground
        */
        matrixStackIn.translate(0, -1.15, 0); // Translation must be negative as models are loaded in upside down.
        matrixStackIn.scale(1.1f, 1.1f, 1.1f); //Scales the model down by 4
        this.model.render(tile, 1.1F, matrixStackIn, bufferIn.getBuffer(TRenderTypes.getTardis(TEXTURE)), combinedLightIn, combinedOverlayIn, alpha);
        matrixStackIn.pop();



        //Front
        matrixStackIn.push();
        matrixStackIn.translate(-9F, 36F, -12.125F);
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

        //Left text
        matrixStackIn.push();
        matrixStackIn.translate(-9F, 36F, -12.125F);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90));
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

        //Right text
        matrixStackIn.push();
        matrixStackIn.translate(-9F, 36F, -12.125F);
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90));
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

        //BACK text
        matrixStackIn.push();
        matrixStackIn.translate(-9F, 36F, -12.125F);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180));
        TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, tile.getCustomName());
        matrixStackIn.pop();

    }
}
