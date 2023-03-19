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
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkHooks;
import net.tadditions.mod.cap.MCapabilities;
import net.tadditions.mod.items.ModItems;
import net.tadditions.mod.network.MNetwork;
import net.tadditions.mod.network.packets.QuanSpawnMessage;
import net.tardis.mod.misc.TardisLike;

public class SolenoidConTileEntity extends TileEntity {

    private ItemStack item = ItemStack.EMPTY;

    public SolenoidConTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    protected void setItem(ItemStack itemsIn) {
        this.item = itemsIn;
    }

    public boolean onPlayerRightClick(ItemStack stack) {

        if(stack.getItem() == ModItems.QUANTUM_EXOTIC_MATTER.get() && item.isEmpty()) {
            this.setItem(stack);
            item.getCapability(MCapabilities.QUANT_CAPABILITY).ifPresent(quan -> {
                quan.setPaused(true);
            });
            return true;
        }
        if(stack == ItemStack.EMPTY && item.getItem() == ModItems.QUANTUM_EXOTIC_MATTER.get()){
            item.getCapability(MCapabilities.QUANT_CAPABILITY).ifPresent(quan -> {
                quan.setPaused(false);
            });
            this.setItem(ItemStack.EMPTY);
            MNetwork.sendToServer(new QuanSpawnMessage(ModItems.QUANTUM_EXOTIC_MATTER.get()));
            return true;
        }
        return false;
    }

    public SolenoidConTileEntity() {
        this(ModTileEntitys.SOLENOID.get());
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.put("item", this.item.serializeNBT());

        return compound;
    }



    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.item = ItemStack.read(nbt.getCompound("item"));
    }
}
