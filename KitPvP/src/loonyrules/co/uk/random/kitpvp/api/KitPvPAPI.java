package loonyrules.co.uk.random.kitpvp.api;

import java.util.List;

import org.bukkit.ChatColor;

import loonyrules.co.uk.random.kitpvp.Core;

public class KitPvPAPI
{

	/*
	 * Messages
	 */
	
	public String getMessageNoPermission()
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("messages.noPermission"));
	}
	
	public List<String> getHelpCommandKits()
	{
		return Core.getPlugin().getConfig().getStringList("messages.help.command.kits");
	}
	
}
