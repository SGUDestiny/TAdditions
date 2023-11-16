package net.tadditions.mod.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.model.DecorativeToyotaExteriorModel;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxDecoTile;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.cap.items.sonic.SonicCapability;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.items.SonicItem;
import net.tardis.mod.items.sonicparts.SonicBasePart;
import net.tardis.mod.misc.WorldText;
import net.tardis.mod.sonic.ISonicPart;

public class DecorativeToyotaItemRenderer extends ItemStackTileEntityRenderer {
    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID,
            "textures/exteriors/toyota_exterior.png");
    public static final WorldText TEXT = new WorldText(1.1F, 0.125F, 0.015F, 0xFFFFFF);

    private DecorativeToyotaExteriorModel model = new DecorativeToyotaExteriorModel();

    @Override
    public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {

        if(stack == null)
            return;

        ClientPlayerEntity player = Minecraft.getInstance().player;

        matrixStack.push();
        matrixStack.translate(0.5, -0.5, 0.5);
        matrixStack.rotate(Vector3f.ZN.rotationDegrees(180));
        this.model.render(matrixStack, buffer.getBuffer(TRenderTypes.getTardis(TEXTURE)), combinedLight, combinedOverlay, 1f, 1f, 1f, 1f);
        matrixStack.pop();
    }
}
