package net.tadditions.mod.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;

public class ModItemGroups {
     public static ItemGroup ROUNDELCONS = new ItemGroup(QolMod.MOD_ID + ".roundelcons") {
         @Override
          public ItemStack createIcon() {
             return new ItemStack(ModBlocks.roundelcon_alabaster.get());
         }
     };

    public static ItemGroup TA = new ItemGroup(QolMod.MOD_ID + ".temporal") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ARTRON_CAPACITOR_TEMPORAL.get());
        }
    };
}
