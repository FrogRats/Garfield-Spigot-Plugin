package me.BadutCrew.GarfieldPlugin.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;


public class Lasagne extends JavaPlugin {
	

	public ShapedRecipe getRecipe() {
		
		ItemStack item = new ItemStack(Material.PUMPKIN_PIE);
		
		NamespacedKey key = new NamespacedKey(this, "Lasagne");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("WMW", "EWE", "SSS");
		
		recipe.setIngredient('W', Material.WHEAT);
		recipe.setIngredient('M', Material.MILK_BUCKET);
		recipe.setIngredient('E', Material.EGG);
		recipe.setIngredient('M', Material.COOKED_BEEF);
		
		return null;
	}
}
