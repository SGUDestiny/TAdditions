package net.tadditions.mod.sound;

import net.tardis.mod.sounds.SoundSchemeBase;
import net.tardis.mod.sounds.TSounds;

public class SoundSchemeFull extends SoundSchemeBase {

	public SoundSchemeFull() {
		super(() -> TSounds.TARDIS_TAKEOFF.get(), () -> TSounds.TARDIS_LAND.get(), () -> TSounds.TARDIS_FLY_LOOP.get());
	}
	
	@Override
	public int getLandTime() {
		return 473;
	}

	@Override
	public int getTakeoffTime() {
		return 200;
	}
	
}
