package me.BadutCrew.GarfieldPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import me.BadutCrew.GarfieldPlugin.mob.Garfield;
import net.minecraft.server.v1_16_R3.WorldServer;

public class EatsLasagne implements Listener{
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		if(!event.getItem().getType().equals(Material.ROTTEN_FLESH))
			return;
		if(!event.getItem().getItemMeta().getDisplayName().contains("Lasagne"))
			return;
		Garfield gar = new Garfield(event.getPlayer().getLocation());
		WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
		world.addEntity(gar);
		Bukkit.broadcastMessage(event.getItem().getItemMeta().getDisplayName());
	}
}
