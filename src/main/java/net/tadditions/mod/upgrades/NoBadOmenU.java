package net.tadditions.mod.upgrades;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;

public class NoBadOmenU extends Upgrade {

	public NoBadOmenU(UpgradeEntry entry, ConsoleTile tile, Class<? extends Subsystem> clazz) {
		super(entry, tile, clazz);
		tile.registerTicker(console -> {
			if(!console.getWorld().isRemote && this.isUsable() && this.isActivated() && console.getWorld().getGameTime() % 20 == 0) {
				for(PlayerEntity player : console.getWorld().getPlayers()) {
					
					EffectInstance badomen = player.getActivePotionEffect(Effects.BAD_OMEN);
					if(badomen != null)
						player.removePotionEffect(Effects.BAD_OMEN);

					
					if(player.getHealth() < player.getMaxHealth()) {
						player.heal(2F);
						this.damage(1, DamageType.ITEM, null);
					}
				}
			}
		});
	}

	@Override
	public void onLand() {}

	@Override
	public void onTakeoff() {}

	@Override
	public void onFlightSecond() {}

}
