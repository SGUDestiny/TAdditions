package net.tadditions.mod.world.structures;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.CompoundNBT;
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

import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommonScorchedStructurePieces {
	
	private static final ResourceLocation TREE1 = new ResourceLocation(QolMod.MOD_ID, "verge/scorched_tree_1");
	private static final ResourceLocation TREE2 = new ResourceLocation(QolMod.MOD_ID, "verge/scorched_tree_2");
	private static final ResourceLocation TREE3 = new ResourceLocation(QolMod.MOD_ID, "verge/scorched_tree_3");
	private static final ResourceLocation TREE4 = new ResourceLocation(QolMod.MOD_ID, "verge/scorched_tree_4");
	private static final ResourceLocation TREE5 = new ResourceLocation(QolMod.MOD_ID, "verge/scorched_tree_5");
	private static final ResourceLocation[] ALL_STRUCTURES = new ResourceLocation[]{TREE1, TREE2, TREE3, TREE4, TREE5};
	
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(TREE1, BlockPos.ZERO, TREE2, BlockPos.ZERO, TREE3, BlockPos.ZERO, TREE4, BlockPos.ZERO, TREE5, BlockPos.ZERO);
    
	
	public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new Piece(templateManager, ALL_STRUCTURES[random.nextInt(ALL_STRUCTURES.length)], blockpos, rotation)); //Hardcode this for now to prevent out of bounds error
    }
	
	public static class Piece extends TemplateStructurePiece {
		private final ResourceLocation resourceLocation;
        private final Rotation rotation;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
			super(MStructures.Structures.SCHORCHEEDCOMMON_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
	        BlockPos blockpos = CommonScorchedStructurePieces.OFFSET.get(resourceLocation);
	        this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
	        this.rotation = rotationIn;
	        this.setupPiece(templateManagerIn);
		}
		
		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(MStructures.Structures.SCHORCHEEDCOMMON_PIECE, tagCompound);
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
        }
		
	}
}
