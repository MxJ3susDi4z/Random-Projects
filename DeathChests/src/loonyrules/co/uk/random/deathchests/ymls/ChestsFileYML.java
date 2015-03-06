package loonyrules.co.uk.random.deathchests.ymls;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import loonyrules.co.uk.random.deathchests.Core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ChestsFileYML
{
	
	Core main = Core.getPlugin();
	
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;
	
	public void reloadChests()
	{
		if (customConfigFile == null)
	    {
			customConfigFile = new File(main.getDataFolder(), "chestdata.yml");
	    }
	    customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
	 
	    /* Look for defaults in the jar */
	    Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(main.getResource("chestdata.yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	    if (defConfigStream != null)
	    {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        customConfig.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getChests()
	{
	    if (customConfig == null)
	    {
	        reloadChests();
	    }
	    return customConfig;
	}
	
	public void saveChests()
	{
	    if (customConfig == null || customConfigFile == null)
	    {
	        return;
	    }
	    try {
	        getChests().save(customConfigFile);
	    } catch (IOException ex) {
	        main.getLogger().log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
	    }
	}
	
}
