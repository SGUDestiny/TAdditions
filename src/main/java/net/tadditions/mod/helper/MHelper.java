package net.tadditions.mod.helper;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.tadditions.mod.QolMod;
import net.tardis.mod.registries.TardisStatistics;
import net.tardis.mod.tileentities.ConsoleTile;

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

    public static void addTardisStatistic(ConsoleTile tile, ResourceLocation statLoc) {
        addTardisStatistic(tile.getPilot(), statLoc);
    }

    public static void addTardisStatistic(@Nullable PlayerEntity player, ResourceLocation statLoc) {
        if (player != null)
            player.addStat(statLoc);
    }

    public static void addTardisDistanceTravelledStat(@Nullable PlayerEntity player, BlockPos start, BlockPos end) {
        BlockPos diff = start.subtract(end);
        if (player != null)
            addTardisDistanceTravelledStat(player, diff.getX(), diff.getY(), diff.getZ());
    }

    public static void addTardisDistanceTravelledStat(PlayerEntity player, double diffX, double diffY, double diffZ) {
        int dist = Math.round(MathHelper.sqrt(diffX * diffX + diffZ * diffZ) * 100.0F);
        player.addStat(TardisStatistics.TARDIS_DISTANCE_TRAVELLED, dist);
    }
}
