package net.tadditions.mod.items;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.blocks.SolenoidConBlock;
import net.tadditions.mod.cap.IQuant;
import net.tadditions.mod.cap.MCapabilities;

import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.List;

public class QuantumExoticMatterItem extends Item {
    public static final DecimalFormat FORMAT = new DecimalFormat("###");

    public QuantumExoticMatterItem(Properties properties) {
        super(properties);
    }

    public static void syncCapability(ItemStack stack) {
        if (stack.getShareTag() != null) {
            stack.getOrCreateTag().merge(stack.getShareTag());
        }
    }

    public static void readCapability(ItemStack stack) {
        if (stack.getShareTag() != null) {
            stack.readShareTag(stack.getOrCreateTag());
        }

    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        Block block = world.getBlockState(blockpos).getBlock();
        if(block instanceof SolenoidConBlock && block.matchesBlock(ModBlocks.electromagnetic_solenoid_container.get())){
            world.setBlockState(blockpos,ModBlocks.filled_electromagnetic_solenoid_container.get().getDefaultState());
            return ActionResultType.SUCCESS;
        }
        else return ActionResultType.FAIL;
    }

    @Override
    public boolean onEntityItemUpdate(final ItemStack stack, final ItemEntity entity){
        World worldIn = entity.getEntityWorld();
        this.tickFuse(stack, worldIn, entity);
        return super.onEntityItemUpdate(stack, entity);
    }

    public void tickFuse(ItemStack stack, World worldIn, Entity entityIn){
        if (!worldIn.isRemote) {
            stack.getCapability(MCapabilities.QUANT_CAPABILITY).ifPresent(cap -> {
                cap.tick(worldIn, entityIn);
            });
            if (worldIn.getGameTime() % 20 == 0) {
                syncCapability(stack); //sync capabilities each second instead of every tick
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            this.tickFuse(stack, worldIn, entityIn);
        }
    }

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) { //sync capability to client
        CompoundNBT tag = stack.getOrCreateTag();
        stack.getCapability(MCapabilities.QUANT_CAPABILITY).ifPresent(cap ->
        {
            tag.put("cap_sync", cap.serializeNBT());
        });
        return tag;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        stack.getCapability(MCapabilities.QUANT_CAPABILITY).ifPresent(cap -> {
        tooltip.add(new TranslationTextComponent("tooltip.quan.timer").appendSibling(new StringTextComponent(FORMAT.format(cap.getTimer())).mergeStyle(TextFormatting.LIGHT_PURPLE)));
        });
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            if (nbt.contains("cap_sync")) {
                stack.getCapability(MCapabilities.QUANT_CAPABILITY).ifPresent(handler -> handler.deserializeNBT(nbt.getCompound("cap_sync")));
            }
        }
    }
    public double getDurabilityForDisplay(final ItemStack stack) {
        return Math.abs(1.0 - this.getFuse(stack) / (double)100);
    }

    public boolean showDurabilityBar(final ItemStack stack) {
        return this.getFuse(stack) > 0 && this.getFuse(stack) < 100;
    }

    public int getFuse(final ItemStack stack) {
      return stack.getOrCreateTag().getInt("time");
    }
}
