package net.tadditions.mod.helper;

import net.minecraft.world.World;

import java.util.List;

public interface IConsoleHelp {

   List<World> getAvailable();

   void removeAvailable(String type);
   void addAvailable(String type);

}
