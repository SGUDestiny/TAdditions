package net.tadditions.mod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SolenoidConTileEntity extends LockableLootTileEntity {

    public NonNullList<ItemStack> Contents = NonNullList.withSize(2, ItemStack.EMPTY);

    public SolenoidConTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.Contents;
    }

    public ItemStack getItem() {
        return this.Contents.get(1);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.Contents = itemsIn;
    }

    public void setItem(ItemStack itemsIn) {
        this.Contents.set(1, itemsIn);
    }

    public SolenoidConTileEntity() {
        this(ModTileEntitys.SOLENOID.get());
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.Contents);
        }


        return compound;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return null;
    }

    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.Contents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.Contents);
        }

    }

    @Override
    public int getSizeInventory() {
        return 1;
    }
}
