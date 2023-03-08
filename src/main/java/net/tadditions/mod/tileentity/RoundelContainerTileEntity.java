package net.tadditions.mod.tileentity;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.BarrelTileEntity;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.common.Mod;

public class RoundelContainerTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> barrelContents = NonNullList.withSize(27, ItemStack.EMPTY);
    private int numPlayersUsing;

    public RoundelContainerTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public RoundelContainerTileEntity() {
        this(ModTileEntitys.ROUNDELCON.get());
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.barrelContents);
        }

        return compound;
    }

    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.barrelContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.barrelContents);
        }

    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.barrelContents;
    }

    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.barrelContents = itemsIn;
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return ChestContainer.createGeneric9X3(id, player, this);
    }

    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;

            this.scheduleTick();
        }

    }

    private void scheduleTick() {
        this.world.getPendingBlockTicks().scheduleTick(this.getPos(), this.getBlockState().getBlock(), 5);
    }

    public void barrelTick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        this.numPlayersUsing = ChestTileEntity.calculatePlayersUsing(this.world, this, i, j, k);
        if (this.numPlayersUsing > 0) {
            this.scheduleTick();
        }
    }

    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
        }

    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.roundelcon");
    }

}
