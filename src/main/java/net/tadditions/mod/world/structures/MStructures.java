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
        setupStructure(Structures.SCORCHEED.get(), new StructureSeparationSettings(15, 10, 1234567890), true);
    }

    public static class ConfiguredStructures {

        public static StructureFeature<?, ?> CONFIGURED_SCORCHEED = Structures.SCORCHEED.get().withConfiguration(new ProbabilityConfig(35));

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
        return MStructures.Structures.STRUCTURES.register(name, structure);
    }

    public static IStructurePieceType registerStructurePiece(IStructurePieceType type, String key) {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(QolMod.MOD_ID, key), type);
    }

    public static <F extends Structure<?>> void setupStructure(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {
        /*
         * We need to add our structures into the map in Structure alongside vanilla
         * structures or else it will cause errors. Called by registerStructure.
         *
         * If the registration is setup properly for the structure,
         * getRegistryName() should never return null.
         */
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        /*
         * Whether surrounding land will be modified automatically to conform to the bottom of the structure.
         * Basically, it adds land at the base of the structure like it does for Villages and Outposts.
         * Doesn't work well on structure that have pieces stacked vertically or change in heights.
         *
         * Note: The air space this method will create will be filled with water if the structure is below sealevel.
         * This means this is best for structure above sealevel so keep that in mind.
         */
        if(transformSurroundingLand){
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.field_236384_t_)
                            .add(structure)
                            .build();
        }

        /*
         * Adds the structure's spacing into several places so that the structure's spacing remains
         * correct in any dimension or worldtype instead of not spawning.
         *
         * However, it seems it doesn't always work for code made dimensions as they read from
         * this list beforehand. Use the WorldEvent.Load event in StructureTutorialMain to add
         * the structure spacing from this list into that dimension.
         */
        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();
    }

}
