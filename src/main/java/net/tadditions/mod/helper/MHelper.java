package net.tadditions.mod.helper;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.config.MConfigs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static List<World> blockedDimensions(){
        List<World> types = new ArrayList<>();
        MConfigs.SERVER.BlockedDimensions.get().forEach(dim -> {
            Optional<World> type = DynamicRegistries.func_239770_b_().getRegistry(Registry.WORLD_KEY).getOptional(ResourceLocation.tryCreate(dim));
            type.ifPresent(types::add);
        });
        return types;
    }
}
