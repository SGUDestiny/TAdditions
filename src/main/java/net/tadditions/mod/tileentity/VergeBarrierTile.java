package net.tadditions.mod.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.tardis.mod.controls.LandingTypeControl;
import net.tardis.mod.entity.TardisDisplayEntity;
import net.tardis.mod.helper.LandingSystem;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.IAffectTARDISLanding;
import net.tardis.mod.tileentities.console.misc.AlarmType;
import net.tardis.mod.tileentities.console.misc.MonitorOverride;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VergeBarrierTile extends TileEntity implements IAffectTARDISLanding {
    public VergeBarrierTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public VergeBarrierTile(){
        super(ModTileEntitys.BARRIER.get());
    }



    @Override
    public SpaceTimeCoord affectTARDIS(ServerWorld world, SpaceTimeCoord currentLanding, ConsoleTile console) {
        Random rand = world.rand;
        BlockPos landSpot = LandingSystem.getLand(world, pos.offset(Direction.byHorizontalIndex(rand.nextInt(4)), 100), LandingTypeControl.EnumLandType.DOWN, console);

        //build monitor message
        List<String> list = new ArrayList<>();
        list.add(new TranslationTextComponent("text.verge.barrier.line1").getString());
        list.add(new TranslationTextComponent("text.verge.barrier.line2").getString());
        console.getInteriorManager().setMonitorOverrides(new MonitorOverride(console, 100, list));

        TardisDisplayEntity entity = new TardisDisplayEntity(world);
        BlockPos originalLandPos = currentLanding.getPos();
        //1.17: createBlockEntity
        TileEntity ext = console.getExteriorType().getDefaultState().createTileEntity(world);
        if(ext != null)
            entity.setTile((ExteriorTile)ext);
        entity.setPosition(originalLandPos.getX() + 0.5, originalLandPos.getY() + 1, originalLandPos.getZ() + 0.5);
        entity.setMotion((rand.nextDouble() - 0.5) * 0.5, rand.nextDouble() * 0.5, (rand.nextDouble() - 0.5) * 0.5);
        world.addEntity(entity);

        return new SpaceTimeCoord(world.getDimensionKey(), landSpot);
    }

    @Override
    public int getEffectiveRange() {
        return 40;
    }
}
