package de.jon4x.chatsystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {


    @EventHandler
    public void onChat (AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("tablist.admin"))
            e.setFormat("§4Admin §8× §4" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.srmoderator"))
            e.setFormat("§cSrModerator §8× §c" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.devloper"))
            e.setFormat("§bDeveloper §8× §b" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.moderator"))
            e.setFormat("§cModerator §8× §c" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.supporter"))
            e.setFormat("§1Supporter §8× §1" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.builder"))
            e.setFormat("§aBuilder §8× §a" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.yt"))
            e.setFormat("§5" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.premium+"))
            e.setFormat("§e" + p.getName() + " §8➟ §7" + e.getMessage());
        else if (p.hasPermission("tablist.premium"))
            e.setFormat("§6" + p.getName() + " §8➟ §7" + e.getMessage());
        else
            e.setFormat("§a" + p.getName() + " §8➟ §7" + e.getMessage());
    }
}
