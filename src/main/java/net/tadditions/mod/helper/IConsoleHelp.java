package net.tadditions.mod.helper;

import net.minecraft.world.World;

import java.util.List;

public interface IConsoleHelp {

   List<World> getBlocked();

   void removeBlocked(World type);
   void addBlocked(World type);

}
