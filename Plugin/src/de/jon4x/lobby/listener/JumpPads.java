package de.jon4x.lobby.listener;

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
        if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GOLD_BLOCK) {
            p.setVelocity(p.getLocation().getDirection().multiply(3.0).setY(1.1));
            p.playSound(p.getLocation(), Sound.LAVA_POP, 0.2f, 0.8f);
            p.getWorld().playEffect(p.getLocation().subtract(0, 1.5, 0), Effect.MOBSPAWNER_FLAMES, 1);
        }
    }
}
