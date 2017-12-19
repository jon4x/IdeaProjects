package de.jon4x.lobby.listener;

import de.jon4x.lobby.main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {

    @EventHandler
    public void onMove (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE || main.getInstance().getBuildList().contains(p.getUniqueId()) || main.getInstance().getFlyList().contains(p.getUniqueId())) {
            p.setAllowFlight(true);
            return;
        }
        if (main.getInstance().getDoubleJump().contains(p.getUniqueId())) {
            p.setAllowFlight(false);
            return;
        }
        else if (p.getGameMode() != GameMode.CREATIVE && p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR && !p.isFlying() && !p.getAllowFlight()) {
            p.setAllowFlight(true);
        }
    }

    @EventHandler
    public void onToggleFlight (PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE || main.getInstance().getDoubleJump().contains(p.getUniqueId()) || main.getInstance().getFlyList().contains(p.getUniqueId())) {
            return;
        }
        e.setCancelled(true);
        p.setAllowFlight(false);
        p.setFlying(false);
        p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
        p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 0.2f, 0.2f);
    }

}
