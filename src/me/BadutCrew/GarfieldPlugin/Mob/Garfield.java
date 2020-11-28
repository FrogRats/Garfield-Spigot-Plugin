package me.BadutCrew.GarfieldPlugin.mob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityRavager;
import net.minecraft.server.v1_16_R3.EntityTypes;



public class Garfield extends EntityRavager{
	
    public Garfield (Location loc) {
        super(EntityTypes.RAVAGER, ((CraftWorld)loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
       
        this.setHealth(400.0F);
        
        this.setCustomName(new ChatComponentText(ChatColor.GOLD + "" + ChatColor.BOLD + "Garfield"));
        this.setCustomNameVisible(true);      
    }
    
    @Override
    public void initPathfinder() {
    	
    	
    	
    }
}
