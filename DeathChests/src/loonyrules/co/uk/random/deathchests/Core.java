package loonyrules.co.uk.random.deathchests;

import loonyrules.co.uk.random.deathchests.listeners.PlayerDeathEventListener;
import loonyrules.co.uk.random.deathchests.ymls.ChestsFileYML;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Core extends JavaPlugin
{
	
	protected static Core plugin;
	protected static PluginManager pm;
	protected static BukkitScheduler bs;
	protected static ChestsFileYML chests;
	
	@Override
	public void onEnable()
	{
		setPlugin(this);
		setPluginManager(Bukkit.getPluginManager());
		setBukkitScheduler(Bukkit.getScheduler());
		setChestsFile(new ChestsFileYML());
		registerListeners();
		registerCommands();
		
		getChestsFile().getChests().options().copyDefaults(true);
		getChestsFile().saveChests();
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	void registerListeners()
	{
		getPluginManager().registerEvents(new PlayerDeathEventListener(), this);
	}
	
	void registerCommands()
	{
		
	}
	
	/* Setters & Getters*/
	
	public static void setPlugin(Core core)
	{
		plugin = core;
	}
	
	public static Core getPlugin()
	{
		return plugin;
	}
	
	public static void setPluginManager(PluginManager pluginmanager)
	{
		pm = pluginmanager;
	}
	
	public static PluginManager getPluginManager()
	{
		return pm;
	}
	
	public static void setBukkitScheduler(BukkitScheduler bukkitscheduler)
	{
		bs = bukkitscheduler;
	}
	
	public static BukkitScheduler getBukkitScheduler()
	{
		return bs;
	}
	
	public static void setChestsFile(ChestsFileYML chestsfileyml)
	{
		chests = chestsfileyml;
	}
	
	public static ChestsFileYML getChestsFile()
	{
		return chests;
	}
	
}