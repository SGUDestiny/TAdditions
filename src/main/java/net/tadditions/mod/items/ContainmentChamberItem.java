package net.tadditions.mod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.fixes.ShulkerBoxItemColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tadditions.mod.blocks.ContainmentChamberBlock;
import net.tadditions.mod.blocks.ModBlocks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class ContainmentChamberItem extends BlockItem implements IAnimatable {
    public AnimationFactory factory = new AnimationFactory(this);
    private <T extends IAnimatable> PlayState predicate(AnimationEvent<T> event) {
        event.getController().setAnimation((new AnimationBuilder()).addAnimation("loop", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    public ContainmentChamberItem(Block block, Properties properties){
        super(block, properties);
    }

    public void setBroken(ItemStack item, boolean value)
    {
        item.getOrCreateChildTag("BlockStateTag").putBoolean("broken", value);
    }

    public boolean getBroken(ItemStack item){
        return item.getOrCreateChildTag("BlockStateTag").getBoolean("broken");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group.equals(ModItemGroups.TA))
        {
            ItemStack stack0 = new ItemStack(ModBlocks.containment_chamber.get());
            this.setBroken(stack0, false);
            items.add(stack0);

            ItemStack stack1 = new ItemStack(ModBlocks.containment_chamber.get());
            this.setBroken(stack1, true);
            items.add(stack1);
        }
    }

    @Override
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        if(context.getItem().getItem() instanceof ContainmentChamberItem)
        {
            ContainmentChamberItem item = (ContainmentChamberItem) context.getItem().getItem();
            for(ContainmentChamberBlock.ChamberPart part : ContainmentChamberBlock.ChamberPart.values())
            {
                if(part.equals(ContainmentChamberBlock.ChamberPart.BASE))
                    context.getWorld().setBlockState(context.getPos(), state.with(ContainmentChamberBlock.BROKEN, item.getBroken(context.getItem())), 11);
                else context.getWorld().setBlockState(ContainmentChamberBlock.ChamberPart.getPartPos(context.getPos(), state.get(ContainmentChamberBlock.PART), part), ModBlocks.containment_chamber_part.get().getDefaultState().with(ContainmentChamberBlock.PART, part).with(ContainmentChamberBlock.BROKEN, item.getBroken(context.getItem())));
            }
            return true;
        }
        else return super.placeBlock(context, state);
    }



    @Override
    protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        return super.onBlockPlaced(pos, worldIn, player, stack, state.with(ContainmentChamberBlock.BROKEN, this.getBroken(stack)));
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
