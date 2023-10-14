package net.tadditions.mod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.blocks.multiblock.MultiblockPatterns.MultiblockPattern;
import net.tardis.mod.tileentities.IMultiblock;
import net.tardis.mod.tileentities.MultiblockMasterTile;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AnimatedMultiblockBlockItem extends BlockItem implements IAnimatable {
    public AnimationFactory factory = new AnimationFactory(this);

    private <T extends IAnimatable> PlayState predicate(AnimationEvent<T> event) {
        event.getController().setAnimation((new AnimationBuilder()).addAnimation("loop", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    private final MultiblockPattern pattern;

    public AnimatedMultiblockBlockItem(Block blockIn, MultiblockPattern pattern, Properties builder) {
        super(blockIn, builder);
        this.pattern = pattern;
    }

    @Override
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        boolean canBePlaced = super.placeBlock(context, state);
        MultiblockMasterTile master = ((MultiblockMasterTile) context.getWorld().getTileEntity(context.getPos()));
        if (canBePlaced) {
            for (BlockPos pos : this.pattern.getPositions()) {
                pos = pos.add(context.getPos());
                if (pos.equals(context.getPos()))
                    continue;
                FluidState fluid = context.getWorld().getFluidState(pos);
                context.getWorld().setBlockState(pos, TBlocks.multiblock.get().getDefaultState().with(BlockStateProperties.WATERLOGGED, fluid.getFluidState().isTagged(FluidTags.WATER)));
                TileEntity te = context.getWorld().getTileEntity(pos);
                if (te instanceof IMultiblock) {
                    ((IMultiblock) te).setMasterPos(context.getPos());
                    master.addSlavePos(pos);
                }
            }
        }
        return canBePlaced;
    }

    @Override
    protected boolean canPlace(BlockItemUseContext context, BlockState state) {
        for (BlockPos raw : this.pattern.getPositions()) {
            if (!context.getWorld().getBlockState(raw.add(context.getPos())).getMaterial().isReplaceable()) {
                context.getPlayer().sendStatusMessage(new TranslationTextComponent("message.tardis.multiblock.invalid_place"), true);
                return false;
            }
        }
        return super.canPlace(context, state);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
