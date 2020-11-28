package me.BadutCrew.GarfieldPlugin.mob;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
//import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;


public class Bar implements Listener {
	
    //Broadcast a message to the server
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		if(!event.getItem().getType().equals(Material.ROTTEN_FLESH))
			return;
		if(!event.getItem().getItemMeta().getDisplayName().contains("Lasagne"))
			return;
		
        BossBar bossbar = Bukkit.createBossBar("Welcome!", BarColor.PINK, BarStyle.SOLID);
        bossbar.setProgress(1);
        
        bossbar.addPlayer(event.getPlayer());
        bossbar.setVisible(true);
	}
}
