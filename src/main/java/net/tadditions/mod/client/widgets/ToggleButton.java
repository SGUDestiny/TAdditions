package net.tadditions.mod.client.widgets;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public class ToggleButton extends AbstractButton {

    public static int WIDTH = 0, HEIGHT = 0;
    public static int U = 0,
            V = 0;
    private boolean isOn = false;
    private IButtonAction action;

    public ToggleButton(int pX, int pY, int width, int height, int u, int v, IButtonAction run) {
        super(pX, pY, width, height, Component.empty());
        this.action = run;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.U = u;
        this.V = v;
        this.visible = true;
    }

    @Override
    public void onPress() {
        this.action.onPress(this);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput p_259858_) {

    }

    @Override
    public void renderWidget(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        //super.renderButton(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.blit(pPoseStack, this.getX(), this.getY(), U, V + (this.getState() ? HEIGHT + 1 : 0), WIDTH, HEIGHT);
    }

    public ToggleButton setState(boolean state){
        this.isOn = state;
        return this;
    }

    public boolean getState(){
        return this.isOn;
    }

    public static interface IButtonAction{
        void onPress(ToggleButton button);
    }
}