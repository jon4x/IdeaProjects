package de.jon4x.lobby.listener;

import de.jon4x.lobby.api.DoublejumpAPI;
import de.jon4x.lobby.api.JumppadAPI;
import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import de.jon4x.lobby.methods.Inventories;
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
import org.bukkit.inventory.meta.ItemMeta;

import static de.jon4x.lobby.methods.Teleport.doTeleport;


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

    @EventHandler
    public void clickInSetting (InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        if (e.getClickedInventory() != null) {

            if (e.getClickedInventory().getName().equalsIgnoreCase("§8× §a§lEinstellungen §8»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§eDoubleJump")) {
                        DoublejumpAPI.setState(p.getUniqueId().toString());
                        if (DoublejumpAPI.getState(p.getUniqueId().toString()) == 1) {
                            p.getOpenInventory().setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                        } else if (DoublejumpAPI.getState(p.getUniqueId().toString()) == 0) {
                            p.getOpenInventory().setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                        }
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§7JumpPads")) {
                        JumppadAPI.setState(p.getUniqueId().toString());
                        if (JumppadAPI.getState(p.getUniqueId().toString()) == 1) {
                            p.getOpenInventory().setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                        } else if (JumppadAPI.getState(p.getUniqueId().toString()) == 0) {
                            p.getOpenInventory().setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                        }
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§9Chat")) {
                        if (!main.getInstance().getChatDisabled().contains(p.getUniqueId())) {
                            p.getOpenInventory().setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            main.getInstance().getChatDisabled().add(p.getUniqueId());
                        }
                        else if (main.getInstance().getChatDisabled().contains(p.getUniqueId())) {
                            p.getOpenInventory().setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            main.getInstance().getChatDisabled().remove(p.getUniqueId());
                        }
                    }
                }
            }

        }
    }
}
