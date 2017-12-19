package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class Premium implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onInteract (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        int cooldownTime = 5;

        if (cooldown.containsKey(p.getUniqueId())) {
            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if (secondsLeft > 0) {
                e.setCancelled(true);
                p.getInventory().setItem(2, ItemManager.createItem(Material.GOLDEN_APPLE, 1, 0,"§e§lPremium §7(Rechtsklick)", null));
                return;
            }
        }

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (ItemManager.get(i, Material.GOLDEN_APPLE, "§e§lPremium §7(Rechtsklick)")) {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                e.setCancelled(true);
                p.sendMessage(main.getPrefix() + "§7Kaufe dir Premium hier: §6buy.DOMAIN.de");
                p.getInventory().setItem(2, ItemManager.createItem(Material.GOLDEN_APPLE, 1, 0,"§e§lPremium §7(Rechtsklick)", null));
            }
        }
    }
}
