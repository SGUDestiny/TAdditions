package net.tadditions.mod.compat.create;

import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;

public class CreateItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, QolMod.MOD_ID);

    //public static final RegistryObject<Item> INCOMPLETE_SUBSYSTEM_FRAME = ITEMS.register("incomplete_subsystem_frame", () -> createItem(new SequencedAssemblyItem((new Item.Properties()).group(ModItemGroups.TA))));
    //public static final RegistryObject<Item> SUBSYSTEM_FRAME = ITEMS.register("subsystem_frame", () -> createItem(new Item((new Item.Properties()).group(ModItemGroups.TA))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static <T extends Item> T createItem(T item) {
        return item;
    }

    public static <T extends BlockItem> T createBlockItem(T item) {
        return item;
    }
}
