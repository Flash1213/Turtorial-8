package me.flash1213.Plugins.Main;

	

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.flash1213.Plugins.Listener.ZombieListener;

	public class ZombieKills extends JavaPlugin {
	
		@Override
	public void onEnable() {
			new ZombieListener(this);
			
			this.getConfig().addDefault("zombiekills", 0);
			
			this.getConfig().options().copyDefaults(true);
			
			saveConfig();
			
	}
	
		@Override
	public void onDisable() {
			saveConfig();
		}

		}
		
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
			if (cmd.getName().equalsIgnoreCase("zombiekills") && sender instanceof Player) {
				
					Player player = (Player) sender;
					
					player.sendMessage(§4 + "" + this.getConfig().getInt("zombiekills") + §2 + "zombies have been killed!");
					return true;
					
					else if (cmd.getName().equalsIgnoreCase("exp") && sender instanceof Player) {
						
						Player player = (Player) sender;
						
						player.sendMessage(§4 + "EXP to next level" + player.getExpToLevel());
						
					
					
			}
			
			return false;
			
	}