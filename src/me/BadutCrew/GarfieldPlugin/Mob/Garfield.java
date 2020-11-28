package me.BadutCrew.GarfieldPlugin.mob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityRavager;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;

public class Garfield extends EntityRavager{
	
    public Garfield (Location loc) {
        super(EntityTypes.RAVAGER, ((CraftWorld)loc.getWorld()).getHandle());
        
        this.setPosition(loc.getX()+5, loc.getY()+2, loc.getZ());
       
        this.setHealth(400.0F);
        
        this.setCustomName(new ChatComponentText(ChatColor.GOLD + "" + ChatColor.BOLD + "Garfield"));
        this.setCustomNameVisible(true);      
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void initPathfinder() {
    	
    	this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget(this, EntityPlayer.class, false));
    	this.goalSelector.a(1, new PathfinderGoalMeleeAttack(this, 1.0F, false));
    	
    }
}