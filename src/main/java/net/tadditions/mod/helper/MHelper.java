package net.tadditions.mod.helper;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.registries.TardisStatistics;

import javax.annotation.Nullable;

public class MHelper {

    public static boolean isInBounds(int testX, int testY, int x, int y, int u, int v) {
        return (testX > x &&
                testX < u &&
                testY > y &&
                testY < v);
    }

    public static ResourceLocation createRL(String string) {
        return new ResourceLocation(QolMod.MOD_ID, string);
    }
}
