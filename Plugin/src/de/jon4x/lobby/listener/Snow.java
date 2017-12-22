package de.jon4x.lobby.listener;

import de.jon4x.lobby.api.SnowAPI;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class Snow implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onSnowChange(PlayerInteractEvent e) {

        int cooldownTime = 5;
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();

        if (cooldown.containsKey(p.getUniqueId())) {
            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if (secondsLeft > 0) {
                p.sendMessage(main.getInstance().getPrefix() + "§c" + "Bitte habe einen moment Geduld!");
                return;
            }
        }

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (ItemManager.get(i, Material.SUGAR, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)")) {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 1.5f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 15, 10));
                if (p.hasPermission("vip"))
                    p.getInventory().setItem(5, ItemManager.createItem(Material.SULPHUR, 1, 0, "§8× §fSchnee §8» §cNicht sichtbar §7(Rechtsklick)", null));
                else
                    p.getInventory().setItem(1, ItemManager.createItem(Material.SULPHUR, 1, 0, "§8× §fSchnee §8» §cNicht sichtbar §7(Rechtsklick)", null));
                p.sendMessage(main.getInstance().getPrefix() + "§7Du siehst nun §ckeinen §7Schnee mehr!");
                SnowAPI.setState(p.getUniqueId().toString());
            }
            else if (ItemManager.get(i, Material.SULPHUR, "§8× §fSchnee §8» §cNicht sichtbar §7(Rechtsklick)")) {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 1.5f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 15, 10));
                if (p.hasPermission("vip"))
                    p.getInventory().setItem(5, ItemManager.createItem(Material.SUGAR, 1, 0, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)", null));
                else
                    p.getInventory().setItem(1, ItemManager.createItem(Material.SUGAR, 1, 0, "§8× §fSchnee §8» §aSichtbar §7(Rechtsklick)", null));
                p.sendMessage(main.getInstance().getPrefix() + "§7Du siehst nun §awieder §7Schnee!");
                SnowAPI.setState(p.getUniqueId().toString());
            }
        }
    }

}
