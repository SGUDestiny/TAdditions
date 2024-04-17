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
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.helper.WorldHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DataCrystalItem extends Item {

    private RegistryKey<World> dimdata = World.OVERWORLD;
    private boolean used = false;
    private int type = 1;
    private BlockPos coord = BlockPos.ZERO;

    public DataCrystalItem(Properties builderIn) {
        super(builderIn);
    }

    @Nullable
    @Override
    public CompoundNBT getShareTag(ItemStack stack) {
        CompoundNBT tag = stack.getOrCreateTag();
        tag.put("crystal_data", this.serializeNBT());
        return tag;
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack) {
        if (this.getUsed(stack)) {
            return new TranslationTextComponent("item.tadditions.data_crystal.used");
        } else if (this.getType(stack) == 0) {
            return new TranslationTextComponent("item.tadditions.data_crystal_dimension");
        } else if (this.getType(stack) == 1) {
            return new TranslationTextComponent("item.tadditions.data_crystal_coord");
        }

        return new TranslationTextComponent("item.tadditions.data_crystal");
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
    public int getItemStackLimit(ItemStack stack) {
        if (this.getUsed(stack)) {
            return 64;
        } else if (this.getType(stack) == 0) {
            return 1;
        } else if (this.getType(stack) == 1) {
            return 16;
        }
        else return 1;
    }



    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group.equals(ModItemGroups.TA)) {
            ItemStack dis = new ItemStack(this);
            this.setUsed(dis, true);
            items.add(dis);
            ItemStack dis1 = new ItemStack(this);
            this.setUsed(dis1,false);
            this.setType(dis1, 0);
            this.setDimData(dis1, MDimensions.THE_VERGE);
            items.add(dis1);
            ItemStack dis2 = new ItemStack(this);
            this.setUsed(dis2, false);
            this.setType(dis2,1);
            this.setCoords(dis2, BlockPos.ZERO);
            this.setDimData(dis2, World.OVERWORLD);
            items.add(dis2);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (this.getUsed(stack)) {
            tooltip.add(new TranslationTextComponent("tadditions.data_crystal_used"));
        } else if (this.getType(stack) == 0 && !this.getUsed(stack)) {
            tooltip.add(new TranslationTextComponent("tadditions.dimension_data_crystal_description"));
            tooltip.add(TardisConstants.Translations.TOOLTIP_HOLD_SHIFT);
            if (Screen.hasShiftDown()) {
                tooltip.clear();
                tooltip.add(0, this.getDisplayName(stack));
                tooltip.add(new TranslationTextComponent("tadditions.dimension_data_crystal_description"));
                tooltip.add(new TranslationTextComponent("tadditions.dimension_text").appendSibling(new StringTextComponent(WorldHelper.formatDimName(this.getDimData(stack))).mergeStyle(TextFormatting.DARK_PURPLE)));
                tooltip.add(new TranslationTextComponent("tadditions.data_crystal_will_burn"));
            }
        } else if (this.getType(stack) == 1 && !this.getUsed(stack)) {
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
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        if (this.getType(context.getItem()) == 1 && !this.getUsed(context.getItem())) {
            this.coord = context.getPos();
            this.dimdata = context.getWorld().getDimensionKey();
            this.getShareTag(context.getItem());
        }
        return super.onItemUse(context);
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("dimdata", this.dimdata.getLocation().toString());
        tag.putBoolean("used", this.used);
        tag.putInt("type", this.type);
        tag.put("coord", NBTUtil.writeBlockPos(coord));
        return tag;
    }

    public void deserializeNBT(CompoundNBT nbt) {
        this.dimdata = WorldHelper.getWorldKeyFromRL(ResourceLocation.tryCreate(nbt.getString("dimdata")));
        this.used = nbt.getBoolean("used");
        this.type = nbt.getInt("type");
        this.coord = NBTUtil.readBlockPos(nbt.getCompound("coord"));
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

    public int getType(ItemStack stack) {
        return stack.getOrCreateChildTag("crystal_data").getInt("type");
    }

    public void setType(ItemStack stack, int type) {
        stack.getOrCreateChildTag("crystal_data").putInt("type", type);
    }

    public void setDimData(ItemStack stack, RegistryKey<World> type) {
        stack.getOrCreateChildTag("crystal_data").putString("dimdata", type.getLocation().toString());
    }

    public boolean getUsed(ItemStack stack) {
        return stack.getOrCreateChildTag("crystal_data").getBoolean("used");
    }

    public void setUsed(ItemStack stack, boolean used) {
        stack.getOrCreateChildTag("crystal_data").putBoolean("used", used);
    }
}
