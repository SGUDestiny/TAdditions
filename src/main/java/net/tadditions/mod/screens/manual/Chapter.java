package net.tadditions.mod.screens.manual;

import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.screens.manual.pages.Page;
import net.tardis.mod.Tardis;
import org.apache.logging.log4j.Level;

import java.util.List;

public class Chapter {

    private List<Page> pages = Lists.newArrayList();
    private String displayName;

    public Chapter(String display, List<Page> pages){
        this.displayName = display;
        this.pages.addAll(pages);
    }

    public List<Page> getPages(){
        return this.pages;
    }
    
    public String getDisplayName() {
    	return this.displayName;
    }

    public void insertPage(int index, Page page){
        this.pages.add(index, page);
    }

    public static Chapter read(ResourceLocation id, JsonObject object, String localeCode){
       try{
           String display = object.get("display_name").getAsString();

           List<Page> pages = Lists.newArrayList();

            for(JsonElement e : object.get("pages").getAsJsonArray()){
                ResourceLocation pageID = Page.getPageResourceLocation(new ResourceLocation(e.getAsString()), localeCode);
                pages.addAll(Page.read(pageID));
            }

            return new Chapter(display, pages);

       }
       catch(Exception e){
           Tardis.LOGGER.log(Level.ALL, "Caught error in manual chapter " + id.toString());
           return null;
       }
    }
    
	public static ResourceLocation getChapterResourceLocation(ResourceLocation loc, String localeCode){
        return new ResourceLocation(loc.getNamespace(), "manual/" + localeCode + "/chapter/" + loc.getPath() + ".json");
    }

}
