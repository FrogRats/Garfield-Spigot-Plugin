package me.BadutCrew.GarfieldPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.getPlayer().setResourcePack("https://www.dropbox.com/sh/xuerfkpvh2nnynv/AABGrpP8XlglyDGa-fIUUsfja?dl=1");
		Bukkit.broadcastMessage("Test");
	}
}
