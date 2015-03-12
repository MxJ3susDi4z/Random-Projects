package loonyrules.co.uk.random.kitpvp.utils;

import java.util.List;

import loonyrules.co.uk.random.kitpvp.Core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages
{
	
	public void noPermission(Player p)
	{
		p.sendMessage(Core.getPlugin().getAPI().getMessageNoPermission());
	}
	
	public void helpCommandKits(Player p)
	{
		List<String> help = Core.getPlugin().getAPI().getHelpCommandKits();
		for(String s : help)
		{
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
		}
	}
	
	public void kitAlradyExists(Player p, String kit)
	{
		p.sendMessage(Core.getPlugin().getAPI().getKitAlreadyExists(kit));
	}
	
	public void noKitFound(Player p, String kit)
	{
		p.sendMessage(Core.getPlugin().getAPI().noKitFound(kit));
	}
	
	public void kitCreated(Player p, String kit)
	{
		p.sendMessage(Core.getPlugin().getAPI().kitCreated(kit));
	}
	
	public void kitDeleted(Player p, String kit)
	{
		p.sendMessage(Core.getPlugin().getAPI().kitDeleted(kit));
	}
	
	public String getSignTopLineRAW()
	{
		return Core.getPlugin().getAPI().getSignTopLineRAW();
	}
	
	public String getSignTopLine()
	{
		return Core.getPlugin().getAPI().getSignTopLine();
	}
	
}
