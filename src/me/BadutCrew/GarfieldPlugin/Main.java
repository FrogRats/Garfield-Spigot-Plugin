package me.BadutCrew.GarfieldPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.BadutCrew.GarfieldPlugin.events.EatsLasagne;
import me.BadutCrew.GarfieldPlugin.events.JoinEvent;
import me.BadutCrew.GarfieldPlugin.mob.Bar;
import me.BadutCrew.GarfieldPlugin.recipe.Lasagne;
public class Main extends JavaPlugin{
	
    @Override
    public void onEnable() {

    	
    	Bukkit.addRecipe(Lasagne.getRecipe());
    	PluginManager pm = this.getServer().getPluginManager();
    	pm.registerEvents(new EatsLasagne(), this);
    	pm.registerEvents(new JoinEvent(), this);
    	pm.registerEvents(new Bar(), this);
    }

    @Override
    public void onDisable() {

    }
    
	
}
