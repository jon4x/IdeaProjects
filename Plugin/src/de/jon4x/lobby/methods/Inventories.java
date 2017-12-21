package de.jon4x.lobby.methods;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Inventories {

    public static void openCompass(Player p) {
        Inventory teleporter = Bukkit.createInventory(null, 9*5, "§8× §6§lNavigator §8»");

        if (main.getInstance().getTeleporter().contains(p.getUniqueId())) {
            teleporter.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(17, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(18, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(26, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(27, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(35, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(28, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(34, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(29, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(33, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(30, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(32, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(31, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(38, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(42, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(37, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(43, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(36, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(44, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(10, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(16, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(11, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(15, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(4+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(20, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(21, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(22, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(23, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(24, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(4 + 9 * 4, ItemManager.createItem(Material.MAGMA_CREAM, 1, 0, "§e§lSpawn", null));
            teleporter.setItem(1 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
            teleporter.setItem(7 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
            teleporter.setItem(3 + 9, ItemManager.createItem(Material.STICK, 1, 0, "§eKnockout", null));
            teleporter.setItem(5 + 9, ItemManager.createItem(Material.BED, 1, 0, "§eBed Wars", null));
            teleporter.setItem(39, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§6Tägliche Belohnung", null));
            teleporter.setItem(41, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§6Team", null));
            p.playSound(p.getLocation(), Sound.CLICK, 0.2f, 0.5f);
        }

        else {
            main.getInstance().getTeleporter().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(17, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(10, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(16, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(11, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(15, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(4 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(18, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(26, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(20, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(21, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(22, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(23, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(24, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(27, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(35, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(28, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(34, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(29, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(33, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(30, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(32, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(31, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 12);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(38, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                teleporter.setItem(42, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 13);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(37, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                teleporter.setItem(43, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 14);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(36, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                teleporter.setItem(44, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 15);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                teleporter.setItem(1 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
                teleporter.setItem(7 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
                teleporter.setItem(3 + 9, ItemManager.createItem(Material.STICK, 1, 0, "§eKnockout", null));
                teleporter.setItem(5 + 9, ItemManager.createItem(Material.BED, 1, 0, "§eBed Wars", null));
                teleporter.setItem(39, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§6Tägliche Belohnung", null));
                teleporter.setItem(40, ItemManager.createItem(Material.MAGMA_CREAM, 1, 0, "§e§lSpawn", null));
                teleporter.setItem(41, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§6Team", null));
                p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.5f, 0.8f);
            }, 18);
        }
        p.openInventory(teleporter);
    }

    public static void openSettings(Player p) {
        Inventory settings = Bukkit.createInventory(null, 9*4, "§8× §a§lEinstellungen §8»");

        if (main.getInstance().getSettings().contains(p.getUniqueId())) {
            settings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(0+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(7+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(3+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(5+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(0+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(7+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(3+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(5+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(0+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(7+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(2+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(6+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(3+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(5+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(4+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(4+9, ItemManager.createItem(Material.FIREBALL, 1, 0, "§eDoubleJump", null));
            settings.setItem(2+9, ItemManager.createItem(Material.SIGN, 1, 0, "§9Chat", null));
            settings.setItem(6+9, ItemManager.createItem(Material.GOLD_PLATE, 1, 0, "§6JumpPads", null));
            settings.setItem(4+9*2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
            settings.setItem(2+9*2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
            settings.setItem(6+9*2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
            p.playSound(p.getLocation(), Sound.CLICK, 0.2f, 0.5f);
        }

        else {
            main.getInstance().getSettings().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                settings.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                settings.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(0 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(1 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(7 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(2 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(6 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(3 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(5 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(4 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 12);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                settings.setItem(4 + 9, ItemManager.createItem(Material.FIREBALL, 1, 0, "§eDoubleJump", null));
                settings.setItem(2 + 9, ItemManager.createItem(Material.SIGN, 1, 0, "§9Chat", null));
                settings.setItem(6 + 9, ItemManager.createItem(Material.GOLD_PLATE, 1, 0, "§6JumpPads", null));
                settings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                settings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                settings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.5f, 0.8f);
            }, 15);
        }
        p.openInventory(settings);
    }

    public static void openYTSettings(Player p) {
        Inventory ytSettings = Bukkit.createInventory(null, 9*4, "§8× §5§lVIP-Einstellungen §8»");

        if (main.getInstance().getYtSettings().contains(p.getUniqueId())) {
            ytSettings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(0 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(7 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(2 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(6 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(3 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(5 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(4 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(4 + 9, ItemManager.createItem(Material.EXPLOSIVE_MINECART, 1, 0, "§cSilentlobby", null));
            ytSettings.setItem(2 + 9, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§5Nickname", null));
            ytSettings.setItem(6 + 9, ItemManager.createItem(Material.ENDER_PEARL, 1, 0, "§9Schutzschild", null));
            ytSettings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
            ytSettings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
            ytSettings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
            p.playSound(p.getLocation(), Sound.CLICK, 0.2f, 0.5f);
        }

        else {
            main.getInstance().getYtSettings().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                ytSettings.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                ytSettings.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(0 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(1 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(7 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(2 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(6 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(3 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(5 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(4 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 12);
            Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
                ytSettings.setItem(4 + 9, ItemManager.createItem(Material.EXPLOSIVE_MINECART, 1, 0, "§cSilentlobby", null));
                ytSettings.setItem(2 + 9, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§5Nickname", null));
                ytSettings.setItem(6 + 9, ItemManager.createItem(Material.ENDER_PEARL, 1, 0, "§9Schutzschild", null));
                ytSettings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                ytSettings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                ytSettings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.5f, 0.8f);
            }, 15);
        }
        p.openInventory(ytSettings);
    }
}
