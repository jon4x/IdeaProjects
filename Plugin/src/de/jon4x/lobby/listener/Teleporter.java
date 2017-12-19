package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Teleporter implements Listener {

    Inventory teleporter = Bukkit.createInventory(null, 9*3, "§c§lNavigator §7»");

    @EventHandler
    public void onTeleporter (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.COMPASS, "§c§lNavigator §7(Rechtsklick)")) {
                p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.2f, 0.8f);
                teleporter.setItem(1, ItemManager.createItem(Material.STAINED_GLASS, 1, 14, "§6§oSoon..", null));
                teleporter.setItem(7, ItemManager.createItem(Material.STAINED_GLASS, 1, 14, "§6§oSoon..", null));
                teleporter.setItem(13, ItemManager.createItem(Material.EYE_OF_ENDER, 1, 0, "§6Spawn", null));
                teleporter.setItem(20, ItemManager.createItem(Material.STAINED_GLASS, 1, 14, "§6§oSoon..", null));
                teleporter.setItem(24, ItemManager.createItem(Material.STAINED_GLASS, 1, 14, "§6§oSoon..", null));
                p.openInventory(teleporter);
            }
        }
    }

    @EventHandler
    public void onNavigatorClick (InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        if (e.getClickedInventory() != null) {

            if (e.getClickedInventory().getName().equalsIgnoreCase("§c§lNavigator §7»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Spawn"))
                        p.teleport(main.getInstance().getSpawn());
                        p.playSound(main.getInstance().getSpawn(), Sound.ENDERMAN_TELEPORT, 0.2f, 0.8f);
                        p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                }
            }

        }
    }

}

/*
 * 0 - *1* - 2 - 3 - 4 - 5 - 6 - *7* - 8
 * 9 - 0 - 1 - 2 - *3* - 4 - 5 - 6 - 7
 * 8 - 9 - *0* - 1 - 2 - 3 - *4* - 5 - 6
 */