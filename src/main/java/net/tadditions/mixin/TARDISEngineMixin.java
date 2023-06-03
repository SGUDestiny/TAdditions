package net.tadditions.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraftforge.items.SlotItemHandler;
import net.tadditions.mod.items.ModItems;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.containers.BaseContainer;
import net.tardis.mod.containers.EngineContainer;
import net.tardis.mod.containers.slot.EngineSlot;
import net.tardis.mod.helper.TInventoryHelper;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.TItems;
import net.tardis.mod.tileentities.inventory.PanelInventory;
import org.spongepowered.asm.mixin.Mixin;

import java.util.ArrayList;
import java.util.List;

@Mixin(EngineContainer.class)
public class TARDISEngineMixin extends BaseContainer {

    protected TARDISEngineMixin(ContainerType<?> type, int id) {
        super(type, id);
    }

    public void init(PlayerInventory inv, PanelInventory engine) {

        if(engine.getPanelDirection() == Direction.NORTH) {
            List<Item> dema = new ArrayList<>();

            for(int i = 0; i < 4; ++i) {
                EngineSlot slot = new EngineSlot(engine.getPanelDirection(), engine, i, 18 + i * 42, 1);

                if(i == 0)
                    slot.setFilter(stack -> stack.getItem() == TItems.DEMAT_CIRCUIT.get() || stack.getItem() == ModItems.DEMAT_CIRCUITMK2.get());
                if(i == 1)
                    slot.setFilter(stack -> stack.getItem() == TItems.NAV_COM.get() || stack.getItem() == ModItems.NAV_COMMK2.get());
                if(i == 2)
                    slot.setFilter(stack -> stack.getItem() == TItems.CHAMELEON_CIRCUIT.get() || stack.getItem() == ModItems.CHAMELEON_CIRCUITMK2.get());
                if(i == 3)
                    slot.setFilter(stack -> stack.getItem() == TItems.TEMPORAL_GRACE.get() || stack.getItem() == ModItems.TEMPORAL_GRACEMK2.get());

                this.addSlot(slot);
            }

            for(int i = 0; i < 4; ++i) {

                EngineSlot slot = new EngineSlot(engine.getPanelDirection(), engine, i + 4, 18 + i * 42, 22);

                if(i == 0)
                    slot.setFilter(stack -> stack.getItem() == TItems.FLUID_LINK.get() || stack.getItem() == ModItems.FLUID_LINKMK2.get());
                if(i == 1)
                    slot.setFilter(stack -> stack.getItem() == TItems.STABILIZERS.get() || stack.getItem() == ModItems.STABILIZERSMK2.get());
                if(i == 2)
                    slot.setFilter(stack -> stack.getItem() == TItems.INTERSTITIAL_ANTENNA.get() || stack.getItem() == ModItems.INTERSTITIAL_ANTENNAMK2.get());
                if(i == 3)
                    slot.setFilter(stack -> stack.getItem() == TItems.SHEILD_GENERATOR.get() || stack.getItem() == ModItems.SHEILD_GENERATORMK2.get());

                this.addSlot(slot);
            }

        }
        else if(engine.getPanelDirection() == Direction.SOUTH) {
            for(int i = 0; i < TardisConstants.ENGINE_COMPONENTS_MAX_SLOTS; ++i) {
                this.addSlot(new EngineSlot(engine.getPanelDirection(), engine, i, 16 + (int)Math.ceil((i / 2) * 32.5), 1 + (i % 2) * 21));
            }
        }

        else if(engine.getPanelDirection() == Direction.EAST) {
            for(int i = 0; i < 4; ++i) {
                this.addSlot(new SlotItemHandler(engine, i, 32 + (i / 2) * 22, -1 + (i % 2) * 22));
            }

            this.addSlot(new SlotItemHandler(engine, 4, 119, 10));

        }

        else if(engine.getPanelDirection() == Direction.WEST) {
            for(int i = 0; i < 10; ++i) {
                this.addSlot(new EngineSlot(stack -> stack.getItem() instanceof ArtronCapacitorItem, ((EngineContainer)(Object)this).getPanelDirection(), engine, i, 19 + (i / 2) * 31, 1 + (i % 2) * 21));
            }

        }

        //Add Player inventory
        TInventoryHelper.addPlayerInvContainer(this, inv, 0, -19);

    }

}
