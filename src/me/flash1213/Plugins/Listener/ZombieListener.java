package me.flash1213.Plugins.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.google.common.base.Converter;

import me.flash1213.Plugins.Main.ZombieKills;

public class ZombieListener implements Listener {
	
	ZombieKills configGetter;
	
		public ZombieListener(ZombieKills plugin) {
			plugin.getServer().getPluginManager().registerEvents(this, plugin);
		configGetter = plugin; 
		}

		@EventHandler
		public void killZombie(EntityDeathEvent e) {
			
			//Entity killed
			Entity deadEntity = e.getEntity();
			//Entity killer
			Entity killer = e.getEntity().getKiller();
			
			if (killer instanceof Player && deadEntity instanceof Zombie) {
				
			Player player = (Player) killer;
			
			int killcount = configGetter.etConfig().getInt("zombiekills");
			
			//Add one kill to the counter
			configGetter.getConfig().set("zombiekills", killcount + 1);
			
			player.sendMessage(§2 + "You have killed a zombie - well done!");
			}
