package net.tadditions.mod.screens.manual.pages.serializers;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.screens.manual.pages.CoverPage;
import net.tadditions.mod.screens.manual.pages.Page;

import java.util.List;

public class CoverPageSerializer extends PageSerializer {

    public CoverPageSerializer() {
        super(str -> str.contentEquals("cover"));
    }

    @Override
    public List<Page> read(JsonObject root) {
        CoverPage page = new CoverPage();

        page.setTitle(root.get("title").getAsString());

        if(root.has("icon"))
            page.setIcon(new ResourceLocation(root.get("icon").getAsString()));

        return Lists.newArrayList(page);
    }
}
