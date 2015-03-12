package loonyrules.co.uk.random.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import loonyrules.co.uk.random.kitpvp.Core;
public class SlashKitsCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage(ChatColor.RED + "Woah, you're not a player!");
			return true;
		}
		Player p = (Player) sender;
		if(label.equalsIgnoreCase("kits"))
		{
			if(p.hasPermission("kitpvp.commands.kits"))
			{
				if(args.length == 0)
				{
					Core.getMessages().helpCommandKits(p);
				}
			} else Core.getMessages().noPermission(p);
			return true;
		}
		return false;
	}
	
	
	
}
