package net.tadditions.mod.world.surfacebuilders;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tardis.mod.Tardis;
import net.tardis.mod.world.surfacebuilders.MoonSurfaceBuilder;
import net.tardis.mod.world.surfacebuilders.TSurfaceBuilders;

import java.util.function.Supplier;

public class MCSB {
    public static class SurfaceBuilders{
        public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, QolMod.MOD_ID);

        //Register the earlier created instance of our surface builder. We have to do this seperately the surface builders register AFTER biomes, so this is just to ensure it won't cause issues when the game has fully setup.
        public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> MARS_SURFACE_BUILDER = createSurfaceBuilder("mars_surface", () -> new MarsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
        public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> REMAINS_SURFACE_BUILDER = createSurfaceBuilder("remains_surface", () -> new RemainsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
        public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> SPIKES_SURFACE_BUILDER = createSurfaceBuilder("spikes_surface", () -> new SpikesSurfaceBuilder(SurfaceBuilderConfig.CODEC));

    }

    private static <S extends SurfaceBuilder<?>> RegistryObject<S> createSurfaceBuilder(String name, Supplier<? extends S> surfaceBuilder) {
        return MCSB.SurfaceBuilders.SURFACE_BUILDERS.register(name, surfaceBuilder);
    }

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> registerConfiguredSurfaceBuilder(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(QolMod.MOD_ID, name), configuredSurfaceBuilder);
    }
}

