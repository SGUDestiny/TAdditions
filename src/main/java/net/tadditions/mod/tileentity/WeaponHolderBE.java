package net.tadditions.mod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class WeaponHolderBE extends TileEntity {
    private ItemStack weapons = ItemStack.EMPTY;

    public WeaponHolderBE() {
        super(ModTileEntitys.WPH.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        if(compound.contains("weapons")){
            this.weapons = ItemStack.read(compound.getCompound("weapons"));
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("weapon", this.weapons.serializeNBT());
        return super.write(compound);
    }

    public void setWeapon(ItemStack weapon) {
        this.weapons = weapon;
    }

    public ItemStack getWeapon() {
        return this.weapons;
    }

    public void update() {
        if(!world.isRemote)
            world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);
    }
}
