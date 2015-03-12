package loonyrules.co.uk.random.kitpvp.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import loonyrules.co.uk.random.kitpvp.Core;
import loonyrules.co.uk.random.kitpvp.yml.KitDataYML;

public class KitPvPAPI
{

	/*
	 * Main functions
	 */
	
	@SuppressWarnings("deprecation")
	public void createNewKit(String string, PlayerInventory inventory)
	{
		List<String> kits = getKits();
		kits.add(string);
		setKits(kits);

		ItemStack helmet = inventory.getHelmet();
		if(helmet != null && helmet.getType() != Material.AIR)
		{
			Core.getPlugin().getKitData().set("kitData." + string + ".helmet.type", helmet.getData().getItemTypeId() + ":" + helmet.getData().getData());
			if(helmet.getItemMeta().getDisplayName() == null)
			{
				Core.getPlugin().getKitData().set("kitData." + string + ".helmet.name", helmet.getType().toString());
			} else Core.getPlugin().getKitData().set("kitData." + string + ".helmet.name", helmet.getItemMeta().getDisplayName());
			List<String> enchantments = new ArrayList<String>();
			if(helmet.getEnchantments() != null && helmet.getEnchantments().size() >0)
			{
				for(Enchantment e : helmet.getEnchantments().keySet())
				{
					enchantments.add(e.getName() + ":" + helmet.getEnchantmentLevel(e));
				}
			}
			Core.getPlugin().getKitData().set("kitData." + string + ".helmet.enchantment", enchantments);
			Core.getPlugin().getKitData().set("kitData." + string + ".helmet.durability", helmet.getDurability());
			Core.getPlugin().getKitData().set("kitData." + string + ".helmet.amount", helmet.getAmount());
		}
		
		ItemStack chestplate = inventory.getChestplate();
		if(chestplate != null && chestplate.getType() != Material.AIR)
		{
			Core.getPlugin().getKitData().set("kitData." + string + ".chestplate.type", chestplate.getData().getItemTypeId() + ":" + chestplate.getData().getData());
			if(chestplate.getItemMeta().getDisplayName() == null)
			{
				Core.getPlugin().getKitData().set("kitData." + string + ".chestplate.name", chestplate.getType().toString());
			} else Core.getPlugin().getKitData().set("kitData." + string + ".chestplate.name", chestplate.getItemMeta().getDisplayName());
			List<String> enchantments = new ArrayList<String>();
			if(chestplate.getEnchantments() != null && chestplate.getEnchantments().size() >0)
			{
				for(Enchantment e : chestplate.getEnchantments().keySet())
				{
					enchantments.add(e.getName() + ":" + chestplate.getEnchantmentLevel(e));
				}
			}
			Core.getPlugin().getKitData().set("kitData." + string + ".chestplate.enchantment", enchantments);
			Core.getPlugin().getKitData().set("kitData." + string + ".chestplate.durability", chestplate.getDurability());
			Core.getPlugin().getKitData().set("kitData." + string + ".chestplate.amount", chestplate.getAmount());
		}
		
		ItemStack leggings = inventory.getLeggings();
		if(leggings != null && leggings.getType() != Material.AIR)
		{
			Core.getPlugin().getKitData().set("kitData." + string + ".leggings.type", leggings.getData().getItemTypeId() + ":" + leggings.getData().getData());
			if(leggings.getItemMeta().getDisplayName() == null)
			{
				Core.getPlugin().getKitData().set("kitData." + string + ".leggings.name", leggings.getType().toString());
			} else Core.getPlugin().getKitData().set("kitData." + string + ".leggings.name", leggings.getItemMeta().getDisplayName());
			List<String> enchantments = new ArrayList<String>();
			if(leggings.getEnchantments() != null && leggings.getEnchantments().size() >0)
			{
				for(Enchantment e : leggings.getEnchantments().keySet())
				{
					enchantments.add(e.getName() + ":" + leggings.getEnchantmentLevel(e));
				}
			}
			Core.getPlugin().getKitData().set("kitData." + string + ".leggings.enchantment", enchantments);
			Core.getPlugin().getKitData().set("kitData." + string + ".leggings.durability", leggings.getDurability());
			Core.getPlugin().getKitData().set("kitData." + string + ".leggings.amount", leggings.getAmount());
		}
		
		ItemStack boots = inventory.getBoots();
		if(boots != null && boots.getType() != Material.AIR)
		{
			Core.getPlugin().getKitData().set("kitData." + string + ".boots.type", boots.getData().getItemTypeId() + ":" + boots.getData().getData());
			if(boots.getEnchantments() != null && boots.getEnchantments().size() >0)
			{
				Core.getPlugin().getKitData().set("kitData." + string + ".boots.name", boots.getType().toString());
			} else Core.getPlugin().getKitData().set("kitData." + string + ".boots.name", boots.getItemMeta().getDisplayName());
			List<String> enchantments = new ArrayList<String>();
			if(enchantments != null && enchantments.size() > 0)
			{
				for(Enchantment e : boots.getEnchantments().keySet())
				{
					enchantments.add(e.getName() + ":" + boots.getEnchantmentLevel(e));
				}
			}
			Core.getPlugin().getKitData().set("kitData." + string + ".boots.enchantment", enchantments);
			Core.getPlugin().getKitData().set("kitData." + string + ".boots.durability", boots.getDurability());
			Core.getPlugin().getKitData().set("kitData." + string + ".boots.amount", boots.getAmount());
		}
		
		for(int i = 0; i < inventory.getSize(); i++)
		{
			ItemStack target = inventory.getItem(i);
			if(target != null && target.getType() != Material.AIR)
			{
				Core.getPlugin().getKitData().set("kitData." + string + "." + i + ".type", target.getData().getItemTypeId() + ":" + target.getData().getData());
				Core.getPlugin().getKitData().set("kitData." + string + "." + i + ".name", target.getItemMeta().getDisplayName());
				List<String> enchantments = new ArrayList<String>();
				if(target.getEnchantments() != null && target.getEnchantments().size() >0)
				{
					for(Enchantment e : target.getEnchantments().keySet())
					{
						enchantments.add(e.getName() + ":" + target.getEnchantmentLevel(e));
					}
				}
				Core.getPlugin().getKitData().set("kitData." + string + "." + i + ".enchantment", enchantments);
				Core.getPlugin().getKitData().set("kitData." + string + "." + i + ".durability", target.getDurability());
				Core.getPlugin().getKitData().set("kitData." + string + "." + i + ".amount", target.getAmount());
			}
		}
		Core.getPlugin().getKitData().set("kitData." + string + ".clearInventory", false);
		KitDataYML.saveConfig();
	}
	
	public void deleteKit(String string)
	{
		List<String> kits = getKits();
		kits.remove(string);
		setKits(kits);
		Core.getPlugin().getKitData().set("kitData." + string, null);
		KitDataYML.saveConfig();
	}
	
	@SuppressWarnings("deprecation")
	public void setKitInventory(Player p, String kit)
	{
		ItemStack helmet = null;
		ItemMeta helmetMeta = null;
		ItemStack chestplate = null;
		ItemMeta chestplateMeta = null;
		ItemStack leggings = null;
		ItemMeta leggingsMeta = null;
		ItemStack boots = null;
		ItemMeta bootsMeta = null;
		if(Core.getPlugin().getKitData().getString("kitData." + kit) != null)
		{
			if(Core.getPlugin().getKitData().getBoolean("kitData." + kit + ".clearInventory"))
			{
				p.getInventory().setArmorContents(null);
				p.getInventory().clear();
			}
			
			// Helmet
			String t = Core.getPlugin().getKitData().getString("kitData." + kit + ".helmet.type");
			if(t != null)
			{
				String[] type = t.split(":");
				helmet = new ItemStack(Material.getMaterial(Integer.parseInt(type[0])));
				helmet.getData().setData((byte) Byte.parseByte(type[1]));
				helmet.setDurability(Short.parseShort(Core.getPlugin().getKitData().getString("kitData." + kit + ".helmet.durability")));
				helmet.setAmount(Core.getPlugin().getKitData().getInt("kitData." + kit + ".helmet.amount"));
				
				List<String> enchantments = Core.getPlugin().getKitData().getStringList("kitData." + kit + ".helmet.enchantment");
				if(enchantments != null)
				{
					for(String st : enchantments)
					{
						String[] split = st.split(":");
						helmet.addUnsafeEnchantment(Enchantment.getByName(split[0]), Integer.parseInt(split[1]));
					}
				}
				
				helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getKitData().getString("kitData." + kit + ".helmet.name")));
				helmet.setItemMeta(helmetMeta);
			}
			//
			
			// Chestplate
			String t2 = Core.getPlugin().getKitData().getString("kitData." + kit + ".chestplate.type");
			if(t2 != null)
			{
				String[] type2 = t2.split(":");
				chestplate = new ItemStack(Material.getMaterial(Integer.parseInt(type2[0])));
				chestplate.getData().setData((byte) Byte.parseByte(type2[1]));
				chestplate.setDurability(Short.parseShort(Core.getPlugin().getKitData().getString("kitData." + kit + ".chestplate.durability")));
				chestplate.setAmount(Core.getPlugin().getKitData().getInt("kitData." + kit + ".chestplate.amount"));
				
				List<String> enchantments2 = Core.getPlugin().getKitData().getStringList("kitData." + kit + ".chestplate.enchantment");
				if(enchantments2 != null)
				{
					for(String st2 : enchantments2)
					{
						String[] split2 = st2.split(":");
						chestplate.addUnsafeEnchantment(Enchantment.getByName(split2[0]), Integer.parseInt(split2[1]));
					}
				}
				
				chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getKitData().getString("kitData." + kit + ".chestplate.name")));
				chestplate.setItemMeta(chestplateMeta);
			}
			//
			
			// Leggings
			String t3 = Core.getPlugin().getKitData().getString("kitData." + kit + ".leggings.type");
			if(t3 != null)
			{
				String[] type3 = t3.split(":");
				leggings = new ItemStack(Material.getMaterial(Integer.parseInt(type3[0])));
				leggings.getData().setData((byte) Byte.parseByte(type3[1]));
				leggings.setDurability(Short.parseShort(Core.getPlugin().getKitData().getString("kitData." + kit + ".leggings.durability")));
				leggings.setAmount(Core.getPlugin().getKitData().getInt("kitData." + kit + ".leggings.amount"));
				
				List<String> enchantments3 = Core.getPlugin().getKitData().getStringList("kitData." + kit + ".leggings.enchantment");
				if(enchantments3 != null)
				{
					for(String st3 : enchantments3)
					{
						String[] split3 = st3.split(":");
						leggings.addUnsafeEnchantment(Enchantment.getByName(split3[0]), Integer.parseInt(split3[1]));
					}
				}
				
				leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getKitData().getString("kitData." + kit + ".leggings.name")));
				leggings.setItemMeta(leggingsMeta);
			}
			//
			
			// Boots
			String t4 = Core.getPlugin().getKitData().getString("kitData." + kit + ".boots.type");
			if(t3 != null)
			{
				String[] type4 = t4.split(":");
				boots = new ItemStack(Material.getMaterial(Integer.parseInt(type4[0])));
				boots.getData().setData((byte) Byte.parseByte(type4[1]));
				boots.setDurability(Short.parseShort(Core.getPlugin().getKitData().getString("kitData." + kit + ".boots.durability")));
				boots.setAmount(Core.getPlugin().getKitData().getInt("kitData." + kit + ".boots.amount"));
				
				List<String> enchantments4 = Core.getPlugin().getKitData().getStringList("kitData." + kit + ".boots.enchantment");
				if(enchantments4 != null)
				{
					for(String st4 : enchantments4)
					{
						String[] split4 = st4.split(":");
						boots.addUnsafeEnchantment(Enchantment.getByName(split4[0]), Integer.parseInt(split4[1]));
					}
				}
				
				bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getKitData().getString("kitData." + kit + ".boots.name")));
				boots.setItemMeta(bootsMeta);
			}
			//
			
			ItemStack target = null;
			ItemMeta targetMeta = null;
			for(int i = 0; i < p.getInventory().getSize(); i++)
			{
				if(Core.getPlugin().getKitData().getString("kitData." + kit + "." + i) != null)
				{
					String t5 = Core.getPlugin().getKitData().getString("kitData." + kit + "." + i + ".type");
					if(t5 != null)
					{
						String[] type5 = t5.split(":");
						target = new ItemStack(Material.getMaterial(Integer.parseInt(type5[0])));
						target.getData().setData((byte) Byte.parseByte(type5[1]));
						target.setDurability(Short.parseShort(Core.getPlugin().getKitData().getString("kitData." + kit + "." + i + ".durability")));
						target.setAmount(Core.getPlugin().getKitData().getInt("kitData." + kit + "." + i + ".amount"));
						
						List<String> enchantments5 = Core.getPlugin().getKitData().getStringList("kitData." + kit + "." + i + ".enchantment");
						if(enchantments5 != null)
						{
							for(String st5 : enchantments5)
							{
								String[] split5 = st5.split(":");
								target.addUnsafeEnchantment(Enchantment.getByName(split5[0]), Integer.parseInt(split5[1]));
							}
						}
						
						targetMeta = target.getItemMeta();
						if(Core.getPlugin().getKitData().getString("kitData." + kit + "." + i + ".name") != null)
						{
							targetMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getKitData().getString("kitData." + kit + "." + i + ".name")));
						}
						target.setItemMeta(targetMeta);
						p.getInventory().setItem(i, target);
					}
				}
			}
			
			if(helmet != null)
			{
				p.getInventory().setHelmet(helmet);
			}
			
			if(chestplate != null)
			{
				p.getInventory().setChestplate(chestplate);
			}
			
			if(leggings != null)
			{
				p.getInventory().setLeggings(leggings);
			}
			
			if(boots != null)
			{
				p.getInventory().setBoots(boots);
			}
			
			p.updateInventory();
		}
	}
	
	/*
	 * Lists
	 */

	public List<String> getKits()
	{
		return Core.getPlugin().getKitData().getStringList("kits");
	}
	
	public void setKits(List<String> kits)
	{
		Core.getPlugin().getKitData().set("kits", kits);
		KitDataYML.saveConfig();
	}
	
	/*
	 * Booleans
	 */
	
	public boolean getArgsKitsLength2(String s)
	{
		List<String> args = Arrays.asList("create", "delete");
		if(args.contains(s))
		{
			return true;
		}
		return false;
	}
	
	/*
	 * Messages
	 */
	
	public String getMessageNoPermission()
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("messages.noPermission"));
	}
	
	public List<String> getHelpCommandKits()
	{
		return Core.getPlugin().getConfig().getStringList("messages.help.command.kits");
	}
	
	public String getKitAlreadyExists(String kit)
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("messages.duplicatekit").replace("{kit}", kit));
	}
	
	public String noKitFound(String kit)
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("messages.noKitFound").replace("{kit}", kit));
	}
	
	public String kitCreated(String kit)
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("messages.kitCreated").replace("{kit}", kit));
	}
	
	public String kitDeleted(String kit)
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("messages.kitDeleted").replace("{kit}", kit));
	}
	
	public String getSignTopLine()
	{
		return ChatColor.translateAlternateColorCodes('&', Core.getPlugin().getConfig().getString("signs.topline.coloured"));
	}
	
	public String getSignTopLineRAW()
	{
		return Core.getPlugin().getConfig().getString("signs.topline.raw");
	}
	
}