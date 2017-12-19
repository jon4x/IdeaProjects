package de.jon4x.lobby.commands;

import de.jon4x.lobby.main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class BuildCommand implements CommandExecutor {

    HashMap<UUID, ItemStack[]> inv = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!main.getInstance().getBuildList().contains(p.getUniqueId())) {
                main.getInstance().getBuildList().add(p.getUniqueId());
                inv.put(p.getUniqueId(), p.getInventory().getContents());
                p.getInventory().clear();
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(main.getInstance().getPrefix() + "§aSie können nun bauen!");
            }
            else {
                main.getInstance().getBuildList().remove(p.getUniqueId());
                p.getInventory().clear();
                ItemStack[] itemStacks = inv.get(p.getUniqueId());
                p.getInventory().setContents(itemStacks);
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(main.getInstance().getPrefix() + "§cSie können nicht länger bauen!");
                inv.remove(p.getUniqueId());
            }
        } else
            sender.sendMessage(main.getInstance().getPrefix() + "§cYou have to be a Player to execute this command!");
        return false;
    }
}
