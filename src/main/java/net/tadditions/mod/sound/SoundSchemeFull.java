package net.tadditions.mod.sound;

import net.minecraft.util.SoundCategory;
import net.minecraft.world.server.ServerWorld;
import net.tardis.mod.sounds.SoundSchemeBase;
import net.tardis.mod.sounds.TSounds;
import net.tardis.mod.tileentities.ConsoleTile;

public class SoundSchemeFull extends SoundSchemeBase {

	public SoundSchemeFull() {
		super(() -> TSounds.TARDIS_TAKEOFF.get(), () -> MSounds.FULLREMA.get(), () -> TSounds.TARDIS_FLY_LOOP.get());
	}
	
	@Override
	public int getLandTime() {
		return 377;
	}

}
