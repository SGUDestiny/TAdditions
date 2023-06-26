package net.tadditions.mod.world.structures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tadditions.mod.QolMod;
import net.tardis.mod.Tardis;
import net.tardis.mod.config.TConfig;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.world.structures.MoonLanderStructure;
import net.tardis.mod.world.structures.MoonLanderStructurePieces;
import net.tardis.mod.world.structures.TStructures;

import java.util.function.Supplier;

public class MStructures {
    public static class Structures {
        public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, QolMod.MOD_ID);

        public static final RegistryObject<Structure<ProbabilityConfig>> SCORCHEED = setupStructure("scorched", () -> (new SchorchedStructure(ProbabilityConfig.CODEC)));
        public static IStructurePieceType SCORCHEED_PIECE = registerStructurePiece(ScorchedStructurePieces.Piece::new, "scorched");

    }
    public static void setupStructures() {
        TStructures.setupStructure(Structures.SCORCHEED.get(), new StructureSeparationSettings(5, 3, 1234567890), true);
    }

    public static class ConfiguredStructures {

        public static StructureFeature<?, ?> CONFIGURED_SCORCHEED = Structures.SCORCHEED.get().withConfiguration(new ProbabilityConfig(1F));

        public static void registerConfiguredStructures() {
            registerConfiguredStructure("scorched", Structures.SCORCHEED, CONFIGURED_SCORCHEED);
        }

        private static <T extends Structure<?>> void registerConfiguredStructure(String registryName, Supplier<T> structure, StructureFeature<?, ?> configuredStructure) {
            Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
            Registry.register(registry, new ResourceLocation(QolMod.MOD_ID, registryName), configuredStructure);

            FlatGenerationSettings.STRUCTURES.put(structure.get(), configuredStructure);
        }
    }

    private static <T extends Structure<?>> RegistryObject<T> setupStructure(String name, Supplier<T> structure) {
        return Structures.STRUCTURES.register(name, structure);
    }

    public static IStructurePieceType registerStructurePiece(IStructurePieceType type, String key) {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(QolMod.MOD_ID, key), type);
    }

}
