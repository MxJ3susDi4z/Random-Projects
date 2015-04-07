package loonyrules.co.uk.loonystaffscoreboard.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import loonyrules.co.uk.loonystaffscoreboard.LoonyStaffScoreboardCore;
import loonyrules.co.uk.loonystaffscoreboard.enums.LoonySSEnumStaffListTypes;

public class LoonySSAPI
{

//----------------------------------------------------------\\
	
	private static LoonySSAPI api;
	
	@SuppressWarnings("deprecation")
	public static void onEnable()
	{
		api = new LoonySSAPI();
		
		for(Player p : Bukkit.getOnlinePlayers())
		{
			LoonySSAPI.getAPI().getScoreboardPlayers().add(p);
		}
		
		LoonySSAPI.getAPI().setStaffList(LoonyStaffScoreboardCore.getPlugin().getConfig().getStringList("staff"), LoonySSEnumStaffListTypes.CONFIG);
		LoonySSAPI.getAPI().setStaffList(LoonyStaffScoreboardCore.getPlugin().getConfig().getStringList("staff"), LoonySSEnumStaffListTypes.PLUGIN);
		
		for(Player target : LoonySSAPI.getAPI().getScoreboardPlayers())
		{
			LoonySSAPI.getAPI().giveScoreboard(target);
		}
		
	}
	
	public static void onDisable()
	{
		
	}
	
//----------------------------------------------------------\\
	
	public static LoonySSAPI getAPI()
	{
		return api;
	}
	
	public void setStaffList(List<String> list, LoonySSEnumStaffListTypes type)
	{
		if(list != null && type != null)
		{
			switch(type)
			{
				case CONFIG:
					// Saving the updated list to the config.
					LoonyStaffScoreboardCore.getPlugin().getConfig().set("staff", list);
					LoonyStaffScoreboardCore.getPlugin().saveConfig();
				break;
				
				case PLUGIN:
					// Saving the updated list to the plugins' list.
					staffPlugin = list;
				break;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public List<String> getStaffList(LoonySSEnumStaffListTypes type, boolean online)
	{
		List<String> retrievedList = new ArrayList<String>();
		if(type != null)
		{
			switch(type)
			{
				case CONFIG:
					// Retrieving the list from the config.
					if(online)
					{
						// Only the online staff members!
						for(Player s : Bukkit.getOnlinePlayers())
						{
							if(LoonyStaffScoreboardCore.getPlugin().getConfig().getString("staff").contains(s.getName()))
								retrievedList.add(s.getName());
						}
					} else retrievedList = LoonyStaffScoreboardCore.getPlugin().getConfig().getStringList("staff");
				break;
				
				case PLUGIN:
					// Retrieving the list from the plugins' list.
					retrievedList = staffPlugin;
				break;
			}
		}
		return retrievedList;
	}
	
	public void setScoreboardPlayers(List<Player> list)
	{
		scoreboardPlayers = list;
	}
	
	public List<Player> getScoreboardPlayers()
	{
		return scoreboardPlayers;
	}
	
	public boolean getTOS()
	{
		return LoonyStaffScoreboardCore.getPlugin().getConfig().getBoolean("scoreboard.onlineOnly");
	}
	
//----------------------------------------------------------\\
	
	List<String> staffPlugin = new ArrayList<String>();
	List<String> staffConfig = new ArrayList<String>();
	List<Player> scoreboardPlayers = new ArrayList<Player>();

//----------------------------------------------------------\\
	
	public void giveScoreboard(Player p)
	{
		if(p != null)
		{
			ScoreboardManager sm = Bukkit.getScoreboardManager();
			Scoreboard s = sm.getNewScoreboard();
			Objective o = s.registerNewObjective("dash", "dummy");
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			o.setDisplayName(ChatColor.translateAlternateColorCodes('&', LoonyStaffScoreboardCore.getPlugin().getConfig().getString("scoreboard.title")));
			
			Score player = null;
			player = o.getScore(ChatColor.RED + "None online...");
			
			List<String> staffList = getStaffList(LoonySSEnumStaffListTypes.PLUGIN, getTOS());
			for(String selected : staffList)
			{
				if(getTOS())
				{
					// ONLINE ONLY
					int current = 0;
					for(int i = current; i < staffList.size(); i++)
					{
						current = current++;
						Player selectedPlayer = Bukkit.getPlayer(selected);
						if(selectedPlayer != null)
						{
							player = o.getScore(ChatColor.GREEN + selected);
							player.setScore(i);
						}
					}
				} else {
					// MEH
					int current = 0;
					for(int i = current; i < staffList.size(); i++)
					{
						current = current++;
						Player selectedPlayer = Bukkit.getPlayer(selected);
						if(selectedPlayer != null)
						{
							player = o.getScore(ChatColor.GREEN + selected);
							player.setScore(i);
						} else {
							player = o.getScore(ChatColor.RED + selected);
							player.setScore(i);
						}
					}
				}
			}
			
			if(!player.isScoreSet())
			{
				player = o.getScore(ChatColor.RED + "None online...");
				player.setScore(0);
			}
			
			p.setScoreboard(s);
		}
	}
	
	public void removeScoreboard(Player p)
	{
		if(p != null)
		{
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		}
	}
	
}
