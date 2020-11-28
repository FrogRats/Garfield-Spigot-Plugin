package me.BadutCrew.GarfieldPlugin.Mob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.EntityRavager;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.PathfinderGoalLeapAtTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;



public class Garfield extends EntityRavager{

    public Garfield (Location loc) {
        super(EntityTypes.RAVAGER, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new ChatComponentText(ChatColor.GOLD + "" + ChatColor.BOLD + "Garfield"));
        this.setCustomNameVisible(true);

        this.setHealth(400);
        this.setAggressive(Y);
        this.setGoalTarget(lastDamager);

        this.goalSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false));
        this.goalSelector.a(1, new PathfinderGoalLeapAtTarget(this, 10));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 5, false));
    }

}
