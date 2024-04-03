package net.tadditions.mod.helper;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.tardis.mod.Tardis;

import java.util.HashMap;
import java.util.Map;

public class TAStatistics {

    private static Map<ResourceLocation, IStatFormatter> CUSTOM_STAT_ENTRIES = new HashMap<>();

    public static final ResourceLocation TARDIS_LIFTOFF = registerCustom("tardis_liftoffs", IStatFormatter.DEFAULT);

    private static ResourceLocation registerCustom(String key, IStatFormatter formatter) {
        ResourceLocation resourcelocation = new ResourceLocation(Tardis.MODID, key);
        CUSTOM_STAT_ENTRIES.put(resourcelocation, formatter);
        return resourcelocation;
    }

    /** Adds the Stat to Vanilla Custom Stat registry and makes a Stat in the custom stat's map
     * <br> Called during FMLCommonSetup*/
    public static void addStatTypesToVanilla() {
        CUSTOM_STAT_ENTRIES.forEach((resourcelocation, formatter) -> {
            Registry.register(Registry.CUSTOM_STAT, resourcelocation, resourcelocation); //There is no Forge registry for the Custom stat so we use vanilla's
            Stats.CUSTOM.get(resourcelocation, formatter); //Adds our stat to the stat type's map
        });
    }

}
