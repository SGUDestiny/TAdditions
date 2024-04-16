package net.tadditions.mod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.tadditions.mod.container.AdvQuantiscopeWeldContainer;
import net.tadditions.mod.recipe.AdvWeldRecipe;
import net.tadditions.mod.recipe.AdvWeldRecipeWrapper;
import net.tadditions.mod.recipe.TARecipeSerialisers;
import net.tardis.mod.sounds.TSounds;

import javax.annotation.Nullable;

public class AdvQuantiscopeTile extends TileEntity implements IItemHandlerModifiable, ITickableTileEntity{

	private ItemStackHandler handler = new ItemStackHandler(13);
	private LazyOptional<ItemStackHandler> buffer = LazyOptional.of(() -> this.handler);
	private EnumMode mode = EnumMode.WELD;
	private AdvWeldRecipe weldRecipe;
	private int progress = 0;
	private int maxProgress = 400;

	public AdvQuantiscopeTile() {
		super(ModTileEntitys.ADVQ.get());
	}
	
	@Override
	public void tick() {
		if(mode == EnumMode.WELD) {
			if(this.weldRecipe == null) {
				this.weldRecipe = this.getRecipe();
			}
			if(weldRecipe != null && this.shouldWeld()) {
				this.maxProgress = weldRecipe.getProcessingTicks();
				this.insertItem(12, this.weldRecipe.getRecipeOutput(), true);
				//If first progress tick, update client
				if(this.progress == 0)
					if(!world.isRemote)
						this.world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 2);
				
				++progress;
				if(progress >= this.maxProgress) {
					finish();
				}
				
				if (world.getGameTime() % 20 == 0) {
					if(world.isRemote)
						world.addParticle(ParticleTypes.LAVA, this.getPos().getX() + 0.5, this.getPos().getY() + 0.4, this.getPos().getZ() + 0.5, 0, 0, 0);
					if (!world.isRemote) {
						world.playSound(null, this.getPos(), TSounds.ELECTRIC_SPARK.get(), SoundCategory.BLOCKS, 0.5F, 1.5F);
					}
				}
				if(world.isRemote)
					world.addParticle(ParticleTypes.SMOKE, this.getPos().getX() + 0.5, this.getPos().getY() + 0.4, this.getPos().getZ() + 0.5, 0, 0, 0);
				
			}
			else {
				this.weldRecipe = null;
				this.progress = 0;
				if(!world.isRemote)
					this.world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 2);
			}
				
		}
	}
	
	private boolean shouldWeld() {
		if(this.weldRecipe != null) {
			return this.doesMatrixMatchRecipe(this.weldRecipe) && this.insertItem(12, this.weldRecipe.getRecipeOutput(), true) == ItemStack.EMPTY;
		}
		return false;
	}
	
	private void finish() {
		this.insertItem(12, this.weldRecipe.getRecipeOutput(), false);
		this.markDirty();

		
		for(int i = 0; i < 12; ++i)
			this.getStackInSlot(i).shrink(1);
		this.progress = 0;
		this.weldRecipe = null;
		if(!world.isRemote)
			this.world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 2);
	}
	
	private boolean doesMatrixMatchRecipe(AdvWeldRecipe recipe) {
		AdvWeldRecipeWrapper wrapper = new AdvWeldRecipeWrapper(this);
		return recipe.matches(wrapper, world);
	}
	
	@Nullable
	private AdvWeldRecipe getRecipe() {
		for(AdvWeldRecipe rec : AdvWeldRecipe.getAllRecipes(world)) {
			if(this.doesMatrixMatchRecipe(rec))
				return rec;
		}
		return null;
	}
	
	public float getProgress() {
		return this.progress / (float)maxProgress;
	}
	
	public int getCurrentProgress() {
		return this.progress;
	}
	
	public int getMaxProgressTicks() {
		return this.maxProgress;
	}
	
	public EnumMode getMode() {
		return this.mode;
	}
	
	public void setMode(EnumMode mode) {
		this.mode = mode;
		this.markDirty();
		if(!world.isRemote)
			world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 2);
	}
	
	public AdvWeldRecipe getCurrentRecipe() {
		return this.weldRecipe;
	}
	
	public void setCurrentRecipe(AdvWeldRecipe recipe) {
		if (this.mode == EnumMode.WELD) {
	        if (recipe != null) {
	        	this.weldRecipe = recipe;
	        }
	    }
	}

	@Override
	public void read(BlockState state, CompoundNBT compound) {
		super.read(state, compound);
		this.mode = EnumMode.values()[compound.getInt("mode")];
		this.handler.deserializeNBT(compound.getCompound("item_handler"));
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("mode", this.mode.ordinal());
		compound.put("item_handler", this.handler.serializeNBT());
		return super.write(compound);
	}
	
	public Container createContainer(int id, PlayerInventory inv) {
		return mode.fact.create(id, inv, this);
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.getPos(), -1, this.serializeNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.deserializeNBT(pkt.getNbtCompound());
	}

	public static enum EnumMode{
		WELD(AdvQuantiscopeWeldContainer::new);
		
		IQuantiscopeFactory<Container> fact;
		int workTime = 400;
		
		EnumMode(IQuantiscopeFactory<Container> fact){
			this.fact = fact;
		}
		
		EnumMode(IQuantiscopeFactory<Container> fact, int workTime){
			this.fact = fact;
			this.workTime = workTime;
		}
	}
	
	public static interface IQuantiscopeFactory<T extends Container>{
		T create(int id, PlayerInventory inv, AdvQuantiscopeTile tile);
	}

	@Override
	public int getSlots() {
		return this.handler.getSlots();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.handler.getStackInSlot(slot);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		this.markDirty();
		return this.handler.insertItem(slot, stack, simulate);
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		this.markDirty();
		return this.handler.extractItem(slot, amount, simulate);
	}

	@Override
	public int getSlotLimit(int slot) {
		return this.handler.getSlotLimit(slot);
	}

	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		return true;
	}

	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		this.handler.setStackInSlot(slot, stack);
		this.markDirty();
	}
	

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? buffer.cast() : super.getCapability(cap, side);
	}

}
