package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static de.jon4x.lobby.methods.Inventories.openSettings;

public class Settings implements Listener {

    @EventHandler
    public void onSettings (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.REDSTONE_COMPARATOR, "§8× §aEinstellungen §7(Rechtsklick)")) {
                openSettings(p);
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
