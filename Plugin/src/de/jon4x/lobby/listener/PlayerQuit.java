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
        if (main.getInstance().getTeleporter().contains(p.getUniqueId()))
            main.getInstance().getTeleporter().remove(p.getUniqueId());
        if (main.getInstance().getSettings().contains(p.getUniqueId()))
            main.getInstance().getSettings().remove(p.getUniqueId());
        if (main.getInstance().getYtSettings().contains(p.getUniqueId()))
            main.getInstance().getYtSettings().remove(p.getUniqueId());
        if (main.getInstance().getChatDisabled().contains(p.getUniqueId()))
            main.getInstance().getChatDisabled().remove(p.getUniqueId());
        if (main.getInstance().getProfil().contains(p.getUniqueId()))
            main.getInstance().getProfil().remove(p.getUniqueId());

        e.setQuitMessage("§c§l - §7" + p.getName());
    }
}
