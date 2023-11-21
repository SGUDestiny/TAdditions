package net.tadditions.mod.compat.create;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;

public class CreateItems {

    public static final RegistryObject<Item> FOODCUBE = ModItems.ITEMS.register("unfinished_subsystem_item", () -> createItem(new Item((new Item.Properties()).group(ModItemGroups.TA))));


    public static void register(IEventBus eventBus) {
        ModItems.ITEMS.register(eventBus);
    }

    public static <T extends Item> T createItem(T item) {
        return item;
    }

    public static <T extends BlockItem> T createBlockItem(T item) {
        return item;
    }
}
