package me.BadutCrew.GarfieldPlugin.mob;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;


public class Bar implements Listener {
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
		if(!event.getEntityType().equals(EntityType.RAVAGER)) {
			return;
		}
		
		Health = Health - (event.getDamage()/100);
		bossbar.setProgress(Health);
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent event) {
		if(!event.getEntityType().equals(EntityType.RAVAGER)) {
			return;
		}
		
		event.setDroppedExp(400);
		bossbar.removeAll();
	}
}
