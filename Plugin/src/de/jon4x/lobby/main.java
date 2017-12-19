package de.jon4x.lobby;

import com.google.common.collect.Sets;
import de.jon4x.lobby.commands.BuildCommand;
import de.jon4x.lobby.commands.GamemodeCommand;
import de.jon4x.lobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;
import java.util.UUID;

public class main extends JavaPlugin {

    private static main instance;
    private Set<UUID> BuildList;
    private Set<UUID> HideList;
    private Set<UUID> FlyList;
    private Set<UUID> JumpPads;
    private Set<UUID> DoubleJump;
    private Set<UUID> ChatDisable;
    private Location Spawn;
    private static String prefix = "§e§lKeinPlan.. §8\u258f ";

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        Spawn = new Location(getServer().getWorld("world"), 60, 90.0, 45);
        instance = this;
        FlyList = Sets.newHashSet(); BuildList = Sets.newHashSet(); HideList = Sets.newHashSet(); JumpPads = Sets.newHashSet(); DoubleJump = Sets.newHashSet(); ChatDisable = Sets.newHashSet();

        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§7Plugin wurde erfolgreich gestartet!");

        // Register Commands
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("build").setExecutor(new BuildCommand());

        // Register Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Premium(), this);
        pm.registerEvents(new JumpPads(), this);
        pm.registerEvents(new DoubleJump(), this);
        pm.registerEvents(new Profil(), this);
        pm.registerEvents(new Teleporter(), this);
        pm.registerEvents(new Fly(), this);
        pm.registerEvents(new Gadgets(), this);
        pm.registerEvents(new HidePlayers(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new Protect(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§7Plugin wurde erfolgreich beendet!");
    }

    public static main getInstance() {
        return instance;
    }

    public Set<UUID> getBuildList() {
        return BuildList;
    }

    public Set<UUID> getHideList() {
        return HideList;
    }

    public Set<UUID> getFlyList() {
        return FlyList;
    }

    public Set<UUID> getDoubleJump() {
        return DoubleJump;
    }

    public Set<UUID> getJumpPads() {
        return JumpPads;
    }

    public Location getSpawn() {
        return Spawn;
    }

    public Set<UUID> getChatDisable() {
        return ChatDisable;
    }
}
