package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.methods.Inventories;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class Settings implements Listener {

    @EventHandler
    public void onSettings (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.REDSTONE_COMPARATOR, "§8× §aEinstellungen §7(Rechtsklick)")) {
                Inventories.openSettings(p);
            }
            else if (ItemManager.get(i, Material.TNT, "§8× §5VIP-Einstellungen §7(Rechtsklick)")) {
                Inventories.openYTSettings(p);
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }
}
