package me.BadutCrew.GarfieldPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.BadutCrew.GarfieldPlugin.events.EatsLasagne;
public class Main extends JavaPlugin{
	
    @Override
    public void onEnable() {
    	// Lasagne lasagne = new Lasagne();
    	// Bukkit.addRecipe(lasagne.getRecipe());
    	Bukkit.addRecipe(getRecipe());
    	PluginManager pm = this.getServer().getPluginManager();
    	pm.registerEvents(new EatsLasagne(), this);
    }

    @Override
    public void onDisable() {

    }
    


	public ShapedRecipe getRecipe() {
		
		ItemStack item = new ItemStack(Material.PUMPKIN_PIE);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "Lasagne");
		
		item.setItemMeta(meta);
		NamespacedKey key = new NamespacedKey(this, "Lasagne");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("WMW", "EWE", "SSS");
		
		recipe.setIngredient('W', Material.WHEAT);
		recipe.setIngredient('M', Material.MILK_BUCKET);
		recipe.setIngredient('E', Material.EGG);
		recipe.setIngredient('S', Material.COOKED_BEEF);
		
		return recipe;
	}
}
