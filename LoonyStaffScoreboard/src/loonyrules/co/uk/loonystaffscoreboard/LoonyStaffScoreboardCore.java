package loonyrules.co.uk.loonystaffscoreboard;

import loonyrules.co.uk.loonystaffscoreboard.api.LoonySSAPI;
import loonyrules.co.uk.loonystaffscoreboard.commands.LSSCommand;
import loonyrules.co.uk.loonystaffscoreboard.listeners.PlayerJoinEventListener;
import loonyrules.co.uk.loonystaffscoreboard.listeners.PlayerQuitEventListener;
import loonyrules.co.uk.loonystaffscoreboard.timers.LoonySSScoreboardTimer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class LoonyStaffScoreboardCore extends JavaPlugin
{
	
	private static LoonyStaffScoreboardCore plugin;
	private static PluginManager pm;
	private static BukkitScheduler bs;
	
	public void onEnable()
	{
		plugin = this;
		pm = Bukkit.getPluginManager();
		bs = Bukkit.getScheduler();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		LoonySSAPI.onEnable();
		regTimers();
		regCommands();
		regListeners();
	}
	
	public void onDisable()
	{
		LoonySSAPI.onDisable();
	}
	
	void regTimers()
	{
		getBukkitScheduler().runTaskTimer(plugin, new LoonySSScoreboardTimer(), 0L, 20*getConfig().getInt("scoreboard.timer"));
	}
	
	void regCommands()
	{
		getCommand("lss").setExecutor(new LSSCommand());
	}
	
	void regListeners()
	{
		getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
		getPluginManager().registerEvents(new PlayerQuitEventListener(), this);
	}
	
	/***
	 * Getters
	 */
	
	public static LoonyStaffScoreboardCore getPlugin()
	{
		return plugin;
	}
	
	public PluginManager getPluginManager()
	{
		return pm;
	}
	
	public BukkitScheduler getBukkitScheduler()
	{
		return bs;
	}
	
}