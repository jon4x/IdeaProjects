package de.jon4x.lobby.listener;

import de.jon4x.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (main.getInstance().getChatDisable().contains(all.getUniqueId())) {
                e.getRecipients().remove(all);
            }
        }

        if (main.getInstance().getChatDisable().contains(p.getUniqueId())) {
            p.sendMessage(main.getPrefix() + "§cDu kannst nicht schreiben!");
            e.setCancelled(true);
        }

        if (p.hasPermission("admin"))
            e.setFormat("§4Admin §8\u258f §4" + p.getName() + " §7\u00d7 §f" + e.getMessage());
        else if (p.hasPermission("dev"))
            e.setFormat("§bEntwickler §8\u258f §b" + p.getName() + " §7\u00d7 §f" + e.getMessage());
        else if (p.hasPermission("mod"))
            e.setFormat("§cModerator §8\u258f §c" + p.getName() + " §7\u00d7 §f" + e.getMessage());
        else if (p.hasPermission("premium.plus"))
            e.setFormat("§ePremium+ §8\u258f §e" + p.getName() + " §7\u00d7 §f" + e.getMessage());
        else if (p.hasPermission("premium"))
            e.setFormat("§6Premium §8\u258f §6" + p.getName() + " §7\u00d7 §f" + e.getMessage());
        else
            e.setFormat("§9Spieler §8\u258f §9" + p.getName() + " §7\u00d7 §f" + e.getMessage());
    }

}
