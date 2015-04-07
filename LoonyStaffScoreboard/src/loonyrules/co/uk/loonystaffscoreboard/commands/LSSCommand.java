package loonyrules.co.uk.loonystaffscoreboard.commands;

import java.util.List;

import loonyrules.co.uk.loonystaffscoreboard.LoonyStaffScoreboardCore;
import loonyrules.co.uk.loonystaffscoreboard.api.LoonySSAPI;
import loonyrules.co.uk.loonystaffscoreboard.enums.LoonySSEnumStaffListTypes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LSSCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("lss"))
		{
			
			if(args.length == 0 || args.length >= 4)
			{
				sender.sendMessage(ChatColor.GREEN + "Help for " + ChatColor.YELLOW + "LoonyStaffScoreboard" + ChatColor.GREEN + ":");
				sender.sendMessage(ChatColor.DARK_GRAY + " - /lss reload " + ChatColor.GRAY + " - Reload the plugin.");
				sender.sendMessage(ChatColor.DARK_GRAY + " - /lss staff <add:remove> <name> " + ChatColor.GRAY + " - Add/remove a player from the staff list");
				sender.sendMessage(ChatColor.DARK_GRAY + " - /lss timer <timer>" + ChatColor.GRAY + " - Change how long the scoreboard frequently updates.");
			}
			
			if(args.length == 1)
			{
				if(args[0].equalsIgnoreCase("reload"))
				{
					if(sender.hasPermission("lss.command.reload"))
					{
						boolean error = false;
						try {
							LoonyStaffScoreboardCore.getPlugin().onDisable();
							LoonyStaffScoreboardCore.getPlugin().onEnable();
							LoonyStaffScoreboardCore.getPlugin().reloadConfig();
						} catch(Exception ex) {
							error = true;
						}
						
						if(error)
						{
							sender.sendMessage(ChatColor.RED + "Something went wrong when reloading " + ChatColor.YELLOW + "LoonyStaffScoreboard");
						} else sender.sendMessage(ChatColor.GREEN + "Successfully reloaded " + ChatColor.YELLOW + "LoonyStaffScoreboard");
						
					} else sender.sendMessage(ChatColor.RED + "You don't have permission to execute this!");
				} else sender.sendMessage(ChatColor.RED + "Usage: " + ChatColor.ITALIC + "/lss reload");
			}
			
			if(args.length == 2)
			{
				if(args[0].equalsIgnoreCase("timer"))
				{
					if(sender.hasPermission("lss.command.timer"))
					{
						boolean error = false;
						int timer = 0;
						try {
							timer = Integer.parseInt(args[1]);
						} catch(NumberFormatException nfe) {
							error = true;
						}
						
						if(!error)
						{
							LoonyStaffScoreboardCore.getPlugin().getConfig().set("scoreboard.timer", timer);
							LoonyStaffScoreboardCore.getPlugin().saveConfig();
							sender.sendMessage(ChatColor.GREEN + "Timer has been set to: " + ChatColor.YELLOW + timer);
						} else sender.sendMessage(ChatColor.YELLOW + args[1] + ChatColor.RED + " isn't an integer!");
						
					} else sender.sendMessage(ChatColor.RED + "You don't have permission to execute this!");
				}
			}
			
			if(args.length == 3)
			{
				if(args[0].equalsIgnoreCase("staff"))
				{
					if(sender.hasPermission("lss.command.staff"))
					{
						if(args[1].equalsIgnoreCase("add") || args[1].equalsIgnoreCase("remove"))
						{
							if(args[1].equalsIgnoreCase("add"))
							{
								// adding them
								if(!LoonySSAPI.getAPI().getStaffList(LoonySSEnumStaffListTypes.CONFIG, false).contains(args[2]))
								{
									boolean error = false;
									try {
										List<String> op = LoonySSAPI.getAPI().getStaffList(LoonySSEnumStaffListTypes.CONFIG, false);
										op.add(args[2]);
										LoonySSAPI.getAPI().setStaffList(op, LoonySSEnumStaffListTypes.CONFIG);
									} catch(Exception ex) {
										ex.printStackTrace();
										error = true;
									}
									
									if(error)
									{
										sender.sendMessage(ChatColor.RED + "We got scared by a turtle, so we couldn't complete the task...");
									} else sender.sendMessage(ChatColor.YELLOW + args[2] + ChatColor.GREEN + " was added to the Staff list!");
									
								} else sender.sendMessage(ChatColor.RED + "That player is already on the list!");
							}
							
							if(args[1].equalsIgnoreCase("remove"))
							{
								// removing them
								if(LoonySSAPI.getAPI().getStaffList(LoonySSEnumStaffListTypes.CONFIG, false).contains(args[2]))
								{
									boolean error = false;
									try {
										List<String> op = LoonySSAPI.getAPI().getStaffList(LoonySSEnumStaffListTypes.CONFIG, false);
										op.remove(args[2]);
										LoonySSAPI.getAPI().setStaffList(op, LoonySSEnumStaffListTypes.CONFIG);
									} catch(Exception ex) {
										ex.printStackTrace();
										error = true;
									}
									
									if(error)
									{
										sender.sendMessage(ChatColor.RED + "We got scared by a turtle, so we couldn't complete the task...");
									} else sender.sendMessage(ChatColor.YELLOW + args[2] + ChatColor.GREEN + " was remove from the Staff list!");
									
								} else sender.sendMessage(ChatColor.RED + "That player isn't on the list!");
							}
						} else sender.sendMessage(ChatColor.RED + "Usage: " + ChatColor.ITALIC + "/lss staff <add:remove> <name>");
					} else sender.sendMessage(ChatColor.RED + "You don't have permission to execute this!");
				} else sender.sendMessage(ChatColor.RED + "Usage: " + ChatColor.ITALIC + "/lss staff <add:remove> <name>");
			}
			return true;
		}
		return false;
	}
	
	
	
}
