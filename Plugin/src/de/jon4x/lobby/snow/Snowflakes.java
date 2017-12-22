package de.jon4x.lobby.snow;

import de.jon4x.lobby.api.SnowAPI;
import de.jon4x.lobby.main;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

public class Snowflakes {

    private static float speed = 0.0f;
    private static int amount = 65;
    private static int horizontal = 15;
    private static int vertical = 15;

    public static void sendParticle(Player p, Location loc, Float speed, Integer amount) {
        EnumParticle enumParticle = EnumParticle.FIREWORKS_SPARK;
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(enumParticle, true, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), 0.0F, 0.0F, 0.0F, speed.floatValue(), amount.intValue(), null);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    private static Double rdmDouble(Integer min, Integer max) {
        Random random = new Random();
        return Double.valueOf(min.intValue() + (max.intValue() - min.intValue()) * random.nextDouble());
    }

    public static void startManage() {
        BukkitTask bukkitTask = new BukkitRunnable() {
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (SnowAPI.getState(p.getUniqueId().toString()) == 1) {
                        return;
                    }
                    for (Integer i = Integer.valueOf(0); i.intValue() < amount; i = Integer.valueOf(i.intValue() + 1)) {
                        Location loc = p.getLocation().add(rdmDouble(Integer.valueOf(horizontal * -1), Integer.valueOf(horizontal)).doubleValue(), rdmDouble(Integer.valueOf(vertical * -1), Integer.valueOf(vertical)).doubleValue(),
                                rdmDouble(Integer.valueOf(horizontal * -1), Integer.valueOf(horizontal)).doubleValue());
                        if (loc.getWorld().getHighestBlockYAt(loc) < loc.getY()) {
                            sendVersionParticle(p, loc, Float.valueOf(speed));
                        }
                    }
                }
            }
        }.runTaskTimer(main.getInstance(), 0L, 1L);
    }

    private static void sendVersionParticle(Player p, Location loc, Float speed) {
        sendParticle(p, loc, speed, Integer.valueOf(1));
        return;
    }

    public static void call() { startManage(); }

}
