package de.jon4x.lobby.sql;

import de.jon4x.lobby.main;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection con;

    public static void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + main.getHost() + "/" + main.getDatenbank() + "?Autoreconnect=true", main.getUser(), main.getPassword());
                createTable();
                Bukkit.getConsoleSender().sendMessage(main.getPrefix() + "§aMySQL wurde erfolgreich verbunden!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void disconnect() {
        if (isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage(main.getPrefix() + "§cMySQL wurde erfolgreich getrennt!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        return (con != null);
    }

    public static void createTable() {
        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS jumpTable (uuid VARCHAR(100), state INT(20))").executeUpdate();
            con.prepareStatement("CREATE TABLE IF NOT EXISTS padTable (uuid VARCHAR(100), state INT(20))").executeUpdate();
            con.prepareStatement("CREATE TABLE IF NOT EXISTS snowTable (uuid VARCHAR(100), state INT(20))").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
