package me.reaper_17.woolwars.managers;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.data.world.WoolWarsWorld;
import me.reaper_17.woolwars.enums.WorldType;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.sql.*;

public class WorldDatabaseManager {
    public static void uploadToDatabase(String jdbcUrl, String username, String password){
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            for (WoolWarsWorld world : WoolWars.getWoolWarsWorlds()){
                String name = world.getBukkitWorld().getName();
                String type = world.getWorldType().toString();
                String insertQuery = "INSERT INTO world (name, type) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                    statement.setString(1, name);
                    statement.setString(2, type);

                    statement.executeUpdate();
                }
            }
            WoolWars.getWoolWarsWorlds().clear();
        }
        catch (SQLException e){
            Bukkit.getLogger().severe("Error occurred: " + e.getMessage());
        }
    }

    public static void downloadFromDatabase(String jdbcUrl,String username, String password){
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            String selectQuery = "SELECT * FROM world";
            try (PreparedStatement statement = connection.prepareStatement(selectQuery)){
                ResultSet set = statement.executeQuery();
                while (set.next()){
                    World bukkitWorld = Bukkit.getWorld(set.getString("name"));
                    WorldType type = WorldType.valueOf(set.getString("type"));

                    WoolWarsWorld world = new WoolWarsWorld(bukkitWorld, type);
                    WoolWars.getWoolWarsWorlds().add(world);
                }
            }
        }
        catch (SQLException e){
            Bukkit.getLogger().severe("Error occurred: " + e.getMessage());
        }
    }
}
