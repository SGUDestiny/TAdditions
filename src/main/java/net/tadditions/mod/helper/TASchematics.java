package net.tadditions.mod.helper;

import net.minecraft.util.ResourceLocation;
import net.tadditions.mod.QolMod;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.schematics.ExteriorUnlockSchematic;
import net.tardis.mod.schematics.Schematics;

public class TASchematics extends Schematics {
    public static class Exteriors {
        public static final ExteriorUnlockSchematic TOYOTA = registerExteriorSchematic(new ResourceLocation(QolMod.MOD_ID, "exteriors/toyota"), MExteriorRegistry.TOYOTA_POLICE_BOX.get());

        private static ExteriorUnlockSchematic registerExteriorSchematic(ResourceLocation key, AbstractExterior exterior) {
            ExteriorUnlockSchematic schematic = createExteriorSchematicWithTranslation(key, exterior);
            Schematics.SCHEMATIC_REGISTRY.put(schematic.getId(), schematic);
            return schematic;
        }
    }
}
