package net.tadditions.mod.screens.manual.pages;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.screens.manual.pages.serializers.CoverPageSerializer;
import net.tadditions.mod.screens.manual.pages.serializers.NormalPageSerializer;
import net.tadditions.mod.screens.manual.pages.serializers.PageSerializer;
import net.tardis.mod.Tardis;
import org.apache.logging.log4j.Level;

import java.io.InputStreamReader;
import java.util.List;

public class Page {

    private static final List<PageSerializer> SERIALIZERS = Lists.newArrayList();

    public static final int WIDTH = 65, LINES = 10, MAX_LINE_WIDTH = 115;
    protected List<String> lines = Lists.newArrayList();

    public Page(){}
    
    static {
        SERIALIZERS.add(new NormalPageSerializer());
        SERIALIZERS.add(new CoverPageSerializer());
    }
    
    /** Gets the number of new lines which all the text will be rendered as*/
    public List<String> getLines(){
        return this.lines;
    }

    //Returns true if this page was clicked
    //public boolean onClick(int x, int y){
    //    if(x < this.x)
    //}

    //Returns left over string
    public String parseString(String page){

        FontRenderer font = Minecraft.getInstance().fontRenderer;
        List<String> words = Lists.newArrayList(page.split(" "));

        this.lines.clear();
        int currentWidth = 0;

        StringBuilder line = new StringBuilder();
        String prevLineWord = "";
        for(int i = 0; i < words.size(); ++i){
            String word = words.get(i);
            int width = font.getStringWidth(word);
            currentWidth += width;
            
            int prevLineWidth = font.getStringWidth(line.toString());
            
            //If this new word can fit on this line and the line with the previous words can fit
            if(currentWidth < WIDTH && prevLineWidth < WIDTH){
            	prevLineWord = line.toString();
            	line.append(word).append(" "); //Include previous and current word on the same line
            }
            //If we should start a new line
            else{
            	//If the length of the line we have just constructed is also over the limit, split the words onto new lines
            	int appendedWordWidth = font.getStringWidth(line.toString());
            	if (appendedWordWidth > WIDTH) {
            		if (appendedWordWidth >= MAX_LINE_WIDTH) {
            			String split = line.substring(prevLineWord.length());
            			this.lines.add(prevLineWord);
                		this.lines.add(split);
                		line = new StringBuilder(word + " ");
                        currentWidth = 0;
            		}
            		//If the line is smaller than the max allowed line width but still larger than the page character limit
                    else {
                    	this.lines.add(line.toString());
                    	line = new StringBuilder(word + " ");
                        currentWidth = 0;
                    }
            	}
            	//If previous word and current word are within limit
            	else {
            		this.lines.add(line.toString());
                	line = new StringBuilder(word + " ");
                    currentWidth = 0;
            	}
            }

            //If there are too many lines, return the remaining words
            if(lines.size() >= LINES){
                StringBuilder build = new StringBuilder();
                for(String s : words.subList(i, words.size())){
                    build.append(s).append(" ");
                }
                return build.toString();
            }

        }

        this.lines.add(line.toString());

        return ""; //DO NOT CHANGE THIS or you will soft lock the game
    }

    public int getNumberOfLines(){
        return this.lines.size();
    }

    public void render(MatrixStack stack, FontRenderer font, int globalPage, int x, int y, int width, int height){
        int index = 0;
        for(String lines : this.getLines()){
            font.drawString(stack, lines, x, y + (font.FONT_HEIGHT + 2) * index, 0x000000);
            ++index;
        }

        //draw page number
        font.drawString(stack, globalPage + "", x + (WIDTH) / 2 + font.getStringWidth(globalPage + "") / 2, y + 120, 0x000000);

    }

    public static List<Page> read(ResourceLocation id){
        try{

            JsonObject root = new JsonParser().parse(new InputStreamReader(Minecraft.getInstance().getResourceManager().getResource(id).getInputStream())).getAsJsonObject();

            String type = root.get("type").getAsString();

            for(PageSerializer serializer : SERIALIZERS){
                if(serializer.match(type)){
                    return serializer.read(root);
                }
            }

        }
        catch(Exception e){
            Tardis.LOGGER.log(Level.INFO, String.format("Exception in manual page %s!", id.toString()));
            Tardis.LOGGER.catching(Level.INFO, e);
        }
        return null;
    }
    
    public static ResourceLocation getPageResourceLocation(ResourceLocation loc, String localeCode){
        return new ResourceLocation(loc.getNamespace(), "manual/" + localeCode + "/page/" + loc.getPath() + ".json");
    }

    public void onClick(double x, double y) {}
}
