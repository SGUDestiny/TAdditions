package net.tadditions.mod.screens.misc;

import net.minecraft.util.ResourceLocation;

public class AdvQuantiscopePage {

    private ResourceLocation texture;
    private String nameSuffix;
    private int offsetX, offsetY, width, height;

    public AdvQuantiscopePage(ResourceLocation texture, String nameSuffix, int offsetX, int offsetY, int width, int height){
        this.texture = texture;
        this.nameSuffix = nameSuffix;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
