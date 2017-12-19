package de.jon4x.gewinnspiel.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Protect implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Block B = e.getClickedBlock();
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (B.getType() == Material.STONE_BUTTON || B.getType() == Material.WOOD_BUTTON || B.getType() == Material.ARMOR_STAND || B.getType() == Material.ITEM_FRAME || B.getType() == Material.ENDER_CHEST || B.getType() == Material.FURNACE || B.getType() == Material.WORKBENCH || B.getType() == Material.DAYLIGHT_DETECTOR || B.getType() == Material.LEVER || B.getType() == Material.TRAPPED_CHEST || B.getType() == Material.CHEST || B.getType() == Material.NOTE_BLOCK || B.getType() == Material.ANVIL || B.getType() == Material.ENCHANTMENT_TABLE || B.getType() == Material.TRAP_DOOR)) {
                e.setCancelled(true);
            }
            if (e.getAction() == Action.PHYSICAL && (B.getType() == Material.STONE_PLATE)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInteractAt(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
}
