package net.tadditions.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tadditions.mod.helper.MExteriorRegistry;
import net.tadditions.mod.tileentity.ToyotaPoliceBoxDecoTile;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.renderers.SonicRenderer;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.SonicItem;
import net.tardis.mod.schematics.ExteriorUnlockSchematic;
import net.tardis.mod.schematics.Schematics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(SonicItem.class)
public class SonicMixin extends Item {
    public SonicMixin() {
        super(new Item.Properties().maxStackSize(1).group(TItemGroups.MAIN).setISTER(() -> SonicRenderer::new));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {

        if(context.getWorld().getBlockState(context.getPos()).getBlock() == ModBlocks.decorative_toyota_police_box.get()) {
            ToyotaPoliceBoxDecoTile tile = (ToyotaPoliceBoxDecoTile) context.getWorld().getTileEntity(context.getPos());
            if(!tile.isScanned()) {
                context.getItem().getCapability(Capabilities.SONIC_CAPABILITY).ifPresent(cap -> {
                    ExteriorUnlockSchematic schematic = Schematics.createExteriorSchematicWithTranslation(new ResourceLocation(QolMod.MOD_ID, "exteriors/toyota"), MExteriorRegistry.TOYOTA_POLICE_BOX.get());
                    cap.addSchematic(schematic);
                    tile.setScanned(true);
                });
            }
        }

        return super.onItemUse(context);
    }
}
