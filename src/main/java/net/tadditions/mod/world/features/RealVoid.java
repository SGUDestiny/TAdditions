package net.tadditions.mod.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.tadditions.mod.blocks.ModBlocks;

import java.util.Random;

public class RealVoid extends Feature<ProbabilityConfig> {
    public RealVoid(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, ProbabilityConfig config) {
        int width = 9 + rand.nextInt(10);  // Width of the ravine
        int depth = 92 + rand.nextInt(16);   // Depth of the ravine
        int length = 78 + rand.nextInt(10); // Length of the ravine

        // Adjust the starting position to the appropriate height
        pos = iSeedReader.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos);

        if (!iSeedReader.isRemote()) {
            // Determine the start and end positions of the ravine
            BlockPos start = pos.add(-width, -depth, -length);
            BlockPos end = pos.add(width, depth, length);

            // Iterate over the positions within the ravine area
            for (BlockPos p : BlockPos.getAllInBoxMutable(start, end)) {
                double xDist = (p.getX() - pos.getX()) / (double) width;
                double yDist = (p.getY() - pos.getY()) / (double) depth;
                double zDist = (p.getZ() - pos.getZ()) / (double) length;
                double distance = xDist * xDist * 2.2 + yDist * yDist + zDist * zDist * 2.2;

                // Add randomness to the oval shape with two sharpened edges
                if (distance < 1.0) {
                    if (p.getY() <= pos.getY() - depth + rand.nextInt(4)) {
                        iSeedReader.setBlockState(p, Blocks.AIR.getDefaultState(), 2);
                    } else if (p.getY() >= pos.getY() + depth - 4) {
                        iSeedReader.setBlockState(p, Blocks.AIR.getDefaultState(), 2);
                    } else {
                        iSeedReader.setBlockState(p, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
