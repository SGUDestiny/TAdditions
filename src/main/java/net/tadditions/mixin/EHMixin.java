package net.tadditions.mixin;

import com.google.common.collect.Lists;
import net.tardis.mod.registries.TraitRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.EmotionHandler;
import net.tardis.mod.traits.TardisTrait;
import net.tardis.mod.traits.TardisTraitType;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(EmotionHandler.class)
public class EHMixin {
    private boolean hasGeneratedTraits = false;
    private TardisTrait[] traits = new TardisTrait[6];


    private void generateTardisTraits() {
        traits = new TardisTrait[5];

        int i = 0;
        //Make a copy of registered traits
        List<TardisTraitType> possibleTraits = Lists.newArrayList(TraitRegistry.TRAIT_REGISTRY.get().getValues());

        for(int x = 0; x < 25; ++x) {
            //If there are no traits to choose from or the TARDIS has four, stop
            if(possibleTraits.isEmpty() || x >= 4)
                break;

            //Generated Type
            TardisTraitType type = possibleTraits.get(ConsoleTile.rand.nextInt(possibleTraits.size()));

            //If this TARDIS already has a trait that conflicts with this one
            if(hasIncompatibleTrait(type))
                continue;

            this.traits[i] = type.create().setWeight(ConsoleTile.rand.nextDouble());
            possibleTraits.remove(type);
            ++i;

        }

        this.hasGeneratedTraits = true;
    }

    private boolean hasIncompatibleTrait(TardisTraitType type) {
        for(int y = 0; y < this.traits.length; ++y) {
            TardisTrait old = this.traits[y];
            //Stop if a pre-existing trait exists already
            if(old != null && !old.getType().isCompatible(type))
                return true;
        }
        return false;
    }

}
