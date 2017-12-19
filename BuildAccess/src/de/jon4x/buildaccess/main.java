package de.jon4x.buildaccess;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    private static main instance;
    private static String prefix = "lala §7";

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    public static main getInstance() {
        return instance;
    }
}
