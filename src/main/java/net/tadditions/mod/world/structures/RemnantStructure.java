package net.tadditions.mod.world.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.helper.FancyJigsawConfig;
import net.tadditions.mod.helper.FancyJigsawManager;
import org.spongepowered.asm.logging.Level;

public class RemnantStructure extends Structure<ProbabilityConfig>{

    public RemnantStructure(Codec<ProbabilityConfig> codec) {
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
        	int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int modX = rand.nextInt(32);
            int modY = rand.nextInt(32);
            int surfaceY = chunkGenerator.getHeight(x+modX, z+modY, Heightmap.Type.WORLD_SURFACE_WG);
            if (rand.nextFloat() <= config.probability) {
            	BlockPos blockpos = new BlockPos(x+modX, surfaceY-9, z+modY);
                BlockPos centerPos = new BlockPos(x+modX, 0, z+modY);
                FancyJigsawManager.assembleJigsawStructure(
                        dynamicRegistryManager,
                        new FancyJigsawConfig(() -> dynamicRegistryManager.func_230521_a_(Registry.JIGSAW_POOL_KEY).get().getOptional(new ResourceLocation(QolMod.MOD_ID, "shaft_starter")).get(),
                                // How many pieces outward from center can a recursive jigsaw structure spawn.
                                // Our structure is only 1 piece outward and isn't recursive so any value of 1 or more doesn't change anything.
                                // However, I recommend you keep this a decent value like 10 so people can use datapacks to add additional pieces to your structure easily.
                                // But don't make it too large for recursive structures like villages or you'll crash server due to hundreds of pieces attempting to generate!
                                1230),
                        chunkGenerator,
                        templateManagerIn,
                        blockpos, // Position of the structure. Y value is ignored if last parameter is set to true.
                        this.components, // The list that will be populated with the jigsaw pieces after this method.
                        this.rand,
                        true, // Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                        // Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                        false);  // Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.

                // **THE FOLLOWING LINE IS OPTIONAL**
                //
                // Right here, you can do interesting stuff with the pieces in this.pieces such as offset the
                // center piece by 50 blocks up for no reason, remove repeats of a piece or add a new piece so
                // only 1 of that piece exists, etc. But you do not have access to the piece's blocks as this list
                // holds just the piece's size and positions. Blocks will be placed much later by the game.
                //
                // In this case, we do `piece.offset` to raise pieces up by 1 block so that the house is not right on
                // the surface of water or sunken into land a bit. NOTE: land added by Structure.NOISE_AFFECTING_FEATURES
                // will also be moved alongside the piece. If you do not want this land, do not add your structure to the
                // Structure.NOISE_AFFECTING_FEATURES field and now your pieces can be set on the regular terrain instead.
                //this.components.forEach(piece -> piece.move(0, 1, 0));

                // Since by default, the start piece of a structure spawns with it's corner at centerPos
                // and will randomly rotate around that corner, we will center the piece on centerPos instead.
                // This is so that our structure's start piece is now centered on the water check done in isFeatureChunk.
                // Whatever the offset done to center the start piece, that offset is applied to all other pieces
                // so the entire structure is shifted properly to the new spot.
                Vector3i structureCenter = this.components.get(0).getBoundingBox().func_215126_f();
                int xOffset = centerPos.getX() - structureCenter.getX();
                int zOffset = centerPos.getZ() - structureCenter.getZ();
                for(StructurePiece structurePiece : this.components){
                    structurePiece.offset(xOffset, 0, zOffset);;
                }

                // Sets the bounds of the structure once you are finished.
                this.recalculateStructureSize();
            }
		}


    	
    }

}
