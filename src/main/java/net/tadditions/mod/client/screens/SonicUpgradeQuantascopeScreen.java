package net.tadditions.mod.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tadditions.mod.TemporalAdditionsMod;
import net.tadditions.mod.client.widgets.Switch;
import net.tadditions.mod.init.NetworkInit;
import net.tadditions.mod.menu.SonicUpgradeQuantascopeMenu;
import net.tadditions.mod.network.QuantascopeModeChangeMessage;
import net.tadditions.mod.network.SonicUpgradeQuantascopeMessage;
import net.tardis.mod.client.gui.widgets.ToggleButton;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.SonicUpgradeQuantiscopeMessage;

public class SonicUpgradeQuantascopeScreen extends AbstractContainerScreen<SonicUpgradeQuantascopeMenu>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(TemporalAdditionsMod.MOD_ID, "textures/gui/quantascope_sonic_upgrade.png");

    public SonicUpgradeQuantascopeScreen(SonicUpgradeQuantascopeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init()
    {
        super.init();
        this.imageHeight = 178;

        this.addRenderableWidget(new ImageButton(this.leftPos + 97, this.topPos + 73, 4, 7, 177, 1, TEXTURE, (button) -> {
            NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 2));
        }));
        this.addRenderableWidget(new ImageButton(this.leftPos + 163, this.topPos + 73, 4, 7, 182, 1, TEXTURE, (button) -> {
            NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 0));
        }));

        this.addRenderableWidget(new Switch(this.leftPos + 29, this.topPos + 40, 7, 18, 177, 15, b -> {
            b.setState(!b.getState());
            NetworkInit.sendToServer(new SonicUpgradeQuantascopeMessage(this.getMenu().quantascope.getBlockPos(), b.getState()));
        }));
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
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY)
    {

    }
}
