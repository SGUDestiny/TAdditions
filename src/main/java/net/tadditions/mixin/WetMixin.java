package net.tadditions.mixin;

import net.tadditions.mod.traits.HydrophobicTrait;
import net.tardis.mod.traits.TardisTraitType;
import net.tardis.mod.traits.WetTrait;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WetTrait.class)
public class WetMixin {

    public TardisTraitType getType() {
        return new TardisTraitType(WetTrait::new, test -> test.getTraitClass() == HydrophobicTrait.class);
    }

}
