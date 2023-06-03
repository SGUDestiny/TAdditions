package net.tadditions.mod.world.carver;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class VoidRavineCarver extends WorldCarver<ProbabilityConfig>{
    private final float[] rs = new float[1024];



    public VoidRavineCarver(Codec<ProbabilityConfig> codec) {
        super(codec, 256);
    }

    private void genCanyon(IChunk chunk, Function<BlockPos, Biome> biomePos, long randomSeed, int seaLevel, int chunkX, int chunkZ, double posX, double posY, double posZ, float size, float rotationYaw, float rotationPitch, int startHeight, int endHeight, double thickness, BitSet carvingMask) {
        Random random = new Random(randomSeed);
        float scale = 1.0F;

        // Pre-calculate random scale values for each height level
        for (int i = 0; i < 256; ++i) {
            if (i == 0 || random.nextInt(3) == 0) {
                scale = 3.0F + random.nextFloat() * random.nextFloat();
            }
            this.rs[i] = scale * scale;
        }

        float f4 = 0.0F;
        float f1 = 0.0F;

        // Generate the canyon shape for each height level
        for (int j = startHeight; j < endHeight; ++j) {
            double d0 = 1.5D + (double)(MathHelper.sin((float)j * (float)Math.PI / (float)endHeight) * size);
            double d1 = d0 * thickness;
            d0 = d0 * ((double)random.nextFloat() * 0.25D + 0.75D);
            d1 = d1 * ((double)random.nextFloat() * 0.25D + 0.75D);
            float f2 = MathHelper.cos(rotationPitch);
            float f3 = MathHelper.sin(rotationPitch);
            posX += (double)(MathHelper.cos(rotationYaw) * f2);
            posY += (double)f3;
            posZ += (double)(MathHelper.sin(rotationYaw) * f2);
            rotationPitch = rotationPitch * 0.7F;
            rotationPitch = rotationPitch + f1 * 0.05F;
            rotationYaw += f4 * 0.05F;
            f1 = f1 * 0.8F;
            f4 = f4 * 0.5F;
            f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f4 = f4 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
            if (random.nextInt(4) != 0) {
                if (!this.func_222702_a(chunkX, chunkZ, posX, posZ, j, endHeight, size)) {
                    return;
                }
                this.func_227208_a_(chunk, biomePos, randomSeed, seaLevel, chunkX, chunkZ, posX, posY, posZ, d0, d1, carvingMask);
            }
        }
    }

    @Override
    protected boolean carveBlock(IChunk chunk, Function<BlockPos, Biome> p_230358_2_, BitSet carvingMask, Random rand, BlockPos.Mutable p_230358_5_, BlockPos.Mutable p_230358_6_, BlockPos.Mutable p_230358_7_, int p_230358_8_, int p_230358_9_, int p_230358_10_, int posX, int posZ, int p_230358_13_, int posY, int p_230358_15_, MutableBoolean isSurface) {
        int i = p_230358_13_ | p_230358_15_ << 4 | posY << 8;
        if (carvingMask.get(i)) {
            return false;
        } else {
            carvingMask.set(i);
            p_230358_5_.setPos(posX, posY, posZ);
            BlockState blockstate = chunk.getBlockState(p_230358_5_);
            BlockState blockstate1 = chunk.getBlockState(p_230358_6_.setAndMove(p_230358_5_, Direction.UP));

            if (!this.canCarveBlock(blockstate, blockstate1)) {
                return false;
            } else {
                    chunk.setBlockState(p_230358_5_, CAVE_AIR, false);
            }

            return true;
        }
    }

    @Override
    public boolean carveRegion(IChunk chunk, Function<BlockPos, Biome> biomePos, Random rand, int seaLevel, int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, BitSet carvingMask, ProbabilityConfig config) {
        int i = (this.func_222704_c() * 2 - 1) * 16;
        double d0 = (double)(chunkXOffset * 16 + rand.nextInt(16));
        double d1 = (double)(rand.nextInt(rand.nextInt(40) + 8) + 20);
        double d2 = (double)(chunkZOffset * 16 + rand.nextInt(16));
        float f = rand.nextFloat() * ((float)Math.PI * 2F);
        float f1 = (rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
        double d3 = 3.0D;
        float f2 = (rand.nextFloat() * 2.0F + rand.nextFloat()) * 14.0F;
        int j = 255;
        int k = 0;
        this.genCanyon(chunk, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, d0, d1, d2, f2, f, f1, 0, j, 9.0D, carvingMask);
        return true;
    }

    @Override
    public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
        return rand.nextFloat() <= config.probability;
    }

    protected boolean func_222708_a(double x, double y, double z, int height) {
        return (x * x + z * z) * (double)this.rs[height - 1] + y * y / 6.0D >= 1.0D;
    }

}
