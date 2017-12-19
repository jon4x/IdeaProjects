package de.jon4x.lobby.listener;

import de.jon4x.lobby.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void QuitMessage(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (main.getInstance().getBuildList().contains(p.getUniqueId()))
            main.getInstance().getBuildList().remove(p.getUniqueId());
        if (main.getInstance().getFlyList().contains(p.getUniqueId()))
            main.getInstance().getFlyList().remove(p.getUniqueId());

        e.setQuitMessage("§c§l - §7" + p.getName());
    }
}
