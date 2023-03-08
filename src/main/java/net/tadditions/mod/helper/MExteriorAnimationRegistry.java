package net.tadditions.mod.helper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tadditions.mod.client.anims.FullNewWhoExteriorAnimation;
import net.tardis.mod.Tardis;
import net.tardis.mod.client.animation.ExteriorAnimationEntry;
import net.tardis.mod.registries.ExteriorAnimationRegistry;


public class MExteriorAnimationRegistry extends ExteriorAnimationRegistry {

	public static final DeferredRegister<ExteriorAnimationEntry> EXTERIOR_ANIMATIONS = DeferredRegister.create(ExteriorAnimationEntry.class, Tardis.MODID);


	public static final RegistryObject<ExteriorAnimationEntry> FULLNEW_WHO = EXTERIOR_ANIMATIONS.register("fullnew_who", () -> new ExteriorAnimationEntry(FullNewWhoExteriorAnimation::new));

}
