package de.jon4x.lobby.api;

import de.jon4x.lobby.sql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JumppadAPI {

    public static int getState(String uuid) {

        try {
            PreparedStatement st = MySQL.con.prepareStatement("SELECT state FROM padTable WHERE uuid = ?");
            st.setString(1, uuid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("state");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public static void setState(String uuid) {
        if (getState(uuid) == -1) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO padTable (uuid,state) VALUES (?, ?)");
                st.setString(1, uuid);
                st.setInt(2, 1);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Aktivieren
        else if (getState(uuid) == 0) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("UPDATE padTable SET state = ? WHERE uuid = ?");
                st.setInt(1, 1);
                st.setString(2, uuid);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Deaktiviern
        else {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("UPDATE padTable SET state = ? WHERE uuid = ?");
                st.setInt(1, 0);
                st.setString(2, uuid);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
