package loonyrules.co.uk.loonystaffscoreboard.timers;

import org.bukkit.entity.Player;

import loonyrules.co.uk.loonystaffscoreboard.api.LoonySSAPI;

public class LoonySSScoreboardTimer implements Runnable
{

	public void run()
	{
		// This will be called every x seconds (x = number from config)
		for(Player p : LoonySSAPI.getAPI().getScoreboardPlayers())
		{
			if(p != null)
				LoonySSAPI.getAPI().giveScoreboard(p);
		}
	}
	
}