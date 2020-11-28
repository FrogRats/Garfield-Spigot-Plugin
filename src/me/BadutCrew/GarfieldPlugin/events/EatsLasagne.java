package me.BadutCrew.GarfieldPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.BadutCrew.GarfieldPlugin.Mob.Garfield;
import net.minecraft.server.v1_16_R3.WorldServer;

public class EatsLasagne implements Listener{
	@EventHandler
	public void placeblock(BlockPlaceEvent event) {
		if(!event.getBlock().getType().equals(Material.GOLD_BLOCK))
			return;
		Garfield gar = new Garfield(event.getPlayer().getLocation());
		WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
		world.addEntity(gar);
		Bukkit.broadcastMessage("Test");
	}
}