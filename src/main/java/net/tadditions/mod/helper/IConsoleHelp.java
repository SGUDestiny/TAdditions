package net.tadditions.mod.helper;

import net.minecraft.world.World;

import java.util.List;

public interface IConsoleHelp {

   List<String> getBlocked();

   void removeBlocked(String type);
   void addBlocked(String type);

}
