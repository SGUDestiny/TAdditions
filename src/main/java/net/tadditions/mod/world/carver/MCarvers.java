package net.tadditions.mod.world.carver;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.EmptyCarverConfig;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.flightevents.Vector;
import net.tadditions.mod.world.biomes.MBiomes;
import net.tadditions.mod.world.surfacebuilders.MCSB;
import net.tadditions.mod.world.surfacebuilders.MarsSurfaceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class MCarvers {
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, QolMod.MOD_ID);

    public static final RegistryObject<WorldCarver<ProbabilityConfig>> VOID_RAVINE = createCarver("void_ravine", () -> new VoidRavineCarver(ProbabilityConfig.CODEC));


    private static <S extends WorldCarver<?>> RegistryObject<S> createCarver(String name, Supplier<? extends S> surfaceBuilder) {
        return CARVERS.register(name, surfaceBuilder);
    }

}
