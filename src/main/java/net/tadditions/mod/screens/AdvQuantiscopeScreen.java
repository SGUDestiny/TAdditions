package net.tadditions.mod.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.client.MClientRegistry;
import net.tadditions.mod.screens.misc.AdvQuantiscopePage;
import net.tadditions.mod.screens.misc.AdvQuantiscopeScreenType;
import net.tardis.mod.Tardis;
import net.tardis.mod.client.TClientRegistry;
import net.tardis.mod.client.guis.misc.QuantiscopePage;
import net.tardis.mod.misc.quantiscope.QuantiscopeScreenType;

public abstract class AdvQuantiscopeScreen<T extends Container> extends ContainerScreen<T> {

    private AdvQuantiscopePage page;
    private AdvQuantiscopeScreenType type;

    public AdvQuantiscopeScreen(T screenContainer, PlayerInventory inv, String nameSuffix) {
        super(screenContainer, inv, new TranslationTextComponent("container." + QolMod.MOD_ID + ".quantiscope." + nameSuffix));
    }

    public void setQuantiscopeScreenType(AdvQuantiscopeScreenType type){
        this.type = type;
        this.page = MClientRegistry.ADVQUANTISCOPE_SCREENS.get(type);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {

       if(this.page != null){
           Minecraft.getInstance().textureManager.bindTexture(this.page.getTexture());
           matrixStack.push();
           this.blit(matrixStack, this.width / 2 - page.getWidth() / 2, this.height / 2 - page.getHeight() / 2, 0, 0, page.getWidth(), page.getHeight());
           matrixStack.pop();
       }

    }
}
