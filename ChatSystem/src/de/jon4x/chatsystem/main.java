package de.jon4x.chatsystem;

import de.jon4x.chatsystem.commands.ClearChat_CMD;
import de.jon4x.chatsystem.listener.PlayerChat;
import de.jon4x.chatsystem.listener.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public class main extends JavaPlugin {

    private static main instance;
    private static String prefix = "";
    private Scoreboard sb;

    @Override
    public void onEnable() {
        instance = this;
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Bukkit.getConsoleSender().sendMessage("");

        // Commands
        getCommand("clearchat").setExecutor(new ClearChat_CMD());

        // Events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerJoin(), this);

        // Scoreboard
        sb.registerNewTeam("00Admin"); sb.registerNewTeam("01SrMod"); sb.registerNewTeam("02Dev"); sb.registerNewTeam("03Mod"); sb.registerNewTeam("04Sup");
        sb.registerNewTeam("05Build"); sb.registerNewTeam("06YT"); sb.registerNewTeam("07Prem+"); sb.registerNewTeam("08Prem"); sb.registerNewTeam("09Spieler");

        sb.getTeam("00Admin").setPrefix("§4Admin §8× §4");
        sb.getTeam("01SrMod").setPrefix("§cSrMod §8× §c");
        sb.getTeam("02Dev").setPrefix("§bDev §8× §b");
        sb.getTeam("03Mod").setPrefix("§cMod §8× §c");
        sb.getTeam("04Sup").setPrefix("§1Sup §8× §1");
        sb.getTeam("05Build").setPrefix("§aB §8× §a");
        sb.getTeam("06YT").setPrefix("§5");
        sb.getTeam("07Prem+").setPrefix("§e");
        sb.getTeam("08Prem").setPrefix("§6");
        sb.getTeam("09Spieler").setPrefix("§a");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("");
    }

    public static main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    public Scoreboard getSb() {
        return sb;
    }
}
