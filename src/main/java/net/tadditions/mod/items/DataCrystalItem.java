package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DataCrystalItem extends Item {

    public DataCrystalItem(Properties builderIn) {
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

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) { //sync capability to client
        CompoundNBT tag = stack.getOrCreateTag();
        stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap ->
        {
            tag.put("crystal", cap.serializeNBT());
        });
        return tag;
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        AtomicReference<String> translation = new AtomicReference<>("item.tadditions.data_crystal");

        stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
            if(cap.getUsed()){
                translation.set("item.tadditions.data_crystal.used");
            } else if(cap.getType() == 0){
                translation.set("item.tadditions.data_crystal_dimension");
            } else if(cap.getType() == 1){
                translation.set("item.tadditions.data_crystal_coord");
            }
        });

        return new TranslationTextComponent(translation.get());
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            if (nbt.contains("crystal")) {
                stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(handler -> handler.deserializeNBT(nbt.getCompound("data")));
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            if (entityIn instanceof PlayerEntity) {
                stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
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
    public int getItemStackLimit(ItemStack stack) {
        AtomicInteger integer = new AtomicInteger(1);
        stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
            if(cap.getUsed()){
                integer.set(64);
            } else if(cap.getType() == 0){
                integer.set(1);
            } else if(cap.getType() == 1){
                integer.set(16);
            }
        });
        return integer.get();
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
            cap.setType(1);
            cap.setUsed(false);
        });
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group.equals(ModItemGroups.TA)) {
            ItemStack dis = new ItemStack(this);
            dis.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
                cap.setUsed(true);
            });
            items.add(dis);
            ItemStack dis1 = new ItemStack(this);
            dis1.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
                cap.setUsed(false);
                cap.setType(0);
                cap.setDimData(MDimensions.THE_VERGE);
            });
            items.add(dis1);
            ItemStack dis2 = new ItemStack(this);
            dis2.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
                cap.setUsed(false);
                cap.setType(1);
            });
            items.add(dis2);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        stack.getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
            if(cap.getUsed()){
                tooltip.add(new TranslationTextComponent("tadditions.data_crystal_used"));
            } else if (cap.getType() == 0 && !cap.getUsed()) {
                tooltip.add(new TranslationTextComponent("tadditions.dimension_data_crystal_description"));
                tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
                if (Screen.hasShiftDown()) {
                    tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tadditions.dimension_data_crystal_description"));
                    tooltip.add(new TranslationTextComponent("tadditions.dimension_text").appendSibling(new StringTextComponent(WorldHelper.formatDimName(cap.getDimData())).mergeStyle(TextFormatting.DARK_PURPLE)));
                    tooltip.add(new TranslationTextComponent("tadditions.data_crystal_will_burn"));
                }
            } else if (cap.getType() == 1 && !cap.getUsed()){
                tooltip.add(new TranslationTextComponent("tadditions.coordinate_data_crystal_description"));
                tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
                if(Screen.hasShiftDown()){
                    tooltip.clear();
                    tooltip.add(0, this.getDisplayName(stack));
                    tooltip.add(new TranslationTextComponent("tadditions.coordinate_data_crystal_description"));
                    tooltip.add(new TranslationTextComponent("tadditions.coordinate_text").appendSibling(new StringTextComponent(cap.getCoords().getCoordinatesAsString()).mergeStyle(TextFormatting.DARK_AQUA)));
                    tooltip.add(new TranslationTextComponent("tadditions.dimension_text").appendSibling(new StringTextComponent(WorldHelper.formatDimName(cap.getDimData())).mergeStyle(TextFormatting.DARK_AQUA)));
                    tooltip.add(new TranslationTextComponent("tadditions.data_crystal_will_burn"));
                }
            }
        });
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        context.getItem().getCapability(MCapabilities.CRYSTAL_CAPABILITY).ifPresent(cap -> {
            if(cap.getType() == 1 && !cap.getUsed())
            cap.setDimData(context.getWorld().getDimensionKey());
            cap.setCoords(context.getPos());
        });

        return super.onItemUse(context);
    }
}
