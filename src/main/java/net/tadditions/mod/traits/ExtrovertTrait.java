package net.tadditions.mod.traits;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.EmotionHandler.EnumHappyState;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.traits.TardisTrait;
import net.tardis.mod.traits.TardisTraitType;

public class ExtrovertTrait extends TardisTrait {

	public ExtrovertTrait(TardisTraitType type) {
		super(type);
	}

	@Override
	public void tick(ConsoleTile tile) {
		if (!tile.getWorld().isRemote()) {
			if (!tile.isInFlight() && !tile.isLanding()) {
				ExteriorTile ext = tile.getExteriorType().getExteriorTile(tile);
				World world = ext.getWorld();
				AxisAlignedBB area = new AxisAlignedBB(ext.getPos()).grow(16);
				if (tile.getWorld().getGameTime() % 200 == 0) {
					int exteriors = 0;
					for (BlockPos blockPos : BlockPos.getAllInBoxMutable((int) area.minX, (int) area.minY, (int) area.minZ, (int) area.maxX, (int) area.maxY, (int) area.maxZ)) {
						if (world != null &&world.getBlockState(blockPos).getBlock() instanceof ExteriorBlock && !ext.getPos().equals(blockPos.toImmutable())) {
							if (tile.getWorld().getGameTime() % 200 == 0) {
								tile.getEmotionHandler().addMood(+1);
								exteriors ++;
							}
						}
					}
					if (exteriors == 0){
						tile.getEmotionHandler().addMood(-2);
					}else{
						this.warnPlayer(tile, new TranslationTextComponent("tadditions.likes_company"));
					}
				}
			}
		}
	}

}
