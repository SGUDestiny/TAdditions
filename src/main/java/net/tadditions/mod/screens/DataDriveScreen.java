package net.tadditions.mod.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.container.DataDriveContainer;
import net.tadditions.mod.helper.MHelper;

import java.util.concurrent.atomic.AtomicInteger;

public class DataDriveScreen extends ContainerScreen<DataDriveContainer> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/gui/data_drive.png");

    public static int WIDTH = 176, HEIGHT = 166;
    public ItemStack drive;

    public DataDriveScreen(DataDriveContainer cont, PlayerInventory inv, ITextComponent text) {
        super(cont, inv, text);
        this.drive = cont.getStack();
    }

    @Override
    protected void init() {
        super.init();

    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

        if(MHelper.isInBounds(mouseX, mouseY, width / 2 - 5, height / 2 - HEIGHT / 4 - 22, width / 2 + 4, height / 2 - HEIGHT / 4 - 16)){
            this.renderTooltip(matrixStack, getState(), mouseX, mouseY);
        }
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        this.renderBackground(matrixStack);
        this.minecraft.textureManager.bindTexture(TEXTURE);
        this.blit(matrixStack, width / 2 - WIDTH / 2, height / 2 - HEIGHT / 2, 0, 0, WIDTH, HEIGHT);

        this.blit(matrixStack, width / 2 - 3, height / 2 - HEIGHT / 4 - 18, 177, 1, 6, getLightState()); }

    public int getLightState(){
        AtomicInteger inte = new AtomicInteger(0);
        drive.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
            cap.getHandler().getStackInSlot(0).getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap1 -> {
                inte.set(cap1.getUsed() ? 0 : 2);
            });
        });
        return inte.get();
    }

    public TranslationTextComponent getState(){
        TranslationTextComponent text = new TranslationTextComponent("tadditions.data_drive_gui_status");
        drive.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
            if(cap.getHandler().getStackInSlot(0).isItemEqual(ItemStack.EMPTY)){
                text.appendSibling(new TranslationTextComponent("_empty"));
            } else if(cap.getHandler().getStackInSlot(0).getCapability(MCapabilities.CRYSTAL_CAPABILITY).isPresent()){
                cap.getHandler().getStackInSlot(0).getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap1-> {
                    if(cap1.getUsed()){
                        text.appendSibling(new TranslationTextComponent("_used"));
                    } else text.appendSibling(new TranslationTextComponent("_ready"));
                });
            }
        });

        return text;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
