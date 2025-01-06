package net.tadditions.mod.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkHooks;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.block_entities.QuantascopeEntity;
import net.tadditions.mod.init.NetworkInit;
import net.tadditions.mod.menu.PhasingQuantascopeMenu;
import net.tadditions.mod.network.QuantascopeModeChangeMessage;

public class PhasingQuantascopeScreen extends AbstractContainerScreen<PhasingQuantascopeMenu>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(TemporalAdditionsMod.MOD_ID, "textures/gui/quantascope_phasing.png");

    public PhasingQuantascopeScreen(PhasingQuantascopeMenu pMenu, Inventory pPlayerInventory, Component pTitle)
    {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageHeight = 178;
    }

    @Override
    protected void init()
    {
        super.init();
        this.addRenderableWidget(new ImageButton(97, 85, 4, 6, 177, 7, TEXTURE, (button) -> {
            if(this.getMenu().level.isClientSide())
                NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 3));
        }));
        this.addRenderableWidget(new ImageButton(163, 85, 4, 6, 182, 7, TEXTURE, (button) -> {
            if(this.getMenu().level.isClientSide())
                NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 1));
        }));
    }

    @Override
    protected void renderBg(PoseStack stack, float partialTick, int mouseX, int mouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        blit(stack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick)
    {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY)
    {

    }
}
