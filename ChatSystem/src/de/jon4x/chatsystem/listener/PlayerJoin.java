package de.jon4x.chatsystem.listener;

import de.jon4x.chatsystem.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Bukkit.getScheduler().runTaskLaterAsynchronously(main.getInstance(), () -> setPrefix(p), 10);
    }

    public void setPrefix(Player p) {
        String team = "";

        if (p.hasPermission("tablist.admin"))
            team = "00Admin";
        else if (p.hasPermission("tablist.srmoderator"))
            team = "01SrMod";
        else if (p.hasPermission("tablist.devloper"))
            team = "02Dev";
        else if (p.hasPermission("tablist.moderator"))
            team = "03Mod";
        else if (p.hasPermission("tablist.supporter"))
            team = "04Sup";
        else if (p.hasPermission("tablist.builder"))
            team = "05Build";
        else if (p.hasPermission("tablist.yt"))
            team = "06YT";
        else if (p.hasPermission("tablist.premium+"))
            team = "07Prem+";
        else if (p.hasPermission("tablist.premium"))
            team = "08Prem";
        else
            team = "09Spieler";

        main.getInstance().getSb().getTeam(team).addPlayer(p);
        p.setDisplayName(main.getInstance().getSb().getTeam(team).getPrefix() + p.getName());

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.setScoreboard(main.getInstance().getSb());
        }

    }
}
