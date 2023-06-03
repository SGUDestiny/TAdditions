package net.tadditions.mod.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;


public class SpikesSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public SpikesSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
    	//creates grass surface normally
        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
    	this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), seaLevel);
    }

    protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel) {
        BlockState blockstate = top;
        BlockState blockstate1 = middle;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int i = -1;
        int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int k = x & 15;
        int l = z & 15;

        boolean generateSpike = random.nextInt(1000) == 0; // Randomly generate spikes with a 1 in 1000 chance

        for (int i1 = startHeight; i1 >= 0; --i1) {
            blockpos$mutable.setPos(k, i1, l);
            BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);

            if (blockstate2.isAir()) {
                i = -1;
            } else if (blockstate2.matchesBlock(defaultBlock.getBlock())) {
                if (i == -1) {
                    if (j <= 0) {
                        blockstate = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                    } else if (i1 >= sealevel - 4 && i1 <= sealevel + 1) {
                        blockstate = top;
                        blockstate1 = middle;
                    }

                    if (i1 < sealevel && (blockstate == null || blockstate.isAir())) {
                        if (biomeIn.getTemperature(blockpos$mutable.setPos(x, i1, z)) < 0.15F) {
                            blockstate = Blocks.ICE.getDefaultState();
                        } else {
                            blockstate = defaultFluid;
                        }

                        blockpos$mutable.setPos(k, i1, l);
                    }

                    i = j;
                    if (i1 >= sealevel - 1) {
                        if (generateSpike && i1 == sealevel - 1) { // Generate spike at sealevel
                            for (int xOffset = -2; xOffset <= 1; xOffset++) { // Spike width of 4 blocks
                                for (int zOffset = -2; zOffset <= 1; zOffset++) { // Spike width of 4 blocks
                                    blockpos$mutable.setPos(xOffset + k, i1, zOffset + l);
                                    chunkIn.setBlockState(blockpos$mutable, top, false);
                                }
                            }
                        } else {
                            chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                        }
                    } else if (i1 < sealevel - 7 - j) {
                        blockstate = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                        chunkIn.setBlockState(blockpos$mutable, bottom, false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }
                } else if (i > 0) {
                    --i;
                    chunkIn.setBlockState(blockpos$mutable, blockstate1, false);

                    if (i == 0 && blockstate1.matchesBlock(Blocks.SAND) && j > 1) {
                        i = random.nextInt(4) + Math.max(0, i1 - 63);
                        blockstate1 = blockstate1.matchesBlock(Blocks.RED_SAND) ? Blocks.RED_SANDSTONE.getDefaultState() : Blocks.SANDSTONE.getDefaultState();
                    }
                }
            }
        }
    }


}
