package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.model.DecorativeToyotaExteriorModel;
import net.tadditions.mod.client.model.ToyotaExteriorModel;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxExteriorTile;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.misc.WorldText;

public class DecorativeToyotaExteriorRenderer extends TileEntityRenderer<TileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID,
            "textures/exteriors/toyota_exterior.png");
    public static final WorldText TEXT = new WorldText(1.1F, 0.125F, 0.015F, 0xFFFFFF);

    private DecorativeToyotaExteriorModel model = new DecorativeToyotaExteriorModel();

    public DecorativeToyotaExteriorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(TileEntity tile, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();

        matrixStackIn.translate(0, -1.15, 0);
        matrixStackIn.scale(1.1f, 1.1f, 1.1f);
        this.model.render(matrixStackIn, bufferIn.getBuffer(TRenderTypes.getTardis(TEXTURE)), combinedLightIn, combinedOverlayIn, 1f, 1f, 1f, 1f);
        matrixStackIn.pop();

    }
}
