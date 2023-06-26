package net.tadditions.mod.events;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.ModItemGroups;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.items.BaseItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.properties.Prop;

@Mod.EventBusSubscriber(modid = QolMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MercuryEvent {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        // Check if the item being registered is the one you want to modify
        if (event.getName().equals(TItems.MERCURY_BOTTLE.getId())) {
            // Create a new instance of the item class or subclass it if necessary
            Item originalItem = event.getRegistry().getValue(TItems.MERCURY_BOTTLE.getId());
            Item modifiedItem = new ModifiedContainerItem();
            modifiedItem.setRegistryName(originalItem.getRegistryName());

            // Replace the original item with your modified item instance
            event.getRegistry().register(modifiedItem);
        }
    }

    public static class ModifiedContainerItem extends Item {
        public ModifiedContainerItem() {
            super(Prop.Items.SIXTY_FOUR.get().containerItem(Items.GLASS_BOTTLE));
        }
    }
    public static class OneItem extends Item {
        public OneItem() {
            super(Prop.Items.ONE.get().group(ModItemGroups.TA));
        }
    }

    public static class SixyItem extends Item {
        public SixyItem() {
            super(Prop.Items.SIXTY_FOUR.get().group(ModItemGroups.TA));
        }
    }
}
