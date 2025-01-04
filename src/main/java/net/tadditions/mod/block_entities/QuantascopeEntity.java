package net.tadditions.mod.block_entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tadditions.mod.init.BlockEntityInit;

public class QuantascopeEntity extends BlockEntity
{
    public QuantascopeEntity(BlockPos pPos, BlockState pBlockState)
    {
        super(BlockEntityInit.QUANTASCOPE.get(), pPos, pBlockState);
    }
}
