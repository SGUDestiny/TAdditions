package net.tadditions.mod.helper;

import net.minecraft.world.DimensionType;

import java.util.List;

public interface IConsoleHelp {

   List<DimensionType> getBlocked();

   void removeBlocked(DimensionType type);
   void addBlocked(DimensionType type);

}
