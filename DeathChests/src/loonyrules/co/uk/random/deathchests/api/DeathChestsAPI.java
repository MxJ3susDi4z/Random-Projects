package loonyrules.co.uk.random.deathchests.api;

import loonyrules.co.uk.random.deathchests.Core;

import org.bukkit.Location;

public class DeathChestsAPI
{
	
	/* API reference will be added shortly.*/
	
	public static void storeDeathChest(Location deathLocation)
	{
		int i = Core.getChestsFile().getChests().getInt("noc");
		Core.getChestsFile().getChests().set("storedChests." + i + ".world", deathLocation.getWorld().getName());
		Core.getChestsFile().getChests().set("storedChests." + i + ".x", deathLocation.getX());
		Core.getChestsFile().getChests().set("storedChests." + i + ".y", deathLocation.getY());
		Core.getChestsFile().getChests().set("storedChests." + i + ".z", deathLocation.getZ());
		Core.getChestsFile().getChests().set("noc", i++);
		Core.getChestsFile().saveChests();
	}
	
}