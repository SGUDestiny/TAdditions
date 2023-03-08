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

public class ThermalProtectionUpgrade extends Upgrade implements ITickable{

	private ExteriorTile tile;

	public ThermalProtectionUpgrade(UpgradeEntry entry, ConsoleTile tile, Class<? extends Subsystem> clazz) {
		super(entry, tile, clazz);
		tile.registerTicker(this);
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

	@Override
	public void tick(ConsoleTile console) {
		if(!console.isInFlight() && this.isUsable() && this.isActivated()) {


			if(this.tile == null || this.tile.isRemoved()) {
				tile = console.getExteriorType().getExteriorTile(console);
				return;
			}

			if(tile.getWorld() != null) {
				for(LivingEntity liv : tile.getWorld().getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(tile.getPos()).grow(16))) {
					if(liv.isInLava()) {
						liv.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 400, 1));
						if(liv.world.getGameTime() % 200 == 0)
							this.damage(1, DamageType.PARENT, null);
					}
				}
			}
        }
	}

}
