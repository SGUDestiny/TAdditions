package net.tadditions.mod.screens.manual;

import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.Tardis;
import net.tardis.mod.client.ClientHelper;
import org.apache.logging.log4j.Level;

import java.util.List;

public class Index{
	private List<Chapter> chapters = Lists.newArrayList();
	
	public Index(List<Chapter> chapters){
        this.chapters.addAll(chapters);
    }
	
	public List<Chapter> getChapters(){
        return this.chapters;
    }

    public static Index read(ResourceLocation id, JsonObject object, String localeCode){
       try{
           List<Chapter> chapters = Lists.newArrayList();

           for(JsonElement e : object.get("chapters").getAsJsonArray()){
                ResourceLocation chapterID = Chapter.getChapterResourceLocation(new ResourceLocation(e.getAsString()), localeCode);
                chapters.add(Chapter.read(chapterID, ClientHelper.getResourceAsJson(chapterID), localeCode));
           }

           return new Index(chapters);

       }
       catch(Exception e){
           Tardis.LOGGER.log(Level.ALL, "Caught error in manual index " + id.toString());
           return null;
       }
    }
    
    public static ResourceLocation getIndexResourceLocation(ResourceLocation loc, String localeCode){
        return new ResourceLocation(loc.getNamespace(), "manual/" + localeCode + "/index/" + loc.getPath() + ".json");
    }
	
}