package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ContainmentChamberPartBlock extends Block
{
    public static final BooleanProperty BROKEN = BooleanProperty.create("broken");
    public static final EnumProperty<ContainmentChamberBlock.ChamberPart> PART = EnumProperty.create("chamber_part", ContainmentChamberBlock.ChamberPart.class);

    public ContainmentChamberPartBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(BROKEN, false).with(PART, ContainmentChamberBlock.ChamberPart.MIDDLE));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        player.addStat(Stats.BLOCK_MINED.get(this));
        player.addExhaustion(0.005F);
        if(EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) > 0)
            ContainmentChamberBlock.spawnItem(worldIn, pos, state.get(BROKEN));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BROKEN);
        builder.add(PART);
    }
}
