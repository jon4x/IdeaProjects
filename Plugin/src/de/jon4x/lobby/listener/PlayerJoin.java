package de.jon4x.lobby.listener;

import de.jon4x.lobby.api.SnowAPI;
import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import de.jon4x.lobby.snow.Snowflakes;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static de.jon4x.coinapi.CoinAPI.setCoins;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§a§l + §7" + p.getName());

        if (!p.hasPlayedBefore()) {
            p.teleport(main.getInstance().getSpawn());
            setCoins(p.getUniqueId().toString(), 100);
        }

        Snowflakes.startManage();
        p.getWorld().setThundering(false);
        p.getInventory().clear();
        p.setHealth(20.0);
        p.setHealthScale(6.0);
        p.setFoodLevel(20);
        p.setExp(0);
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();

        p.getInventory().setItem(0, ItemManager.createItem(Material.COMPASS, 1, 0, "§8× §6Navigator §7(Rechtsklick)", null));
        p.getInventory().setItem(1, ItemManager.createItem(Material.INK_SACK, 1, 10,"§8× §cSpieler §8» §aAlle sichtbar §7(Rechtsklick)", null));

        if (p.hasPermission("vip")) {
            p.getInventory().setItem(3, ItemManager.createItem(Material.TNT, 1, 0, "§8× §5VIP-Einstellungen §7(Rechtsklick)", null));
            if (SnowAPI.getState(p.getUniqueId().toString()) == 1)
                p.getInventory().setItem(5, ItemManager.createItem(Material.SULPHUR, 1, 0, "§8× §fSchnee §8» §cNicht sichtbar §7(Rechtsklick)", null));
            else if (SnowAPI.getState(p.getUniqueId().toString()) == 0)
                p.getInventory().setItem(5, ItemManager.createItem(Material.SUGAR, 1, 0, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)", null));
            else
                p.getInventory().setItem(5, ItemManager.createItem(Material.SUGAR, 1, 0, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)", null));
        } else {
            if (SnowAPI.getState(p.getUniqueId().toString()) == 1)
                p.getInventory().setItem(4, ItemManager.createItem(Material.SULPHUR, 1, 0, "§8× §fSchnee §8» §cNicht sichtbar §7(Rechtsklick)", null));
            else if (SnowAPI.getState(p.getUniqueId().toString()) == 0)
                p.getInventory().setItem(4, ItemManager.createItem(Material.SUGAR, 1, 0, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)", null));
            else
                p.getInventory().setItem(4, ItemManager.createItem(Material.SUGAR, 1, 0, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)", null));
        }

        p.getInventory().setItem(7, ItemManager.createItem(Material.REDSTONE_COMPARATOR, 1,0, "§8× §aEinstellungen §7(Rechtsklick)", null));
        p.getInventory().setItem(8, ItemManager.createSkull(Material.SKULL_ITEM, 1, p.getName(), "§8× §eProfil §7(Rechtsklick)", null));
    }
}
