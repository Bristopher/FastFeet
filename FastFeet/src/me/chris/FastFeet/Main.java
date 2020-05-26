package me.chris.FastFeet;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	public static Long setDelay;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion()
		+ " Has been enabled!");
		setDelay = (long) 20;
		
	}
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been disabled!");
	}
	
	/*
	 * Block above = player.getEyeLocation().add(0,1,0).getBlock();
	 * 
	 * if(above.type != Material.AIR) { //There's a block above player. Do
	 * 
	 * something. }
	 * 
	 * 
	 */
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//hello
		Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("hello")) {
			player.sendMessage("hey"); {
				return true;
			}
		}
		
		if(label.equalsIgnoreCase("fastfeetver")) {
			player.sendMessage("3.0"); {
				return true;
			}
		}
		
		if(label.equalsIgnoreCase("jomama")) {
			//PluginDescriptionFile pdf = this.getDescription();
			//sender.sendMessage("1.0"); {
			//	return true;
			//}
			
		}
		
		if(label.equalsIgnoreCase("fastfeetsetdelay")) {
			
			if (player.isOp()) {
				if(isNum(args[0])) {
					//String userInput = label.substring(18);
					setDelay = Long.valueOf(args[0]);
					
					if(isNum(args[0])) {
						double delaySeconds = (double)setDelay / 20.0;
						player.sendMessage("Delay has been set to " + ChatColor.BOLD  + "" + ChatColor.BLUE + setDelay + ChatColor.RESET + ""  +" ticks / " + ChatColor.BOLD  + "" + ChatColor.BLUE + delaySeconds + ChatColor.RESET + "" + " seconds"); {
							return true;
						}
					}
				} else {
					player.sendMessage(ChatColor.RED + "Usage: /fastfeet setDelay <number-value>"); {
						return true;
					}
				}
			} else {
				player.sendMessage(ChatColor.RED + "You do not have permission!"); {
					return true;
				}
			}
		}
		
		if(label.equalsIgnoreCase("fastfeetdelay")) {
			
			double delaySeconds = (double)setDelay / 20.0;
			player.sendMessage("Delay is " + ChatColor.BOLD  + "" + ChatColor.BLACK + setDelay + ChatColor.RESET + ""  +"ticks / " + ChatColor.BOLD  + "" + ChatColor.BLACK + delaySeconds + ChatColor.RESET + "" + "seconds"); {
				return true;
			}
		}
		
		
		
		return false;	
	}
	
	public boolean isNum(String num) {
		try {
			Long.valueOf(num);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	
	@EventHandler 
	(priority = EventPriority.NORMAL)
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		
		Location loc = p.getLocation();
		loc.setY(loc.getY() -2);
		 
		Block onTopOf = loc.getBlock();
		Material onTopId = onTopOf.getType();
		
		if (onTopId == Material.OBSIDIAN || onTopId == Material.NETHER_PORTAL) {
			
		} else {
			//run runlater
		    new BukkitRunnable() {
		        @Override
		        public void run() {
		             //Code that needs to be delayed here
		        	onTopOf.setType(Material.AIR);
		        }
		    }.runTaskLater(this, 45);
		}
	}
	
	
	
	
}
	
	/*
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
        double locy = p.getLocation().getY();
        Location location = p.getLocation();
        
        
		Location locr = p.getLocation();
		double locy = p.getLocation().getBlock().getRelative(BlockFace.DOWN).getY();
		
		Block b = locr.getBlock();
		b.setType(Material.AIR);
		
		
		
		
		
			
		
		
		
		if (sender instanceof Player) {
			Player p = (Player) sender;

			Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
			MyTask myTask = new MyTask(block);
			myTask.runTaskLater(plugin, 60L);

			public class MyTask extends BukkitRunnable {
				private Block block;

				public MyTask(Block block) {
					this.block = block;
				}

				@Override
				public void run() {
					block.setType(Material.AIR);
				}
			}
		}
	}
	*/
	
	/*
	//If the sender is a player and not console execute this
	if(sender instanceof Player) {
		Player p = (Player) sender;
		p.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "hey");
	} else {
		sender.sendMessage("Hey your not a player");
		return true;
	}
	
	return false;
	*/
	
	/*
	 if(label.substring(0,17).equalsIgnoreCase("fastfeet setdelay")) {
			Player player = (Player) sender;
			if (player.hasPermission("fastfeet setdelay.use")) {
				String userInput = label.substring(18);
				setDelay = Long.valueOf(userInput);
				
				double delaySeconds = (double)setDelay / 20.0;
				sender.sendMessage("Delay has been set to " + ChatColor.BOLD  + "" + ChatColor.BLACK + setDelay + ChatColor.RESET + ""  +"ticks / " + ChatColor.BOLD  + "" + ChatColor.BLACK + delaySeconds + ChatColor.RESET + "" + "seconds"); {
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have permission!"); {
					return true;
				}
			}
		} 
	 
	 */
	
	

	
