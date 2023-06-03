package net.tadditions.mod.helper;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.blocks.ModBlocks;
import net.tardis.mod.Tardis;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.exterior.AbstractExterior;
import net.tardis.mod.exterior.DisguiseExterior;
import net.tardis.mod.exterior.TwoBlockBasicExterior;
import net.tardis.mod.misc.DoorSounds;
import net.tardis.mod.misc.IDoorType.EnumDoorType;
import net.tardis.mod.registries.ExteriorRegistry;
import net.tardis.mod.texturevariants.TextureVariants;

import java.util.ArrayList;
import java.util.function.Supplier;

public class MExteriorRegistry extends ExteriorRegistry {
	
    public static final DeferredRegister<AbstractExterior> EXTERIORS = DeferredRegister.create(AbstractExterior.class, QolMod.MOD_ID);

	public static AbstractExterior getExterior(ResourceLocation key){
		return EXTERIOR_REGISTRY.get().getValue(key);
	}
	
	public static ArrayList<AbstractExterior> getDefaultExteriors() {
		ArrayList<AbstractExterior> list = new ArrayList<AbstractExterior>();
		for(AbstractExterior ext : EXTERIOR_REGISTRY.get().getValues()) {
			if(ext.isUnlockedByDefault())
				list.add(ext);
		}
		return list;
	}
	
	public static final RegistryObject<AbstractExterior> TOYOTA_POLICE_BOX = EXTERIORS.register("toyota_police_box", () -> new TwoBlockBasicExterior(() -> ModBlocks.exterior_toyota_police_box.get().getDefaultState(), false, IMDoorType.EnumDoorType.TOYOTA, DoorSounds.BASE, new ResourceLocation(QolMod.MOD_ID, "textures/gui/toyota.png"), MTextureVariants.TOYOTA));


}
