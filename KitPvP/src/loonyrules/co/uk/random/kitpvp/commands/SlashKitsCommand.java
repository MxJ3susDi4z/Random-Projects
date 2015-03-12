package loonyrules.co.uk.random.kitpvp.commands;

import java.util.List;

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
					p.sendMessage("" + ChatColor.YELLOW + ChatColor.ITALIC + "(Plugin made my LoonyRules: www.twitter.com/@RealLoonyRules)");
					Core.getPlugin().getMessages().helpCommandKits(p);
				}
				
				if(args.length == 1)
				{
					if(args[0].equalsIgnoreCase("list"))
					{
						if(p.hasPermission("kitpvp.commands.list"))
						{
							List<String> kits = Core.getPlugin().getAPI().getKits();
							String s = ChatColor.GOLD + "Available kits:";
							for (int x = 0; x < kits.size(); x++)
							{
						        s = s + " " + ChatColor.YELLOW + (String)kits.get(x) + ChatColor.GRAY + ",";
							}
							p.sendMessage(s);
						}
					} else Core.getPlugin().getMessages().helpCommandKits(p);
				}
				
				if(args.length == 2)
				{
					if(Core.getPlugin().getAPI().getArgsKitsLength2(args[0]) && args[0] != null && args[0] != null)
					{
						if(args[0].equalsIgnoreCase("create"))
						{
							if(p.hasPermission("kitpvp.commands.create"))
							{
								if(!Core.getPlugin().getAPI().getKits().contains(args[1]))
								{
									if(p.getInventory().getContents() != null)
									{
										Core.getPlugin().getAPI().createNewKit(args[1], p.getInventory());
										Core.getPlugin().getMessages().kitCreated(p, args[1]);
									}
								} else Core.getPlugin().getMessages().kitAlradyExists(p, args[1]);
							} else Core.getPlugin().getMessages().noPermission(p);
						}
						
						if(args[0].equalsIgnoreCase("delete"))
						{
							if(p.hasPermission("kitpvp.commands.delete"))
							{
								if(Core.getPlugin().getAPI().getKits().contains(args[1]))
								{
									Core.getPlugin().getAPI().deleteKit(args[1]);
									Core.getPlugin().getMessages().kitDeleted(p, args[1]);
								} else Core.getPlugin().getMessages().noKitFound(p, args[1]);
							}
						}
					} else Core.getPlugin().getMessages().helpCommandKits(p);
				}
				
			} else Core.getPlugin().getMessages().noPermission(p);
			return true;
		}
		return false;
	}
	
	
	
}
