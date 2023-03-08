package net.tadditions.mod.screens.manual.pages;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.tadditions.mod.screens.manual.Chapter;
import net.tadditions.mod.screens.manual.UpgradesManualScreen;

import java.util.ArrayList;
import java.util.List;

public class TOCPage extends Page {

    private final List<NamedAction> actions = new ArrayList<>();
    private final UpgradesManualScreen manual;
    private int maxIndex = 0;
    private int minIndex = 0;
    public static final int MAX_LINES = 13;

    public TOCPage(UpgradesManualScreen manual, int minIndex, int maxIndex){
        this.manual = manual;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.addButtons(manual);
    }

    public void addButtons(UpgradesManualScreen screen){
        int index = 0;
        if (this.maxIndex < screen.getChapters().size() && this.minIndex < screen.getChapters().size()) {
        	for(int chapterIndex = this.minIndex; chapterIndex <= this.maxIndex;){
            	Chapter chapter = screen.getChapters().get(chapterIndex);
            	if (chapter != null) {
            		if(!chapter.getDisplayName().isEmpty()){
                        final int finalIndex = chapterIndex;
                        this.actions.add(new NamedAction(chapter.getDisplayName(), () -> {
                            screen.openPage(finalIndex, 0);
                        }, Minecraft.getInstance().fontRenderer.FONT_HEIGHT * index));
                        ++index;
                    }
            		chapterIndex++;
            	}
            }
        }
        
    }

    @Override
    public void render(MatrixStack stack, FontRenderer font, int globalPage, int x, int y, int width, int height) {
        //super.render(stack, font, globalPage, x, y, width, height);
    	font.drawText(stack, new StringTextComponent("Table of Contents").mergeStyle(TextFormatting.ITALIC), x, y - 10, 0x000000);
        for(int i = 0; i < this.actions.size(); ++i){
            NamedAction action = this.actions.get(i);
            font.drawText(stack, new StringTextComponent(action.name), x, y + action.y + font.FONT_HEIGHT - 5, 0x463316);
        }
    }

    @Override
    public void onClick(double x, double y) {
        for(NamedAction action : this.actions){
            if(action.isInBounds((int)Math.floor(y), Minecraft.getInstance().fontRenderer.FONT_HEIGHT)){
                action.act();
                return;
            }
        }
    }

    public static class NamedAction{

        private String name;
        private Runnable action;
        private int y;

        public NamedAction(String name, Runnable action, int y){
            this.name = name;
            this.action = action;
            this.y = y;
        }

        public String getName(){
            return name;
        }

        public void act(){
            this.action.run();
        }

        public boolean isInBounds(int y, int fontHeight){
            return y > this.y && y < this.y + fontHeight;
        }

    }

}
