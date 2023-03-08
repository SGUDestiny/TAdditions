package net.tadditions.mod.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.cap.MCapabilities;

import javax.annotation.Nullable;
import java.util.List;

public class VergeOpener extends Item {

    public VergeOpener(Properties builderIn) {
        super(builderIn);
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

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        this.asItem().getDefaultInstance().getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
            cap.setDimdata(true);
        });
    }

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) { //sync capability to client
        CompoundNBT tag = stack.getOrCreateTag();
        stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap ->
        {
            tag.put("data", cap.serializeNBT());
        });
        return tag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            if (nbt.contains("data")) {
                stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(handler -> handler.deserializeNBT(nbt.getCompound("data")));
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            if (entityIn instanceof PlayerEntity) {
                stack.getCapability(MCapabilities.OPENER_CAPABILITY).ifPresent(cap -> {
                    cap.tick(worldIn, entityIn);
                });
            }
            if (worldIn.getGameTime() % 20 == 0) {
                syncCapability(stack); //sync capabilities each second instead of every tick
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        tooltip.add(new TranslationTextComponent("tooltip.tadditions.opener"));

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }



}
