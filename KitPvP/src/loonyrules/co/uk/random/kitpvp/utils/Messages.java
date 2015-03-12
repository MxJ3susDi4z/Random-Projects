package loonyrules.co.uk.random.kitpvp.utils;

import java.util.List;

import loonyrules.co.uk.random.kitpvp.Core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages
{
	
	public void noPermission(Player p)
	{
		p.sendMessage(Core.getAPI().getMessageNoPermission());
	}
	
	public void helpCommandKits(Player p)
	{
		List<String> help = Core.getAPI().getHelpCommandKits();
		for(String s : help)
		{
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
		}
	}
	
}
