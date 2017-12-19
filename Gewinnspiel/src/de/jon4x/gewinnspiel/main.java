package de.jon4x.gewinnspiel;

import de.jon4x.gewinnspiel.commands.Gewinnspiel_CMD;
import de.jon4x.gewinnspiel.listener.Protect;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    @Getter private static main instance;
    @Getter private static String prefix = "§8» §6Lobby §8× ";

    public static main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        instance = this;

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Protect(), this);

        getCommand("gewinnspiel").setExecutor(new Gewinnspiel_CMD());
        Bukkit.getConsoleSender().sendMessage("§aPlugin wurde aktiviert!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cPlugin wurde deaktiviert!");
    }
}
