package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§a§l + §7" + p.getName());

        if (!p.hasPlayedBefore()) {
            p.teleport(main.getInstance().getSpawn());
        }

        for (Player all : main.getInstance().getServer().getOnlinePlayers()) {
            if (main.getInstance().getHideList().contains(all.getUniqueId())) {
                all.hidePlayer(p);
            }
            if (main.getInstance().getHideList().contains(p.getUniqueId())) {
                p.hidePlayer(all);
            }
        }

        p.getInventory().clear();
        p.setHealth(20.0);
        p.setHealthScale(6.0);
        p.setFoodLevel(20);
        p.setExp(0);
        p.setGameMode(GameMode.ADVENTURE);

        if (p.hasPermission("premium")) {
            p.getInventory().setItem(0, ItemManager.createItem(Material.CHEST, 1,1, "§e§lGadgets §7(Rechtsklick)", null));
            p.getInventory().setItem(2, ItemManager.createItem(Material.FEATHER, 1, 0,"§e§lFliegen §7§l\u279f §c§lAUS §7(Rechtsklick)", null));
            p.getInventory().setItem(4, ItemManager.createItem(Material.COMPASS, 1, 0, "§c§lNavigator §7(Rechtsklick)", null));

            if (!main.getInstance().getHideList().contains(p.getUniqueId())) {
                p.getInventory().setItem(6, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, 0, "§e§lSpieler §7§l\u279f §a§lAN §7(Rechtsklick)", null));
            } else
                p.getInventory().setItem(6, ItemManager.createItem(Material.SULPHUR, 1, 0, "§e§lSpieler §7§l\u279f §c§lAUS §7(Rechtsklick)", null));

            p.getInventory().setItem(8, ItemManager.createSkull(Material.SKULL_ITEM, 1, p.getName(), "§e§lProfil §7(Rechtsklick)", null));
        }

        else {
            p.getInventory().setItem(0, ItemManager.createItem(Material.CHEST, 1,1, "§e§lGadgets §7(Rechtsklick)", null));
            p.getInventory().setItem(2, ItemManager.createItem(Material.GOLDEN_APPLE, 1, 0,"§e§lPremium §7(Rechtsklick)", null));
            p.getInventory().setItem(4, ItemManager.createItem(Material.COMPASS, 1, 0, "§c§lNavigator §7(Rechtsklick)", null));

            if (!main.getInstance().getHideList().contains(p.getUniqueId())) {
                p.getInventory().setItem(6, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, 0, "§e§lSpieler §7§l\u279f §a§lAN §7(Rechtsklick)", null));
            } else
                p.getInventory().setItem(6, ItemManager.createItem(Material.SULPHUR, 1, 0, "§e§lSpieler §7§l\u279f §c§lAUS §7(Rechtsklick)", null));

            p.getInventory().setItem(8, ItemManager.createSkull(Material.SKULL_ITEM, 1, p.getName(), "§e§lProfil §7(Rechtsklick)", null));
        }
    }
}

/*
 * *0* - 1 - *2* - 3 - *4* - 5 - *6* - 7 - *8* // Premium
 * 0- 1 - *2* - 3 - *4* - 5 - *6* - 7 - 8 // Normal
 */