package net.tadditions.mod.worldgen.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.fml.ModList;
import net.povstalec.sgjourney.common.config.CommonGenerationConfig;
import net.povstalec.sgjourney.common.structures.StargateStructure;

import java.util.Optional;
import java.util.Random;

public class VergeGateStructure extends TABaseStructure{

    public static final Codec<VergeGateStructure> CODEC = RecordCodecBuilder.<VergeGateStructure>mapCodec(instance ->
            instance.group(VergeGateStructure.settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, VergeGateStructure::new)).codec();

    public VergeGateStructure(StructureSettings config, Holder<StructureTemplatePool> startPool, Optional<ResourceLocation> startJigsawName, int size, HeightProvider startHeight, Optional<Heightmap.Types> projectStartToHeightmap, int maxDistanceFromCenter) {
        super(config, startPool, startJigsawName, size, startHeight, projectStartToHeightmap, maxDistanceFromCenter);
    }

    @Override
    protected boolean extraSpawningChecks(GenerationContext context) {
        return ModList.get().isLoaded("sgjourney") && context.chunkPos().x == StargateStructure.getX(context.seed()) && context.chunkPos().z == StargateStructure.getZ(context.seed());
    }



    @Override
    public StructureType<?> type() {
        return null;
    }
}
