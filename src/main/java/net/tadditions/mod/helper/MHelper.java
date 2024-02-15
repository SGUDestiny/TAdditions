package net.tadditions.mod.helper;

import com.google.common.collect.Lists;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.config.MConfigs;
import net.tardis.mod.helper.NBTHelper;
import net.tardis.mod.helper.WorldHelper;
import org.spongepowered.asm.mixin.Dynamic;

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

    public static List<RegistryKey<World>> availableDimensions(){
        List<RegistryKey<World>> types = new ArrayList<>();
        ServerLifecycleHooks.getCurrentServer().getWorlds().forEach(world -> {
            if(WorldHelper.canTravelToDimension(world) && !MConfigs.SERVER.BlockedDimensions.get().contains(world.getDimensionKey().getLocation().toString())) {
                types.add(world.getDimensionKey());
            }
        });
        return types;
    }
}
