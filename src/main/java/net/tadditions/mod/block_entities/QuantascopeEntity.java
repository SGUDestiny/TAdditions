package net.tadditions.mod.block_entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.init.BlockEntityInit;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class QuantascopeEntity extends BlockEntity
{
    protected final ItemStackHandler itemHandler = createHandler();
    protected final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);


    public QuantascopeEntity(BlockPos pPos, BlockState pBlockState)
    {
        super(BlockEntityInit.QUANTASCOPE.get(), pPos, pBlockState);
    }

    @Override
    public void invalidateCaps()
    {
        super.invalidateCaps();
        handler.invalidate();
    }

    @Override
    public void load(CompoundTag nbt)
    {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("Inventory"));

    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt)
    {
        nbt.put("Inventory", itemHandler.serializeNBT());

        super.saveAdditional(nbt);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, Direction side)
    {

        if(capability == ForgeCapabilities.ITEM_HANDLER)
            return handler.cast();

        return super.getCapability(capability, side);
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(13)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                setChanged();
            }

            @Override
            public int getSlotLimit(int slot)
            {
                return 64;
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {
                return true;
            }

            @Override
            @NotNull
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {
                if(!isItemValid(slot, stack))
                    return stack;

                return super.insertItem(slot, stack, simulate);

            }
        };
    }
}
