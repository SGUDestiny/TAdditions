package net.tadditions.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.guis.containers.EngineContainerScreen;
import net.tardis.mod.client.guis.minigame.WireGameScreen;
import net.tardis.mod.containers.EngineContainer;
import net.tardis.mod.containers.slot.EngineSlot;
import net.tardis.mod.helper.Helper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EngineContainerScreen.class)
public class EngineScreenMixin extends ContainerScreen<EngineContainer> {

    @Shadow private Minecraft mc;
    @Final @Shadow public static ResourceLocation TEXTURE;
    @Final @Shadow public static ResourceLocation UPGRADES;
    @Final @Shadow public static ResourceLocation SUBSYSTEM;
    @Final @Shadow public static ResourceLocation CAPACITOR;
    @Final @Shadow public static ResourceLocation ATTUNEMENT;


    public EngineScreenMixin(EngineContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.xSize = 176;
        this.ySize = 97 + 35;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        this.renderBackground(matrixStack);
        if(this.getContainer().getPanelDirection() == Direction.SOUTH) {
            Minecraft.getInstance().getTextureManager().bindTexture(UPGRADES);
            this.blit(matrixStack, width / 2 - 176  /2, height / 2 - 166 / 2, 0, 0, 176, 166);
        }
        else if(this.getContainer().getPanelDirection() == Direction.NORTH) {
            mc.textureManager.bindTexture(SUBSYSTEM);
            this.blit(matrixStack, width /2 - 176 / 2, height / 2 - 166 / 2, 0, 0, 176, 166);
        }
        else if(this.getContainer().getPanelDirection() == Direction.WEST) {
            mc.textureManager.bindTexture(CAPACITOR);
            this.blit(matrixStack, width /2 - 176 / 2, height / 2 - 166 / 2, 0, 0, 176, 166);
        }
        else if(this.getContainer().getPanelDirection() == Direction.EAST) {
            mc.textureManager.bindTexture(ATTUNEMENT);
            this.blit(matrixStack, width /2 - 176 / 2, height / 2 - 166 / 2, 0, 0, 176, 166);

            mc.world.getCapability(Capabilities.TARDIS_DATA).ifPresent(data -> {
                float progress = data.getAttunementHandler().getClientAttunementProgress();

                int amtToDraw = (int) Math.floor(progress * 8.1F); //Multiple a bit more than 8 to account for rounding

                if(amtToDraw >= 1)
                    this.blit(matrixStack, width / 2 + 45, height / 2 - 64, 199, 1, 10, 10);
                if(amtToDraw >= 2)
                    this.blit(matrixStack, width / 2 + 50, height / 2 - 53, 204, 12, 5, 10);
                if(amtToDraw >= 3)
                    this.blit(matrixStack, width / 2 + 45, height / 2 - 42, 199, 23, 10, 10);
                if(amtToDraw >= 4)
                    this.blit(matrixStack, width / 2 + 34, height / 2 - 37, 188, 28, 10, 5);
                if(amtToDraw >= 5)
                    this.blit(matrixStack, width / 2 + 23, height / 2 - 42, 177, 23, 10, 10);
                if(amtToDraw >= 6)
                    this.blit(matrixStack, width / 2 + 23, height / 2 - 53, 177, 12, 5, 10);
                if(amtToDraw >= 7)
                    this.blit(matrixStack, width / 2 + 23, height / 2 - 64, 177, 1, 10, 10);
                if(amtToDraw >= 8)
                    this.blit(matrixStack, width / 2 + 34, height / 2 - 64, 188, 1, 10, 5);

            });
        }
        else {
            Minecraft.getInstance().getTextureManager().bindTexture(TEXTURE);
            int y = this.height / 2 - 35;
            this.blit(matrixStack, width / 2 - this.xSize / 2, y, 0, 125, this.xSize, 97);
            this.blit(matrixStack, width / 2 - this.xSize / 2, y - 35, 0, 0, this.xSize, 35);
        }
    }

    @Overwrite
    protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type) {
        ItemStack held =  this.playerInventory.getItemStack();
        if(!held.isEmpty() && slotIn instanceof EngineSlot) {
            if(slotIn.isItemValid(held) && !mc.player.isCreative())
                Minecraft.getInstance().enqueue(() -> Minecraft.getInstance().displayGuiScreen(new WireGameScreen(slotId, this.container.getPanelDirection())));
        }
        super.handleMouseClick(slotIn, slotId, mouseButton, type);
    }

}
