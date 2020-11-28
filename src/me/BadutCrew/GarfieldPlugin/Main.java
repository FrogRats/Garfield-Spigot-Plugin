package me.BadutCrew.GarfieldPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
    

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("hello")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("hey welcome to the server!");
                return true;
            }

            else {
                sender.sendMessage("Hey Console!");
            }
        }

        return false;
    }

}
