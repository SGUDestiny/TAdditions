package net.tadditions.mod.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.tadditions.mod.block_entities.QuantascopeEntity;
import net.tadditions.mod.init.BlockInit;
import net.tadditions.mod.init.MenuInit;

public class PhasingQuantascopeMenu extends AbstractContainerMenu
{
    protected final QuantascopeEntity quantascope;
    protected final Level level;

    public PhasingQuantascopeMenu(int containerId, Inventory inventory, FriendlyByteBuf buffer)
    {
        this(containerId, inventory, inventory.player.level.getBlockEntity(buffer.readBlockPos()));
    }

    public PhasingQuantascopeMenu(int containerId, Inventory inventory, BlockEntity blockEntity)
    {
        super(MenuInit.PHASING_QUANTASCOPE.get(), containerId);
        this.level = inventory.player.level;
        this.quantascope = (QuantascopeEntity) blockEntity;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.quantascope.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(
        handler ->
        {
            this.addSlot(new SlotItemHandler(handler, 0, 9, 29));
            this.addSlot(new SlotItemHandler(handler, 1, 22, 9));
            this.addSlot(new SlotItemHandler(handler, 2, 43, 9));
            this.addSlot(new SlotItemHandler(handler, 3, 57, 29));
            this.addSlot(new SlotItemHandler(handler, 4, 43, 49));
            this.addSlot(new SlotItemHandler(handler, 5, 22, 49));

            this.addSlot(new SlotItemHandler(handler, 6, 103, 29));
            this.addSlot(new SlotItemHandler(handler, 7, 117, 9));
            this.addSlot(new SlotItemHandler(handler, 8, 138, 9));
            this.addSlot(new SlotItemHandler(handler, 9, 151, 29));
            this.addSlot(new SlotItemHandler(handler, 10, 117, 49));
            this.addSlot(new SlotItemHandler(handler, 11, 138, 49));

            this.addSlot(new SlotItemHandler(handler, 12, 80, 49));






        });
    }

    private void addPlayerInventory(Inventory playerInventory)
    {
        for (int i = 0; i < 3; ++i)
        {
            for (int l = 0; l < 9; ++l)
            {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory)
    {
        for (int i = 0; i < 9; ++i)
        {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 13;  // must match TileEntityInventoryBasic.NUMBER_OF_SLOTS


    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT)
        {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false))
            {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        }
        else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT)
        {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false))
            {
                return ItemStack.EMPTY;
            }
        } else
        {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0)
        {
            sourceSlot.set(ItemStack.EMPTY);
        } else
        {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player)
    {
        return stillValid(ContainerLevelAccess.create(level, quantascope.getBlockPos()), player, BlockInit.QUANTASCOPE.get());
    }
}
