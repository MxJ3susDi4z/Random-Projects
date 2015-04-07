package loonyrules.co.uk.loonystaffscoreboard.listeners;


import java.util.List;

import loonyrules.co.uk.loonystaffscoreboard.LoonyStaffScoreboardCore;
import loonyrules.co.uk.loonystaffscoreboard.api.LoonySSAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener
{
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent e)
	{
		if(LoonySSAPI.getAPI().getScoreboardPlayers().contains(e.getPlayer()))
		{
			List<Player> a = LoonySSAPI.getAPI().getScoreboardPlayers();
			a.remove(e.getPlayer());
			LoonySSAPI.getAPI().setScoreboardPlayers(a);
			LoonySSAPI.getAPI().removeScoreboard(e.getPlayer());
			
			LoonyStaffScoreboardCore.getPlugin().getBukkitScheduler().runTaskLater(LoonyStaffScoreboardCore.getPlugin(), new Runnable()
			{
				public void run()
				{
					for(Player target : LoonySSAPI.getAPI().getScoreboardPlayers())
					{
						LoonySSAPI.getAPI().giveScoreboard(target);
					}
				}
			}, 10L);
			
		}
	}
	
}