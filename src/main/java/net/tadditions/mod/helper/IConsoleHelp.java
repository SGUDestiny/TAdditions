package net.tadditions.mod.helper;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;

import java.util.List;

public interface IConsoleHelp {

   List<RegistryKey<World>> getAvailable();
   boolean getCloakState();
   void setCloakState(boolean state);

   boolean getRecentTimeStormCompletion();
   void setRecentTimeStormCompletion(boolean value);

   int getTimeStormBoostTime();
   void setTimeStormBoostTime(int value);

   void removeAvailable(RegistryKey<World> type);
   void addAvailable(RegistryKey<World> type);

}
