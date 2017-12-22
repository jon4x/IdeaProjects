package de.jon4x.lobby.listener;

import de.jon4x.lobby.api.JumppadAPI;
import de.jon4x.lobby.main;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpPads implements Listener {

    @EventHandler
    public void onMove (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (JumppadAPI.getState(p.getUniqueId().toString()) == 0 || p.getLocation() != main.getInstance().getSpawn()) {
            if (p.getLocation().getBlock().getType() == Material.IRON_PLATE) {
                p.setVelocity(p.getLocation().getDirection().multiply(3.0).setY(1.1));
                p.playSound(p.getLocation(), Sound.FIZZ, 0.3f, 1.5f);
                p.getWorld().playEffect(p.getLocation().subtract(0, 1.5, 0), Effect.MOBSPAWNER_FLAMES, 1);
            }
        }
    }
}
