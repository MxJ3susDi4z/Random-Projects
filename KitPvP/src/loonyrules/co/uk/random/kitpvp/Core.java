package loonyrules.co.uk.random.kitpvp;

import loonyrules.co.uk.random.kitpvp.api.KitPvPAPI;
import loonyrules.co.uk.random.kitpvp.commands.SlashKitsCommand;
import loonyrules.co.uk.random.kitpvp.listeners.KitSignCreationListener;
import loonyrules.co.uk.random.kitpvp.listeners.KitSignInteractEventListener;
import loonyrules.co.uk.random.kitpvp.utils.Messages;
import loonyrules.co.uk.random.kitpvp.yml.KitDataYML;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Core extends JavaPlugin
{
	
	protected static Core plugin;
	protected static PluginManager pm;
	protected static BukkitScheduler bs;
	protected static KitPvPAPI kitpvpAPI;
	protected static FileConfiguration config;
	protected static FileConfiguration kitData;
	protected static Messages messages;
	
	@Override
	public void onEnable()
	{
		setPlugin(this);
		setPluginManager(Bukkit.getPluginManager());
		setBukkitScheduler(Bukkit.getScheduler());
		setAPI(new KitPvPAPI());
		setConfig(getConfig());
		setKitData(KitDataYML.getConfig());
		setMessages(new Messages());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		getKitData().options().copyDefaults(true);
		KitDataYML.saveConfig();
		
		regListeners();
		regCommands();
	}

	@Override
	public void onDisable()
	{
		
	}
	
	void regListeners()
	{
		getPluginManagers().registerEvents(new KitSignCreationListener(), this);
		getPluginManagers().registerEvents(new KitSignInteractEventListener(), this);
	}
	
	void regCommands()
	{
		getCommand("kits").setExecutor(new SlashKitsCommand());
	}
	
	/**
	 * Getters
	 */
	
	public static Core getPlugin()
	{
		return plugin;
	}
	
	public PluginManager getPluginManagers()
	{
		return pm;
	}
	
	public BukkitScheduler getBukkitScheduler()
	{
		return bs;
	}
	
	public KitPvPAPI getAPI()
	{
		return kitpvpAPI;
	}
	
	public FileConfiguration getPluginConfig()
	{
		return config;
	}
	
	public FileConfiguration getKitData()
	{
		return kitData;
	}
	
	public Messages getMessages()
	{
		return messages;
	}
	
	/**
	 * Setters
	 */
	
	public void setPlugin(Core c)
	{
		plugin = c;
	}
	
	public void setPluginManager(PluginManager p)
	{
		pm = p;
	}
	
	public void setBukkitScheduler(BukkitScheduler b)
	{
		bs = b;
	}
	
	public void setAPI(KitPvPAPI api)
	{
		kitpvpAPI = api;
	}
	
	public void setConfig(FileConfiguration c)
	{
		config = c;
	}
	
	public void setKitData(FileConfiguration k)
	{
		kitData = k;
	}
	
	public void setMessages(Messages m)
	{
		messages = m;
	}
	
}