package net.tadditions.mod.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.tadditions.mod.blocks.ModBlocks;
import net.tardis.mod.blocks.MultiblockBlock;
import net.tardis.mod.blocks.TBlocks;
import net.tardis.mod.tileentities.IMultiblock;
import net.tardis.mod.tileentities.MultiblockMasterTile;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;

public class ZPFChamberTile extends MultiblockMasterTile implements IAnimatable {
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public ZPFChamberTile(){
        super(ModTileEntitys.ZPFChamber.get());
    }

    private <P extends TileEntity & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation((new AnimationBuilder()).addAnimation("loop", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    @Override
    public void remove() {
        List<BlockPos> poses = this.getSlavePositions();
        super.remove();
        this.getWorld().setBlockState(this.getMaster(), ModBlocks.zero_point_field_broken.get().getDefaultState());
        poses.forEach(pos -> {
            this.getWorld().setBlockState(pos, TBlocks.multiblock.get().getDefaultState());
            TileEntity te = this.getWorld().getTileEntity(pos);
            if (te instanceof IMultiblock) {
                ((IMultiblock) te).setMasterPos(this.getPos());
                ((IMultiblock) te).getMasterTile().addSlavePos(pos);
            }
        });
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
