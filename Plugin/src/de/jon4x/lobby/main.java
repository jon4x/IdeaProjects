package de.jon4x.lobby;

import com.google.common.collect.Sets;
import de.jon4x.lobby.commands.BuildCommand;
import de.jon4x.lobby.commands.GamemodeCommand;
import de.jon4x.lobby.commands.GetCoinsCommand;
import de.jon4x.lobby.commands.GetPosCommand;
import de.jon4x.lobby.listener.*;
import de.jon4x.lobby.snow.Snowflakes;
import de.jon4x.lobby.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;
import java.util.UUID;

public class main extends JavaPlugin {

    private static main instance;
    private Set<UUID> BuildList, FlyList;
    private Set<UUID> chatDisabled;
    private Set<UUID> Teleporter, Settings, ytSettings, Profil;
    private Location Spawn, QSG, Knockout, BedWars, Team, Daily;
    private static String host, datenbank, user, password;
    private static String prefix = "§8» §6Lobby §8× ";

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        instance = this;
        // Locations
        Daily = new Location(getServer().getWorld("world"), 104.5, 67.0, 149.5, -180f, 1.25f);
        Team = new Location(getServer().getWorld("world"), 98.5, 58.0, 146.5, 25.5f, 13.15f);
        BedWars = new Location(getServer().getWorld("world"), 94.5, 67, 153.5, -269.5f, 1f);
        Knockout = new Location(getServer().getWorld("world"), 64.5, 65, -9.5, -269.5f, 0.7f);
        Spawn = new Location(getServer().getWorld("world"), 129.5, 81.0, 198.5, 90.5f, -0.15f);
        QSG = new Location(getServer().getWorld("world"), 58.5, 68.0, 103.5, 89.5f, 1f);
        // SQL
        host = getConfig().getString("config.host"); datenbank = getConfig().getString("config.database"); user = getConfig().getString("config.user"); password = getConfig().getString("config.password");
        // HashSets
        Profil = Sets.newHashSet(); chatDisabled = Sets.newHashSet(); ytSettings = Sets.newHashSet(); Settings = Sets.newHashSet(); Teleporter = Sets.newHashSet(); FlyList = Sets.newHashSet(); BuildList = Sets.newHashSet();

        Snowflakes.call();
        loadConfig();
        MySQL.connect();
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§aPlugin wurde erfolgreich gestartet!");

        // Register Commands
        getCommand("getpos").setExecutor(new GetPosCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("addcoins").setExecutor(new GetCoinsCommand());

        // Register Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Snow(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new Settings(), this);
        pm.registerEvents(new JumpPads(), this);
        pm.registerEvents(new DoubleJump(), this);
        pm.registerEvents(new Profil(), this);
        pm.registerEvents(new Teleporter(), this);
        pm.registerEvents(new Gadgets(), this);
        pm.registerEvents(new HidePlayers(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new Protect(), this);
    }

    @Override
    public void onDisable() {
        MySQL.disconnect();

        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§cPlugin wurde erfolgreich beendet!");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static main getInstance() {
        return instance;
    }

    public Set<UUID> getBuildList() {
        return BuildList;
    }

    public Set<UUID> getFlyList() {
        return FlyList;
    }

    public Location getSpawn() {
        return Spawn;
    }

    public Set<UUID> getTeleporter() {
        return Teleporter;
    }

    public Set<UUID> getSettings() {
        return Settings;
    }

    public Set<UUID> getYtSettings() {
        return ytSettings;
    }

    public static String getHost() {
        return host;
    }

    public static String getDatenbank() {
        return datenbank;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public Set<UUID> getChatDisabled() {
        return chatDisabled;
    }

    public Location getQSG() {
        return QSG;
    }

    public Location getKnockout() {
        return Knockout;
    }

    public Location getBedWars() {
        return BedWars;
    }

    public Location getDaily() {
        return Daily;
    }

    public Location getTeam() {
        return Team;
    }

    public Set<UUID> getProfil() {
        return Profil;
    }
}

