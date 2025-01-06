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

        this.addRenderableWidget(new ImageButton(97, 85, 4, 6, 177, 7, TEXTURE, (button) -> {
            NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 2));
        }));
        this.addRenderableWidget(new ImageButton(163, 85, 4, 6, 182, 7, TEXTURE, (button) -> {
            NetworkInit.sendToServer(new QuantascopeModeChangeMessage(this.getMenu().quantascope.getBlockPos(), 0));
        }));

        this.addRenderableWidget(new ToggleButton(this.leftPos + 29, this.topPos + 65, 193, 34, 18, b -> {
            b.setState(!b.getState());
            Network.sendToServer(new SonicUpgradeQuantascopeMessage(this.getMenu().quantascope.getBlockPos(), b.getState()));
        }));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        this.renderBackground(pPoseStack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TEXTURE);
        blit(pPoseStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY)
    {

    }
}
