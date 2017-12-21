package de.jon4x.coinapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection con;

    public static void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + main.getHost() + "/" + main.getDatenbank() + "?Autoreconnect=true", main.getUser(), main.getPassword());
                System.out.println("MySQL wurde verbunden!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void disconnect() {
        if (isConnected()) {
            try {
                con.close();
                System.out.println("MySQL wurde getrennt!");
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
            con.prepareStatement("CREATE TABLE IF NOT EXISTS coinTable (uuid VARCHAR(100), coins INT(20))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
