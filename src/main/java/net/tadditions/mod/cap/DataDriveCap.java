package net.tadditions.mod.cap;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class DataDriveCap implements IOpener {

    private ItemStackHandler handler;

    public DataDriveCap() {
        handler = new ItemStackHandler();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.put("crystal", this.handler.serializeNBT());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.handler.deserializeNBT(nbt.getCompound("crystal"));
    }

    @Override
    public void tick(World worldIn, Entity entityIn) {
        if (!worldIn.isRemote) {
            if (worldIn.getGameTime() % 20 == 0) {
                this.handler = getHandler();
                this.serializeNBT();
            }
        }
    }

    public ItemStackHandler getHandler() {
        return handler;
    }
}
