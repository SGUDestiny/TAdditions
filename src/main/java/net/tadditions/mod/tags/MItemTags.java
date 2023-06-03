package net.tadditions.mod.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.helper.MHelper;
import net.tardis.mod.tags.TardisItemTags;

import java.util.function.Function;

public class MItemTags extends TardisItemTags {
    public static final ITag<Item> FOODMAKER = makeItem(MHelper.createRL("foodmaker"));
    public static final ResourceLocation SCORCHEDLOG = new ResourceLocation(QolMod.MOD_ID, "scorched");

    public static ITag.INamedTag<Item> makeItem(ResourceLocation resourceLocation) {
        return ItemTags.makeWrapperTag(resourceLocation.toString()); //makeWrapperTag can be static inited and is aware of tag reloads. Do not use createOptional because that gets loaded too early.
    }

}
