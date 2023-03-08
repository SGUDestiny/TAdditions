package net.tadditions.mod.upgrades;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;

public class ZR2U extends Upgrade {

	public ZR2U(UpgradeEntry entry, ConsoleTile tile, Class<? extends Subsystem> clazz) {
		super(entry, tile, clazz);
		tile.registerTicker(console -> {
			if(!console.getWorld().isRemote && this.isUsable() && this.isActivated() && console.getWorld().getGameTime() % 20 == 0) {
				for(PlayerEntity player : console.getWorld().getPlayers()) {
					
					EffectInstance poison = player.getActivePotionEffect(Effects.POISON);
					if(poison != null)
						player.removePotionEffect(Effects.POISON);
					EffectInstance nausea = player.getActivePotionEffect(Effects.NAUSEA);
					if(nausea != null)
						player.removePotionEffect(Effects.NAUSEA);
					EffectInstance slowness = player.getActivePotionEffect(Effects.SLOWNESS);
					if(slowness != null)
						player.removePotionEffect(Effects.SLOWNESS);
					EffectInstance minin = player.getActivePotionEffect(Effects.MINING_FATIGUE);
					if(minin != null)
						player.removePotionEffect(Effects.MINING_FATIGUE);
					EffectInstance blind = player.getActivePotionEffect(Effects.BLINDNESS);
					if(blind != null)
						player.removePotionEffect(Effects.BLINDNESS);
					EffectInstance hun = player.getActivePotionEffect(Effects.HUNGER);
					if(hun != null)
						player.removePotionEffect(Effects.HUNGER);

					if(player.fallDistance > 2)
					
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
