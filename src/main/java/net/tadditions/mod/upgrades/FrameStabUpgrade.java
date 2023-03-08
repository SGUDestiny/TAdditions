package net.tadditions.mod.upgrades;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.tardis.mod.misc.ITickable;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;

public class FrameStabUpgrade extends Upgrade {

	private ExteriorTile tile;

	public FrameStabUpgrade(UpgradeEntry entry, ConsoleTile tile, Class<? extends Subsystem> clazz) {
		super(entry, tile, clazz);
	}

	@Override
	public void onLand() {

	}

	@Override
	public void onTakeoff() {

	}

	@Override
	public void onFlightSecond() {

	}

}
