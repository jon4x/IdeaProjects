package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
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

import static de.jon4x.lobby.methods.Inventories.openCompass;

public class Teleporter implements Listener {

    @EventHandler
    public void onTeleporter (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.COMPASS, "§8× §6Navigator §7(Rechtsklick)")) {
                Inventory teleporter = openCompass(p);
                p.openInventory(teleporter);
            }
        }
    }

    @EventHandler
    public void onNavigatorClick (InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        Inventory teleporter = openCompass(p);

        if (e.getClickedInventory() != null) {

            if (e.getClickedInventory().getName().equalsIgnoreCase("§8× §6Navigator §7»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lSpawn")) {
                        p.teleport(main.getInstance().getSpawn());
                        p.playSound(main.getInstance().getSpawn(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.8f);
                        p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                    }

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§eBed Wars")) {
                        p.playSound(p.getLocation(), Sound.ANVIL_USE, 0.5f, 0.1f);
                        teleporter.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", null));
                    }
                }
            }

        }
    }

}
