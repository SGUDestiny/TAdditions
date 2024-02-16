package net.tadditions.mod.cap;

import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.world.MDimensions;
import net.tardis.mod.helper.WorldHelper;

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
        this.handler.deserializeNBT(nbt);
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
