package de.jon4x.coinapi;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    private static String host, datenbank, user, password;

    @Override
    public void onEnable() {
        loadConfig();

        host = getConfig().getString("config.host");
        datenbank = getConfig().getString("config.database");
        user = getConfig().getString("config.user");
        password = getConfig().getString("config.password");

        MySQL.connect();
    }

    @Override
    public void onDisable() {
        MySQL.disconnect();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static String getHost() { return host; }

    public static String getDatenbank() { return datenbank; }

    public static String getUser() { return user; }

    public static String getPassword() { return password; }

}
