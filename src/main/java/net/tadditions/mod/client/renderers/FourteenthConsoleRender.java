package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.model.FourteenthConsoleModel;
import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tardis.mod.Tardis;
import net.tardis.mod.controls.MonitorControl;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.misc.WorldText;

public class FourteenthConsoleRender extends TileEntityRenderer<FourteenthConsoleTile> {

    public static final WorldText TEXT = new WorldText(0.31F, 0.26F, 0.003F, 0xFFFFFF);
    public static FourteenthConsoleModel model = new FourteenthConsoleModel();

    public FourteenthConsoleRender(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }


    @Override
    public void render(FourteenthConsoleTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.5, 0.6, 0.5); //Translate to middle of block
        matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(180));

        //Monitor Text
        tileEntityIn.getControl(MonitorControl.class).ifPresent(monitor -> {

            matrixStackIn.push();
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(150));
            matrixStackIn.translate(-0.15, -0.32, -10.86 / 16.0);
            TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, Helper.getConsoleText(tileEntityIn));
            matrixStackIn.pop();
        });
        ResourceLocation texture = new ResourceLocation(QolMod.MOD_ID, "textures/consoles/fourteenthconsole.png");
        if(tileEntityIn.getVariant() != null)
            texture = tileEntityIn.getVariant().getTexture();

        float scale = 0.4F;
        matrixStackIn.scale(scale, scale, scale);
        model.render(tileEntityIn, scale, matrixStackIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(texture)), combinedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);

        //Sonic
        matrixStackIn.push();
        matrixStackIn.translate(0.225, 0.5, 1.8);
        matrixStackIn.rotate(Vector3f.XN.rotationDegrees(15));
        float sonic_scale = 0.75F;
        matrixStackIn.scale(sonic_scale, sonic_scale, sonic_scale);
        Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getSonicItem(), ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
        matrixStackIn.pop();

        matrixStackIn.pop();

    }
}
