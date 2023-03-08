package net.tadditions.mod.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.helper.MHelper;
import net.tardis.mod.tags.TardisItemTags;

import java.util.function.Function;

public class MItemTags extends TardisItemTags {
    public static final ITag<Item> FOODMAKER = makeItem(MHelper.createRL("foodmaker"));

    public static ITag.INamedTag<Item> makeItem(ResourceLocation resourceLocation) {
        return ItemTags.makeWrapperTag(resourceLocation.toString()); //makeWrapperTag can be static inited and is aware of tag reloads. Do not use createOptional because that gets loaded too early.
    }

    public static <T> ITag.INamedTag<T> tag(Function<ResourceLocation, ITag.INamedTag<T>> wrapperFactory, String namespace,
                                            String path) {
        return wrapperFactory.apply(new ResourceLocation(namespace, path));
    }

    public static <T> ITag.INamedTag<T> forgeTag(Function<ResourceLocation, ITag.INamedTag<T>> wrapperFactory, String path) {
        return tag(wrapperFactory, "forge", path);
    }

    public static ITag.INamedTag<Block> forgeBlockTag(String path) {
        return forgeTag(BlockTags::createOptional, path);
    }

    public static ITag.INamedTag<Item> forgeItemTag(String path) {
        return forgeTag(ItemTags::createOptional, path);
    }

}
