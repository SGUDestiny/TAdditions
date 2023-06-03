package net.tadditions.mod.world.features;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tardis.mod.Tardis;
import net.tardis.mod.world.feature.TFeatures;


public class MFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, QolMod.MOD_ID);

    public static final RegistryObject<Feature<ProbabilityConfig>> REALSPIKE = FEATURES.register("realspike", () -> new RealSpike(ProbabilityConfig.CODEC));
    public static final RegistryObject<Feature<ProbabilityConfig>> REALVOID = FEATURES.register("realvoid", () -> new RealVoid(ProbabilityConfig.CODEC));


    public static class ConfiguredFeatures {
        public static final ConfiguredFeature<?, ?> CONFIGURED_REALSPIKE = MFeatures.REALSPIKE.get().withConfiguration(new ProbabilityConfig(0.78F)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(78))).square();
        public static final ConfiguredFeature<?, ?> CONFIGURED_REALVOID = MFeatures.REALVOID.get().withConfiguration(new ProbabilityConfig(0.78F)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(78))).square();

    }

    public static void registerConfiguredFeatures() {
        registerConfiguredFeature("realspike", ConfiguredFeatures.CONFIGURED_REALSPIKE);
        registerConfiguredFeature("realvoid", ConfiguredFeatures.CONFIGURED_REALVOID);
    }

    private static <T extends Feature<?>> void registerConfiguredFeature(String registryName, ConfiguredFeature<?,?> configuredFeature) {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(QolMod.MOD_ID, registryName), configuredFeature);
    }
}
