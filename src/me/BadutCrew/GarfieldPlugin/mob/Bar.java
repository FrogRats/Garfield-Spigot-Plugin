package me.BadutCrew.GarfieldPlugin.mob;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.entity.Ravager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Bar implements Listener {
	private ItemStack[] cursedItems = {
		new ItemStack(Material.BONE, 10),
		new ItemStack(Material.ENDER_EYE, 2)
	};
	
	private String[] catchPhrases = {
			format("&6Stop it &lJON"), format("&6FEED ME!"), format("&6This is why I hate &lMondays"), 
			format("&6Eat your heart out, &kYOU-MORTAL"), format("&6Stop it &lJON")
	};

	private double Health = 1;
	public BossBar bossbar;
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		if(!event.getItem().getType().equals(Material.ROTTEN_FLESH))
			return;
		if(!event.getItem().getItemMeta().getDisplayName().contains("Lasagne"))
			return;
		
        bossbar = Bukkit.createBossBar(format("&c&lGarfield the &kAlmighty"), BarColor.RED, BarStyle.SEGMENTED_12);
        Player player = (Player) (event.getPlayer());
		player.playSound(player.getLocation(), Sound.MUSIC_DISC_11, 1f, 1f);
        // Reset Health Value
        Health = 1;
        bossbar.setProgress(Health);
        bossbar.addPlayer(event.getPlayer());
        bossbar.setVisible(true);
        
	}
	
	@EventHandler
	public void onHit(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Ravager)) {
			return;
		}
		if(event.getEntity().getCustomName() == null) {
			return;
		}
		
		if(!event.getEntity().getCustomName().contains("Garfield")) {
			return;
		}
		
		// Prevent values subtracting into negatives
		if((event.getDamage()/100) > Health) {
			Health = Health - Health;
		}
		
		else {
			Health = Health - (event.getDamage()/100);
			bossbar.setProgress(Health);
			
			Random val = new Random();
			Bukkit.broadcastMessage(catchPhrases[val.nextInt(catchPhrases.length)]);
		}

	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if(!(event.getEntity() instanceof Ravager)) {
			return;
		}
		if(event.getEntity().getCustomName() == null) {
			return;
		}
		
		if(!event.getEntity().getCustomName().contains("Garfield")) {
			return;
		}
		
		// Drop some loot and kill that boss bar
		event.setDroppedExp(400);
		bossbar.removeAll();
		
		Bukkit.broadcastMessage(format("&6I'll be &l&4BACK &r&6for you ..."));
		
		ItemMeta meta = cursedItems[0].getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Jon's Bones");
		cursedItems[0].setItemMeta(meta);
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), cursedItems[0]);
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), cursedItems[1]);
		
	}
	
	// String Format
	private String format(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
