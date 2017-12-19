package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class Fly implements Listener {

    private HashMap <UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onInteract (PlayerInteractEvent e) {

        int cooldownTime = 5;
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            if (cooldown.containsKey(p.getUniqueId())) {
                long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                if (secondsLeft > 0) {
                    p.sendMessage(main.getInstance().getPrefix() + "§7Bitte warte 5§7 Sekunden!");
                    return;
                }
            }

            if (ItemManager.get(i, Material.FEATHER, "§e§lFliegen §7§l\u279f §a§lAN §7(Rechtsklick)")) {
                if (main.getInstance().getBuildList().contains(p.getUniqueId())) {
                    return;
                }
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                p.sendMessage(main.getInstance().getPrefix() + "§cSie können nicht länger fliegen!");
                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 0.2f, 0.4f);
                p.setAllowFlight(false);
                p.getInventory().setItem(2, ItemManager.createItem(Material.FEATHER, 1, 0, "§e§lFliegen §7§l\u279f §c§lAUS §7(Rechtsklick)", null));
                main.getInstance().getFlyList().remove(p.getUniqueId());
            }
            else if (ItemManager.get(i, Material.FEATHER, "§e§lFliegen §7§l\u279f §c§lAUS §7(Rechtsklick)")) {
                if (main.getInstance().getBuildList().contains(p.getUniqueId())) {
                    return;
                }
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                p.sendMessage(main.getInstance().getPrefix() + "§aSie können nun fliegen!");
                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 0.2f, 0.4f);
                p.setAllowFlight(true);
                p.getInventory().setItem(2, ItemManager.createItem(Material.FEATHER, 1, 0, "§e§lFliegen §7§l\u279f §a§lAN §7(Rechtsklick)", null));
                main.getInstance().getFlyList().add(p.getUniqueId());
            }
        }
    }
}
