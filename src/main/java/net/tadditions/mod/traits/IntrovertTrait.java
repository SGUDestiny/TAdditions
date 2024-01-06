package net.tadditions.mod.traits;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tardis.mod.blocks.exteriors.ExteriorBlock;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.traits.TardisTrait;
import net.tardis.mod.traits.TardisTraitType;

import java.util.Arrays;

public class IntrovertTrait extends TardisTrait {

	public IntrovertTrait(TardisTraitType type) {
		super(type);
	}

	@Override
	public void tick(ConsoleTile tile) {
		if (!tile.getWorld().isRemote()) {
			if (!tile.isInFlight() && !tile.isLanding()) {
				ExteriorTile ext = tile.getExteriorType().getExteriorTile(tile);
				World world = ext.getWorld();
				AxisAlignedBB area = new AxisAlignedBB(ext.getPos()).grow(16);
				for (BlockPos blockPos : BlockPos.getAllInBoxMutable((int) area.minX, (int) area.minY, (int) area.minZ, (int) area.maxX, (int) area.maxY, (int) area.maxZ)) {
					if (world != null &&world.getBlockState(blockPos).getBlock() instanceof ExteriorBlock) {
						if (tile.getWorld().getGameTime() % 200 == 0) {
							ExteriorTile extile = (ExteriorTile) world.getTileEntity(blockPos);
							ConsoleTile intile = TardisHelper.getConsole(world.getServer(), extile.getInteriorDimensionKey()).orElse(null);
							if (intile != null) {
								if(Arrays.stream(intile.getEmotionHandler().getTraits()).anyMatch(trait -> trait.equals(MTraits.INTROVERT))) {
									tile.getEmotionHandler().addMood(+2);
								} else if(Arrays.stream(intile.getEmotionHandler().getTraits()).anyMatch(trait -> trait.equals(MTraits.EXTROVERT))){
									tile.getEmotionHandler().addMood(-2);
								} else tile.getEmotionHandler().addMood(-1);

							}
						}
					}
				}
			}
		}
	}

}
