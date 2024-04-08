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
import net.tadditions.mod.helper.IMonitorHelp;
import net.tadditions.mod.tileentity.FourteenthConsoleTile;
import net.tardis.mod.Tardis;
import net.tardis.mod.controls.MonitorControl;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.misc.WorldText;

public class FourteenthConsoleRender extends TileEntityRenderer<FourteenthConsoleTile> {

    public static final WorldText TEXT = new WorldText(0.4F, 0.3F, 0.003F, 0xFFFFFF);
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
            if(tileEntityIn.getControl(MonitorControl.class).isPresent()) {
                MonitorControl control = tileEntityIn.getControl(MonitorControl.class).get();

                float angle1 = ((IMonitorHelp) control).getRotAngle();
                float angle2 = 0;
                if(angle1 == 60 || angle1 == 120 || angle1 == 0){
                    if(angle1 == 60){
                        angle2 = 120;
                    }
                    if(angle1 == 120){
                        angle2 = 60;
                    }
                    if(angle1 == 0){
                        angle2 = 180;
                    }
                    matrixStackIn.rotate(Vector3f.YN.rotationDegrees(angle2));
                }else{
                    if(angle1 == -120){
                        angle2 = 60;
                    }
                    if(angle1 == -60){
                        angle2 = 120;
                    }
                    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(angle2));
                }
            }
            matrixStackIn.translate(-0.2, -1.2, -0.825);
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
        matrixStackIn.translate(0.3, -1.4, -1.5);
        float sonic_scale = 1.0F;
        matrixStackIn.scale(sonic_scale, sonic_scale, sonic_scale);
        Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getSonicItem(), ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
        matrixStackIn.pop();

        matrixStackIn.pop();

    }
}
