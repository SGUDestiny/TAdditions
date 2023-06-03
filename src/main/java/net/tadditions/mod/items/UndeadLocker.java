package net.tadditions.mod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.helper.PlayerHelper;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.misc.ConsoleBoundWithTooltipItem;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.upgrades.KeyFobUpgrade;

import javax.annotation.Nullable;
import java.util.List;

public class UndeadLocker extends Item {


    public UndeadLocker() {
        super(new Properties().maxStackSize(1).group(TItemGroups.MAIN));
    }



    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        TileEntity ex = world.getTileEntity(blockpos);
        if (ex instanceof ExteriorTile) {
            ((ExteriorTile) ex).setLocked(false);
            ((ExteriorTile) ex).setAdditionalLockLevel(0);
            ((ExteriorTile) ex).setDoorState(EnumDoorState.CLOSED);
            ((ExteriorTile) ex).copyDoorStateToInteriorDoor();
            return ActionResultType.SUCCESS;
        }
        else return ActionResultType.FAIL;
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

            tooltip.add(new TranslationTextComponent("tooltip.tadditions.undeadlocker"));

            super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
