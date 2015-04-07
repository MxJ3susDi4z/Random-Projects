package loonyrules.co.uk.loonystaffscoreboard.listeners;

import java.util.List;

import loonyrules.co.uk.loonystaffscoreboard.LoonyStaffScoreboardCore;
import loonyrules.co.uk.loonystaffscoreboard.api.LoonySSAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventListener implements Listener
{
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e)
	{
		if(LoonyStaffScoreboardCore.getPlugin().getConfig().getBoolean("scoreboard.enabled"))
		{
			// Add them to the Scoreboard list fool...
			if(!LoonySSAPI.getAPI().getScoreboardPlayers().contains(e.getPlayer()))
			{
				List<Player> a = LoonySSAPI.getAPI().getScoreboardPlayers();
				a.add(e.getPlayer());
				LoonySSAPI.getAPI().setScoreboardPlayers(a);
				
				for(Player target : LoonySSAPI.getAPI().getScoreboardPlayers())
				{
					LoonySSAPI.getAPI().giveScoreboard(target);
				}
			}
		}
	}
	
}