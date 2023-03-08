package net.tadditions.mod.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.container.AdvQuantiscopeWeldContainer;
import net.tadditions.mod.tileentity.AdvQuantiscopeTile;

public class AdvQuantiscopeWeldScreen extends ContainerScreen<AdvQuantiscopeWeldContainer> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/gui/advweld_iron.png");
    public static TranslationTextComponent weld_tab = new TranslationTextComponent("gui.advquantiscope.advweld");
    private AdvQuantiscopeTile tile;

    public AdvQuantiscopeWeldScreen(AdvQuantiscopeWeldContainer cont, PlayerInventory inv, ITextComponent titleIn) {
        super(cont, inv, titleIn);
        this.tile = cont.getBlockEntity();
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        this.renderBackground(matrixStack);
        int texWidth = 176;
        int textHeight = 216;
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        blit(matrixStack, width / 2 - texWidth / 2, height / 2 - textHeight / 2, 0, 0, texWidth, textHeight);

        blit(matrixStack, width / 2 - 8, height / 2 - 83, 178, 0, 24,  (int) (25 * tile.getProgress()));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		//Remove super class call so we don't show our container title
		this.font.drawText(matrixStack, this.playerInventory.getDisplayName(), (float)this.playerInventoryTitleX, (float)this.playerInventoryTitleY+25, 4210752);
	}
}
