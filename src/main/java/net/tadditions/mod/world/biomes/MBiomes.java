package net.tadditions.mod.world.biomes;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tardis.mod.Tardis;

import java.util.function.Supplier;

public class MBiomes {

    public static RegistryKey<Biome> MOON_BIOME_KEY;
    public static RegistryKey<Biome> TAGREA_BIOME_KEY;
	
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Tardis.MODID);
    //Register the Tardis biome via code. This ensures the SingleBiomeProvider, which is used in the TardisChunkGenerator, won't experience MC-197616

    //Register dummy biomes here for our json dimensions so that the ID is safely taken up and can be replaced by jsons
    //No static variable to hold as these dummy biomes should NOT be held and referenced elsewhere.
    
    //Comment out the registration of these biomes, this forces those dimensions' chunk generators to use the json biome version. 
    //Otherwise the chunk generator will be using the void biome settings
    //NOTE: If you use a JSON biome in a SingleBiomeProvider, MC-197616 bug will occur
    static {
//    	createBiome("moon_field", () -> BiomeMaker.makeVoidBiome());
//    	createBiome("vortex", () -> BiomeMaker.makeVoidBiome());
//    	createBiome("space", () -> BiomeMaker.makeVoidBiome());
    }
    
    /**
     * Creates the RegistryKeys needed to reference a Biome
     * <br> Call this in an enqueueWork lambda function inside FMLCommonSetupEvent
     */
    public static void registerBiomeKeys() {
    	MOON_BIOME_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Tardis.MODID, "mars_field"));
        TAGREA_BIOME_KEY = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Tardis.MODID, "mars_field"));

    }
    
    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) {
        return BIOMES.register(name, biome);
    }

}
