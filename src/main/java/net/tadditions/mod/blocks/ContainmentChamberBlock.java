package net.tadditions.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tadditions.mod.items.ContainmentChamberItem;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.tileentity.ContainmentChamberTile;
import net.tardis.mod.blocks.TileBlock;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ContainmentChamberBlock extends TileBlock {

    public static final BooleanProperty BROKEN = BooleanProperty.create("broken");
    public static final EnumProperty<ChamberPart> PART = EnumProperty.create("chamber_part", ChamberPart.class);

    public ContainmentChamberBlock(Properties prop) {
        super(prop);
        this.setDefaultState(this.getDefaultState().with(BROKEN, false).with(PART, ChamberPart.BASE));
    }

    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ContainmentChamberTile();
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        player.addStat(Stats.BLOCK_MINED.get(this));
        player.addExhaustion(0.005F);
    }

    public static void spawnItem(World worldIn, BlockPos pos, boolean broken)
    {
        ItemStack chamberItem = new ItemStack(ModBlocks.containment_chamber.get());
        if(chamberItem.getItem() instanceof ContainmentChamberItem)
        {
            ContainmentChamberItem item = (ContainmentChamberItem) chamberItem.getItem();
            item.setBroken(chamberItem, broken);
        }
        InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), chamberItem);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(BROKEN, false).with(PART, ChamberPart.BASE);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BROKEN);
        builder.add(PART);
    }

    public enum ChamberPart implements IStringSerializable {
        BASE("base", 0),
        MIDDLE("middle", 1),
        TOP("top", 2);

        public final String name;
        public final int height;
        ChamberPart(String name, int height)
        {
            this.name = name;
            this.height = height;
        }

        @Override
        public String getString() {
            return name;
        }

        public static BlockPos getPartPos(BlockPos pos, ChamberPart thisPart, ChamberPart targetPart)
        {
            if(thisPart.equals(ChamberPart.BASE))
            {
                return pos.up(targetPart.height);
            }

            if(thisPart.equals(ChamberPart.MIDDLE))
            {
                if(targetPart.equals(ChamberPart.BASE))
                    return pos.down(thisPart.height);
                else if(targetPart.equals(ChamberPart.TOP))
                    return pos.up(thisPart.height);
                else return pos;
            }

            if(thisPart.equals(ChamberPart.TOP))
            {
                if(targetPart.equals(ChamberPart.BASE))
                    return pos.down(thisPart.height);
                else if(targetPart.equals(ChamberPart.MIDDLE))
                    return pos.down(targetPart.height);
                else return pos;
            }
            else return pos;
        }
    }

}
