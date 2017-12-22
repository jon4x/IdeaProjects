package de.jon4x.coinapi;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinAPI {

    public static int getCoins(String uuid) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement("SELECT coins FROM coinTable WHERE uuid = ?");
            st.setString(1, uuid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("coins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void setCoins(String uuid, int coins) {
        if (getCoins(uuid) == -1) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO coinTable (uuid,coins) VALUES (?, ?)");
                st.setString(1, uuid);
                st.setInt(2, coins);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("UPDATE coinTable SET coins = ? WHERE uuid = ?");
                st.setInt(1, coins);
                st.setString(2, uuid);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addCoins(String uuid, int coins) {
        if (getCoins(uuid) != -1) {
            setCoins(uuid, getCoins(uuid) + coins);
        } else {
            setCoins(uuid, getCoins(uuid) + coins + 1);
        }
    }

    public static void removeCoins(String uuid, int coins) {
        setCoins(uuid, getCoins(uuid) - coins);
    }

}
