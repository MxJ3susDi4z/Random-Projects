package loonyrules.co.uk.random.deathchests.listeners;

import java.util.Random;

import loonyrules.co.uk.random.deathchests.api.DeathChestsAPI;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathEventListener implements Listener
{
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerDeathEvent(PlayerDeathEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			
			Location deathLocation = e.getEntity().getLocation();
			
		    @SuppressWarnings("deprecation")
			FallingBlock block = deathLocation.getWorld().spawnFallingBlock(deathLocation, Material.CHEST, (byte)0);
		    deathLocation.setY(deathLocation.getY() - 0.0D);
			if(block != null)
			{
				Block b = deathLocation.getWorld().getBlockAt(deathLocation.getBlockX(), deathLocation.getBlockY(), deathLocation.getBlockZ());
				b.setType(Material.CHEST);
				Chest chest = (Chest) b;
				Inventory inventory = chest.getBlockInventory();
				
				ItemStack helmet = null;
				ItemStack chestplate = null;
				ItemStack leggings = null;
				ItemStack boots = null;
				
				if(p.getInventory().getHelmet() != null)
				{ 
					helmet = p.getInventory().getHelmet(); 
					short dur = helmet.getDurability();
					Random random = new Random();
					int rnd = random.nextInt(50);
					if(dur > rnd)
					{
						helmet.setDurability((short) (dur - rnd));
					}
					inventory.addItem(helmet);
				}
				if(p.getInventory().getChestplate() != null)
				{ 
					chestplate = p.getInventory().getChestplate();
					short dur = chestplate.getDurability();
					Random random = new Random();
					int rnd = random.nextInt(50);
					if(dur > rnd)
					{
						chestplate.setDurability((short) (dur - rnd));
					}
					inventory.addItem(chestplate);
				}
				if(p.getInventory().getLeggings() != null)
				{ 
					leggings = p.getInventory().getLeggings();
					short dur = leggings.getDurability();
					Random random = new Random();
					int rnd = random.nextInt(50);
					if(dur > rnd)
					{
						leggings.setDurability((short) (dur - rnd));
					}
					inventory.addItem(leggings);
				}
				if(p.getInventory().getBoots() != null)
				{ 
					boots = p.getInventory().getBoots(); 
					short dur = boots.getDurability();
					Random random = new Random();
					int rnd = random.nextInt(50);
					if(dur > rnd)
					{
						boots.setDurability((short) (dur - rnd));
					}
					inventory.addItem(boots);
				}
				
				for (int i = 0; i < inventory.getSize(); i++)
				{
		            if (p.getInventory().getItem(i) == null)
		            {
		            	inventory.addItem(new ItemStack[] { p.getInventory().getItem(i) });
		            }
				}
				for(ItemStack is : inventory.getContents())
				{
					chest.getBlockInventory().addItem(is);
				}
				
				e.setDroppedExp(0);
				e.getDrops().clear();
			} else Bukkit.broadcastMessage("Not an instanceof Chest");
			
			DeathChestsAPI.storeDeathChest(deathLocation);
		}
	}
	
}
