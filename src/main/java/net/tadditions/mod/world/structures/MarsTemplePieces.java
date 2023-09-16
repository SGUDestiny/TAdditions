package net.tadditions.mod.world.structures;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.tadditions.mod.QolMod;
import net.tadditions.mod.world.TALootTables;
import net.tardis.mod.Tardis;
import net.tardis.mod.helper.Helper;
import net.tardis.mod.loottables.TardisLootTables;
import net.tardis.mod.schematics.Schematic;
import net.tardis.mod.schematics.Schematics;
import net.tardis.mod.tileentities.ShipComputerTile;
import net.tardis.mod.world.structures.TStructures;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class MarsTemplePieces {
	
	private static final ResourceLocation MARSTEMPLE = new ResourceLocation(QolMod.MOD_ID, "mars_temple");
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(MARSTEMPLE, BlockPos.ZERO);
    
	
	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new MarsTemplePieces.Piece(templateManager, MARSTEMPLE, blockpos, rotation));
    }
	
	public static class Piece extends TemplateStructurePiece {
		private final ResourceLocation resourceLocation;
        private final Rotation rotation;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
			super(MStructures.Structures.MARS_TEMPLE_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
	        BlockPos blockpos = MarsTemplePieces.OFFSET.get(resourceLocation);
	        this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
	        this.rotation = rotationIn;
	        this.setupPiece(templateManagerIn);
		}
		
		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(MStructures.Structures.MARS_TEMPLE_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }
		
		private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }
		
		/**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
        	if ("mars_temple_loot_table".equals(function)) {
        		TileEntity te = worldIn.getTileEntity(pos.down().down());
        		 if (te instanceof ChestTileEntity) {
        			 ChestTileEntity chest = (ChestTileEntity) te;
                     chest.setLootTable(TALootTables.MOONTEMPLE, rand.nextLong());
                     worldIn.removeBlock(pos, false);
        		}
        	}
        	if ("crashed_ship".equals(function)) {
        		Helper.addLootToComputerBelow(worldIn, pos, TardisLootTables.CRASHED_SHIP);
        	}
        }
	}
}
