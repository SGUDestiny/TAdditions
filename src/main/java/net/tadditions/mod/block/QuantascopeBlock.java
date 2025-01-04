package net.tadditions.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.tadditions.mod.block_entities.QuantascopeEntity;
import net.tadditions.mod.menu.PhasingQuantascopeMenu;

public class QuantascopeBlock extends HorizontalDirectionalBlock
{
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public QuantascopeBlock(Properties pProperties)
    {
        super(pProperties);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace)
    {
        if(!level.isClientSide())
        {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if(blockEntity instanceof QuantascopeEntity quantascope)
            {
                MenuProvider containerProvider = new MenuProvider()
                {
                    @Override
                    public Component getDisplayName()
                    {
                        return Component.translatable("screen.tadditions.quantascope");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity)
                    {
                        return new PhasingQuantascopeMenu(windowId, playerInventory, blockEntity);
                    }
                };
                NetworkHooks.openScreen((ServerPlayer) player, containerProvider, blockEntity.getBlockPos());
            }
            else
            {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random)
    {
        if(state.getValue(ACTIVE))
        {
            level.addParticle(ParticleTypes.FLAME, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, 0, 0.01, 0);

            double velocityX = (random.nextDouble() - 0.5) * 2;
            double velocityY = (random.nextDouble() - 0.5) * 2;
            double velocityZ = (random.nextDouble() - 0.5) * 2;

            level.addParticle(ParticleTypes.ELECTRIC_SPARK, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, velocityX, velocityY, velocityZ);

            level.addParticle(ParticleTypes.SMOKE, pos.getCenter().x, pos.getCenter().y, pos.getCenter().z, 0, 0.03, 0);
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
