package net.tadditions.mod.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.init.NetworkInit;
import net.tadditions.mod.menu.SonicQuantascopeMenu;
import net.tadditions.mod.network.QuantascopeModeChangeMessage;
import net.tadditions.mod.network.SonicChangeModelMessage;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.items.ISonicCapability;
import net.tardis.mod.client.SonicPartModelLoader;
import net.tardis.mod.network.Network;
import net.tardis.mod.registry.SonicPartRegistry;
import net.tardis.mod.sonic_screwdriver.SonicPartSlot;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class SonicQuantascopeScreen extends AbstractContainerScreen<SonicQuantascopeMenu>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(TemporalAdditionsMod.MOD_ID, "textures/gui/quantascope_sonic.png");
    public final EnumMap<SonicPartSlot, List<SonicPartRegistry.SonicPartType>> partMap = new EnumMap<>(SonicPartSlot.class);

    public SonicQuantascopeScreen(SonicQuantascopeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);

        for(SonicPartRegistry.SonicPartType type : SonicPartRegistry.REGISTRY.get()){
            partMap.computeIfAbsent(type.getSlot(), t -> new ArrayList<>()).add(type);
        }
    }

    @Override
    protected void init() {
        super.init();
        this.imageHeight = 178;

        this.addRenderableWidget(new ImageButton(this.leftPos + 97, this.topPos + 73, 4, 7, 177, 1, TEXTURE, (button) -> {
            NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 1));
        }));
        this.addRenderableWidget(new ImageButton(this.leftPos + 163, this.topPos + 73, 4, 7, 182, 1, TEXTURE, (button) -> {
            NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 3));
        }));

        for(SonicPartSlot slot : SonicPartSlot.values()){
            int xOffset = slot == SonicPartSlot.HANDLE ? 103 : 31 + (slot.ordinal() * 36);
            //Forward
            this.addRenderableWidget(new ImageButton(
                    this.leftPos + xOffset, this.topPos + 22, 6, 7, 177, 15, TEXTURE, but ->
                            this.setNext(slot, true)));
            //Backwards
            this.addRenderableWidget(new ImageButton(
                    this.leftPos + xOffset, this.topPos + 46, 6, 7, 184, 15, TEXTURE, but ->
                    this.setNext(slot, false)));
        }

    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(PoseStack stack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        blit(stack, x, y, 0, 0, imageWidth, imageHeight);

        this.getMenu().quantascope.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(inv -> {
            inv.getStackInSlot(0).getCapability(Capabilities.SONIC).ifPresent(sonic -> {
                this.renderSonicSlot(stack, sonic);
            });
        });

    }

    public void renderSonicSlot(PoseStack pose, ISonicCapability sonic){
        RenderType.solid().setupRenderState();
        pose.pushPose();
        pose.translate(this.leftPos + 18, this.topPos + 22, 100);

        final BufferBuilder bb = Tesselator.getInstance().getBuilder();
        MultiBufferSource source = MultiBufferSource.immediate(bb);
        final VertexConsumer partConsumer = source.getBuffer(RenderType.cutout());
        int index = 0;
        for(SonicPartSlot slot : SonicPartSlot.values()){
            pose.pushPose();
            pose.translate(index * 40, 0, 0);
            pose.scale(20, 20, 20);
            pose.mulPose(Axis.XP.rotationDegrees(113));
            pose.mulPose(Axis.YP.rotationDegrees(90));
            pose.mulPose(Axis.XP.rotationDegrees(22));
            renderSonicPart(pose, slot, sonic, partConsumer);
            pose.popPose();
            ++index;
        }

        BufferUploader.drawWithShader(bb.end());
        pose.popPose();
        RenderType.solid().clearRenderState();
    }

    public void renderSonicPart(PoseStack pose, SonicPartSlot slot, ISonicCapability sonic, VertexConsumer source){

        SonicPartModelLoader.pointFromReg(sonic.getSonicPart(slot)).ifPresent(point -> {
            final BakedModel model = Minecraft.getInstance().getModelManager().getModel(point.model());
            Minecraft.getInstance().getItemRenderer().renderModelLists(model, new ItemStack(Items.GLASS_BOTTLE), LightTexture.FULL_BLOCK, OverlayTexture.NO_OVERLAY, pose, source);
        });

    }

    public int currentPartIndex(SonicPartRegistry.SonicPartType type){
        for(int i = 0; i < partMap.get(type.getSlot()).size(); ++i){
            if(type == partMap.get(type.getSlot()).get(i)){
                return i;
            }
        }
        return 0;
    }

    public void setNext(SonicPartSlot slot, boolean forward)
    {
        this.getMenu().quantascope.itemHandler.getStackInSlot(0).getCapability(Capabilities.SONIC).ifPresent(sonic -> {
            List<SonicPartRegistry.SonicPartType> validTypes = this.partMap.get(slot);
            int index = currentPartIndex(sonic.getSonicPart(slot));
            index += forward ? 1 : -1;
            if(index >= validTypes.size()){
                index = 0;
            }
            else if(index < 0){
                index = validTypes.size() - 1;
            }
            sonic.setSonicPart(slot, validTypes.get(index));
            Network.sendToServer(new SonicChangeModelMessage(this.getMenu().quantascope.getBlockPos(), sonic.getSonicPart(slot)));
        });
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY)
    {

    }
}
