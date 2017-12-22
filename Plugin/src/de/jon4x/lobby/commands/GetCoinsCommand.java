package de.jon4x.lobby.commands;

import de.jon4x.coinapi.CoinAPI;
import de.jon4x.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetCoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 1) {
                int coins = Integer.parseInt(args[0]);
                CoinAPI.addCoins(p.getUniqueId().toString(), coins);
                switch (coins) {
                    case 1:
                        p.sendMessage(main.getPrefix() + "§7Dir wurde §6" + coins + "§6 Coin §7hinzugefügt");
                        break;
                    default:
                        p.sendMessage(main.getPrefix() + "§7Dir wurden §6" + coins + "§6 Coins §7hinzugefügt");
                        break;
                }
            }
            else if (args.length == 2) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    if (target == p) {
                        int coins = Integer.parseInt(args[1]);
                        switch (coins) {
                            case 1:
                                p.sendMessage(main.getPrefix() + "§7Dir wurde §6" + coins + "§6 Coin §7hinzugefügt");
                                break;
                            default:
                                p.sendMessage(main.getPrefix() + "§7Dir wurden §6" + coins + "§6 Coins §7hinzugefügt");
                                break;
                        }
                    } else {
                        int coins = Integer.parseInt(args[1]);
                        CoinAPI.addCoins(target.getUniqueId().toString(), coins);
                        switch (coins) {
                            case 1:
                                p.sendMessage(main.getPrefix() + "§7Du hast §a" + target.getName() + "§6" + coins + "§6 Coin §7hinzugefügt");
                                target.sendMessage("§7Dir wurde §6" + coins + "§6 Coin §7hinzugefügt!");
                                break;
                            default:
                                p.sendMessage(main.getPrefix() + "§7Du hast §a" + target.getName() + "§6" + coins + "§6 Coins §7hinzugefügt");
                                target.sendMessage("§7Dir wurden §6" + coins + "§6 Coins §7hinzugefügt!");
                                break;
                        }
                    }
                }
            }
        }
        return false;
    }
}
