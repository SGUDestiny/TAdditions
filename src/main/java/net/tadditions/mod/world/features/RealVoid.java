package net.tadditions.mod.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
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
        int width = 6 + rand.nextInt(10);  // Width of the ravine
        int depth = 4 + rand.nextInt(6);   // Depth of the ravine
        int length = 20 + rand.nextInt(30); // Length of the ravine

        // Adjust the starting position to the appropriate height
        pos = iSeedReader.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos).up(depth);

        if (!iSeedReader.isRemote()) {
            // Determine the start and end positions of the ravine
            BlockPos start = pos.add(-width, -depth, -length);
            BlockPos end = pos.add(width, depth, length);

            // Iterate over the positions within the ravine area
            for (BlockPos p : BlockPos.getAllInBoxMutable(start, end)) {
                // Calculate the distance from the current position to the center of the ravine
                double distance = calculateDistance(p, pos);

                // Modify the terrain if within the ravine bounds
                if (distance < width) {
                    if (p.getY() < pos.getY() || p.getY() > pos.getY() + depth) {
                        iSeedReader.setBlockState(p, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }
            return true;
        }
        return false;
    }

    // Calculate the distance between two block positions in 3D space
    private double calculateDistance(BlockPos pos1, BlockPos pos2) {
        double dx = pos1.getX() - pos2.getX();
        double dy = pos1.getY() - pos2.getY();
        double dz = pos1.getZ() - pos2.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }


}
