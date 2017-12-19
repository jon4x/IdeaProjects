package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Bukkit;
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

public class Profil implements Listener {

    Inventory profil = Bukkit.createInventory(null, 9*1, "§e§lProfil §7»");

    @EventHandler
    public void onOpenProfil (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.SKULL_ITEM, "§e§lProfil §7(Rechtsklick)")) {
                p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.2f, 0.8f);
                profil.setItem(3, ItemManager.createItem(Material.IRON_SWORD, 1, 0, "§6Statisitken", null));
                profil.setItem(5, ItemManager.createItem(Material.REDSTONE_COMPARATOR, 1, 0, "§6Einstellungen", null));
                p.openInventory(profil);
            }
        }
    }

    @EventHandler
    public void onClickInProfil (InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        Inventory settings = Bukkit.createInventory(null, 9*2, "§e§lEinstellungen §7»");
        settings.setItem(3, ItemManager.createItem(Material.FIREBALL, 1, 0, "§6Douplejump", null));
        settings.setItem(12, ItemManager.createItem(Material.SIGN, 1, 0, "§6Chat", null));
        if (!main.getInstance().getDoubleJump().contains(p.getUniqueId()))
            settings.setItem(4, ItemManager.createItem(Material.WOOL, 1, 13, "§6DoubleJump §7» §aAN", null));
        else
            settings.setItem(4, ItemManager.createItem(Material.WOOL, 1, 14, "§6DoubleJump §7» §cAUS", null));
        if (!main.getInstance().getChatDisable().contains(p.getUniqueId()))
            settings.setItem(13, ItemManager.createItem(Material.WOOL, 1, 13, "§6Chat §7» §aAN", null));
        else
            settings.setItem(13, ItemManager.createItem(Material.WOOL, 1, 14, "§6Chat §7» §cAUS", null));

        if (e.getClickedInventory() != null) {

            if (e.getClickedInventory().getName().equalsIgnoreCase("§e§lProfil §7»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Einstellungen"))
                        p.openInventory(settings);
                }
            }

            if (e.getClickedInventory().getName().equalsIgnoreCase("§e§lEinstellungen §7»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6DoubleJump §7» §aAN")) {
                        main.getInstance().getDoubleJump().add(p.getUniqueId());
                        settings.setItem(4, ItemManager.createItem(Material.WOOL, 1, 14, "§6DoubleJump §7» §cAUS", null));
                        p.openInventory(settings);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6DoubleJump §7» §cAUS")) {
                        main.getInstance().getDoubleJump().remove(p.getUniqueId());
                        settings.setItem(4, ItemManager.createItem(Material.WOOL, 1, 13, "§6DoubleJump §7» §aAN", null));
                        p.openInventory(settings);
                    }

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Chat §7» §aAN")) {
                        main.getInstance().getChatDisable().add(p.getUniqueId());
                        settings.setItem(13, ItemManager.createItem(Material.WOOL, 1, 14, "§6Chat §7» §cAUS", null));
                        p.openInventory(settings);
                    } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Chat §7» §cAUS")) {
                        main.getInstance().getChatDisable().remove(p.getUniqueId());
                        settings.setItem(13, ItemManager.createItem(Material.WOOL, 1, 13, "§6Chat §7» §aAN", null));
                        p.openInventory(settings);
                    }
                }
            }

        }
    }
}
