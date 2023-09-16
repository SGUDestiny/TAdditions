package net.tadditions.mod.world.structures;

import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class VergeRuinsStructure extends Structure<ProbabilityConfig>{

    public VergeRuinsStructure(Codec<ProbabilityConfig> codec) {
        super(codec);
    }
    
    //Required, sets the Structure Start settings
    @Override
    public IStartFactory<ProbabilityConfig> getStartFactory() {
        return Start::new;
    }
    
//    @Override
//    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
//        return STRUCTURE_CREATURES;
//    }

//    private static final List<MobSpawnInfo.Spawners> STRUCTURE_CREATURES = ImmutableList.of(
//        new MobSpawnInfo.Spawners(TEntities.CREWMATE.get(), 2, 1, 5) 
//    );
//    
//    @Override
//    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
//        return STRUCTURE_CREATURES;
//    }
    
//    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
//            new MobSpawnInfo.Spawners(EntityType.SKELETON, 50, 3, 8)
//    );
//    
//    @Override
//	public List<Spawners> getSpawnList() {
//		return STRUCTURE_MONSTERS;
//	}

	//Required, otherwise will cause NPE Crash
    @Override
    public Decoration getDecorationStage() {
        return Decoration.SURFACE_STRUCTURES;
    }
    
    @Override
	public boolean getDefaultRestrictsSpawnsToInside() {
		return true;
	}
    
    public static class Start extends StructureStart<ProbabilityConfig>  {

    	public Start(Structure<ProbabilityConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

		@Override
		public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, ProbabilityConfig config) {
			Rotation rotation = Rotation.NONE;
        	int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int surfaceY = chunkGenerator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            if (rand.nextFloat() <= config.probability) {
            	BlockPos blockpos = new BlockPos(x, surfaceY, z);
                ScorchedStructurePieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);
                this.recalculateStructureSize();
            }
		}
    	
    }

}
