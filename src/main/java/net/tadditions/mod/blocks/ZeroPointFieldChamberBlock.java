package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.QuanSpawnMessage;
import net.tardis.mod.blocks.MultiblockBlock;
import net.tardis.mod.blocks.TileBlock;

import java.util.Random;
import java.util.stream.Stream;

public class ZeroPointFieldChamberBlock extends MultiblockBlock {

    public ZeroPointFieldChamberBlock(Properties prop) {
        super(prop);
    }

    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isRemote() && !player.isCreative()) {
            if (state.getBlock().getDefaultState() == ModBlocks.zero_point_field_normal.get().getDefaultState()) {
                world.setBlockState(pos, ModBlocks.zero_point_field_broken.get().getDefaultState());
            }
            if (state.getBlock().getDefaultState() == ModBlocks.zero_point_field_broken.get().getDefaultState()) {
                super.onBlockHarvested(world, pos, state, player);
            }
        }
    }

}
