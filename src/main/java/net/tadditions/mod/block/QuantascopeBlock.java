package net.tadditions.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class QuantascopeBlock extends HorizontalDirectionalBlock
{
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public QuantascopeBlock(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random)
    {
        if(state.getValue(ACTIVE))
        {
            level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5, pos.getY() + 0.35, pos.getZ() + 0.5, 0d, 0.01d, 0d);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(ACTIVE, false);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(FACING).add(ACTIVE);
    }
}
