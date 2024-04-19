package net.tadditions.mod.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;

import javax.annotation.Nullable;
import java.util.List;

public class CoordinateDataCrystalItem extends Item {
    private RegistryKey<World> dimdata;
    private BlockPos coord;

    public CoordinateDataCrystalItem(Properties properties) {
        super(properties);
        this.dimdata = World.OVERWORLD;
        this.coord = BlockPos.ZERO;
    }

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        tag.put("crystal_data", this.serializeNBT());
        return tag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundNBT nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            if (nbt.contains("crystal_data")) {
                this.deserializeNBT(nbt);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tadditions.coordinate_data_crystal_description"));
        tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
        if (Screen.hasShiftDown()) {
            tooltip.clear();
            tooltip.add(0, this.getDisplayName(stack));
            tooltip.add(new TranslationTextComponent("tadditions.coordinate_data_crystal_description"));
            tooltip.add(new TranslationTextComponent("tadditions.coordinate_text").appendSibling(new StringTextComponent(this.getCoords(stack).getCoordinatesAsString()).mergeStyle(TextFormatting.DARK_AQUA)));
            tooltip.add(new TranslationTextComponent("tadditions.dimension_text").appendSibling(new StringTextComponent(WorldHelper.formatDimName(this.getDimData(stack))).mergeStyle(TextFormatting.DARK_AQUA)));
            tooltip.add(new TranslationTextComponent("tadditions.data_crystal_will_burn"));
        }
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group.equals(ModItemGroups.TA)){
            ItemStack stack = new ItemStack(this);
            this.setDimData(stack, World.OVERWORLD);
            this.setCoords(stack, BlockPos.ZERO);
            items.add(stack);
        }
    }

    @Override
    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        if (!worldIn.isRemote()){
            ItemStack newCrystal = new ItemStack(this);
            this.setDimData(newCrystal, worldIn.getDimensionKey());
            this.setCoords(newCrystal, livingEntityIn.getPosition());
            livingEntityIn.setHeldItem(livingEntityIn.getActiveHand(), newCrystal);
        }
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata.getLocation().toString());
        tag.put("coords", NBTUtil.writeBlockPos(coord));
        return tag;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (worldIn.getGameTime() % 20 == 0) {
            if (stack.getShareTag() != null) {
                stack.getOrCreateTag().merge(stack.getShareTag());
                this.coord = getCoords(stack);
                this.dimdata = getDimData(stack);
                this.serializeNBT();
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(nbt.getString("dimdata")));
        this.coord = NBTUtil.readBlockPos(nbt.getCompound("coords"));
    }

    public void setDimData(ItemStack stack, RegistryKey<World> type) {
        stack.getOrCreateChildTag("crystal_data").putString("dimdata", type.getLocation().toString());
    }

    public RegistryKey<World> getDimData(ItemStack stack) {
        return WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(stack.getOrCreateChildTag("crystal_data").getString("dimdata")));
    }

    public void setCoords(ItemStack stack, BlockPos pos) {
        stack.getOrCreateChildTag("crystal_data").put("coords", NBTUtil.writeBlockPos(pos));
    }

    public BlockPos getCoords(ItemStack stack) {
        return NBTUtil.readBlockPos(stack.getOrCreateChildTag("crystal_data").getCompound("coords"));
    }
}
