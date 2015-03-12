package loonyrules.co.uk.random.kitpvp.yml;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import loonyrules.co.uk.random.kitpvp.Core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class KitDataYML
{
	
	private static FileConfiguration customConfig = null;
	private static File customConfigFile = null;
	
	public static void reloadConfig()
	{
		if (customConfigFile == null)
	    {
			customConfigFile = new File(Core.getPlugin().getDataFolder(), "kitdata.yml");
	    }
	    customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
	 
	    /* Look for defaults in the jar */
	    Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(Core.getPlugin().getResource("kitdata.yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	    if (defConfigStream != null)
	    {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        customConfig.setDefaults(defConfig);
	    }
	}
	
	public static FileConfiguration getConfig()
	{
	    if (customConfig == null)
	    {
	        reloadConfig();
	    }
	    return customConfig;
	}
	
	public void saveConfig()
	{
	    if (customConfig == null || customConfigFile == null)
	    {
	        return;
	    }
	    try {
	        getConfig().save(customConfigFile);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
}
