package me.BadutCrew.GarfieldPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.getPlayer().setResourcePack("https://www.dropbox.com/sh/ykytf1o9eqg556m/AACApyo6XNep9WJk21Sh_pUka?dl=1");
		Bukkit.broadcastMessage("Test");
	}
	

}
