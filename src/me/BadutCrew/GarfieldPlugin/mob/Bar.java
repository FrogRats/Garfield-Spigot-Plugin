package me.BadutCrew.GarfieldPlugin.mob;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
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

	private double Health = 1;
	public BossBar bossbar;
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		if(!event.getItem().getType().equals(Material.ROTTEN_FLESH))
			return;
		if(!event.getItem().getItemMeta().getDisplayName().contains("Lasagne"))
			return;
		
        bossbar = Bukkit.createBossBar("Welcome!", BarColor.PINK, BarStyle.SOLID);
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
		
		ItemMeta meta = cursedItems[0].getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Jon's Bones");
		cursedItems[0].setItemMeta(meta);
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), cursedItems[0]);
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), cursedItems[1]);
		
	}
}
