package loonyrules.co.uk.random.kitpvp.listeners;

import loonyrules.co.uk.random.kitpvp.Core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class KitSignCreationListener implements Listener
{
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onSign(SignChangeEvent e)
	{
		if(e.getLine(0).equalsIgnoreCase(Core.getPlugin().getMessages().getSignTopLineRAW()))
		{
			if(e.getPlayer().hasPermission("kitpvp.signs.create"))
			{
				if(e.getLine(1) != null && Core.getPlugin().getAPI().getKits().contains(e.getLine(1)))
				{
					e.setLine(0, Core.getPlugin().getMessages().getSignTopLine());
					e.setLine(1, e.getLine(1));
					e.setLine(2, null);
					e.setLine(3, null);
				} else Core.getPlugin().getMessages().noKitFound(e.getPlayer(), e.getLine(1));
			} else Core.getPlugin().getMessages().noPermission(e.getPlayer());
		}
	}
	
}
