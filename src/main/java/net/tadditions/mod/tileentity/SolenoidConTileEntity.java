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

public class SolenoidConTileEntity extends TileEntity {

    public boolean Contents = false;

    public SolenoidConTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }


    public boolean getItem() {
        return this.Contents;
    }


    public void setItem(boolean itemsIn) {
        this.Contents = itemsIn;
    }



    public SolenoidConTileEntity() {
        this(ModTileEntitys.SOLENOID.get());
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putBoolean("contents", this.Contents);


        return compound;
    }

    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.Contents = nbt.getBoolean("contents");
    }
}
