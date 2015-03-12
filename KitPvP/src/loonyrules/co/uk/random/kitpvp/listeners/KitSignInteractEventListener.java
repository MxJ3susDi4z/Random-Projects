package loonyrules.co.uk.random.kitpvp.listeners;

import loonyrules.co.uk.random.kitpvp.Core;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class KitSignInteractEventListener implements Listener
{
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onSignInteractEvent(PlayerInteractEvent e)
	{
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getTypeId() == 68)
		{
			Block block = e.getClickedBlock();
			Sign clickedSign = (Sign) block.getState();
			
			if(clickedSign.getLine(0).equalsIgnoreCase(Core.getPlugin().getMessages().getSignTopLine()))
			{
				String kit = clickedSign.getLine(1);
				if(e.getPlayer().hasPermission("kitpvp.kit." + kit))
				{
					if(Core.getPlugin().getAPI().getKits().contains(clickedSign.getLine(1)))
					{
						Core.getPlugin().getAPI().setKitInventory(e.getPlayer(), kit);
					} else Core.getPlugin().getMessages().noKitFound(e.getPlayer(), clickedSign.getLine(1));
				} else Core.getPlugin().getMessages().noPermission(e.getPlayer());
			}
		}
	}
	
}
