package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class HidePlayers implements Listener {

    private HashMap <UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onHidePlayers (PlayerInteractEvent e) {

        int cooldownTime = 5;
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();

        if (cooldown.containsKey(p.getUniqueId())) {
            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if (secondsLeft > 0) {
                p.sendMessage(main.getInstance().getPrefix() + "§7Bitte warte 5 §7Sekunden!");
                return;
            }
        }

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (ItemManager.get(i, Material.GLOWSTONE_DUST, "§e§lSpieler §7§l\u279f §a§lAN §7(Rechtsklick)")) {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.2f, 0.2f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 10));
                p.getInventory().setItem(6, ItemManager.createItem(Material.SULPHUR, 1, 0, "§e§lSpieler §7§l\u279f §c§lAUS §7(Rechtsklick)", null));
                p.sendMessage(main.getInstance().getPrefix() + "§7Alle Spieler sind nun §cunsichtbar");
                for (Player all : main.getInstance().getServer().getOnlinePlayers()) {
                    p.hidePlayer(all);
                }
                main.getInstance().getHideList().add(p.getUniqueId());
            }
            else if (ItemManager.get(i, Material.SULPHUR, "§e§lSpieler §7§l\u279f §c§lAUS §7(Rechtsklick)")) {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.2f, 0.2f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 10));
                p.getInventory().setItem(6, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, 0, "§e§lSpieler §7§l\u279f §a§lAN §7(Rechtsklick)", null));
                p.sendMessage(main.getInstance().getPrefix() + "§7Alle Spieler sind nun §asichtbar");
                for (Player all : main.getInstance().getServer().getOnlinePlayers()) {
                    p.showPlayer(all);
                }
                main.getInstance().getHideList().remove(p.getUniqueId());
            }
        }
    }
}
