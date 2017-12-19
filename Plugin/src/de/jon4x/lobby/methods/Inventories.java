package de.jon4x.lobby.methods;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Inventories {

    public static Inventory openCompass(Player p) {
        Inventory teleporter = Bukkit.createInventory(null, 9*5, "§8× §6Navigator §7»");
        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.8f);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },1);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },2);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },3);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },4);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },5);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(17, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },6);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(18, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(26, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },7);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(27, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(35, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },8);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(28, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(34, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },9);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(29, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(33, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },10);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(30, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(32, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },11);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(31, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(40, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },12);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(38, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            teleporter.setItem(42, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },13);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(37, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            teleporter.setItem(43, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },14);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(36, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            teleporter.setItem(44, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
        },15);
        Bukkit.getScheduler().scheduleSyncDelayedTask(main.getInstance(), () -> {
            teleporter.setItem(4+9*2, ItemManager.createItem(Material.MAGMA_CREAM, 1, 0, "§e§lSpawn", null));
            teleporter.setItem(1+9*2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
            teleporter.setItem(7+9*2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
            teleporter.setItem(2+9, ItemManager.createItem(Material.STICK, 1, 0, "§eKnockout", null));
            teleporter.setItem(6+9, ItemManager.createItem(Material.BED, 1, 0, "§eBed Wars", null));
            teleporter.setItem(39, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§6§lTägliche Belohnung", null));
            teleporter.setItem(41, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§b§lTeam", null));
            p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.5f, 0.8f);
        },18);

        return teleporter;
    }


    public static Inventory openSettings(Player p) {
        Inventory settings = Bukkit.createInventory(null, 9*5, "§8× §aEinstellungen §7»");
        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.8f);

        return settings;
    }
}
