package net.tadditions.mod.traits;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.EmotionHandler.EnumHappyState;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.traits.TardisTrait;
import net.tardis.mod.traits.TardisTraitType;

public class HydrophobicTrait extends TardisTrait {

	public HydrophobicTrait(TardisTraitType type) {
		super(type);
	}

	@Override
	public void tick(ConsoleTile tile) {
		if (!tile.getWorld().isRemote()) {
			ExteriorTile ext = tile.getExteriorType().getExteriorTile(tile);
			
			double mod = 1.0 - this.getWeight();
			
			if(ext != null && tile.getWorld().getGameTime() % (int)Math.ceil(60 + 100 * mod) == 0){
				tile.getWorld().getServer().enqueue(new TickDelayedTask(1, () -> {
					if(!ext.getBlockState().hasProperty(BlockStateProperties.HORIZONTAL_FACING))
						return;
					
					Direction dir = ext.getBlockState().get(BlockStateProperties.HORIZONTAL_FACING);
					if(ext.getWorld().getFluidState(ext.getPos().offset(dir)).isTagged(FluidTags.WATER)) {
						if(tile.getEmotionHandler().getMood() > EnumHappyState.CONTENT.getTreshold()) {
							tile.getEmotionHandler().addMood(-1);
							this.warnPlayerLooped(tile, TardisTrait.DISLIKES_LOCATION, 400);
						}
					}
				}));
			}
		}
	}

}
