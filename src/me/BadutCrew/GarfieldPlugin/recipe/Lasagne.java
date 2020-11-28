package me.BadutCrew.GarfieldPlugin.recipe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import me.BadutCrew.GarfieldPlugin.Main;


public class Lasagne implements Recipe {
	
	public static ShapedRecipe getRecipe() {
		
		ItemStack item = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "Lasagne");
		
		meta.setCustomModelData(1234567);
		item.setItemMeta(meta);
		NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "Lasagne");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("WMW", "EWE", "SSS");
		
		recipe.setIngredient('W', Material.WHEAT);
		recipe.setIngredient('M', Material.MILK_BUCKET);
		recipe.setIngredient('E', Material.EGG);
		recipe.setIngredient('S', Material.COOKED_BEEF);
		
		return recipe;
	}

	@Override
	public ItemStack getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
