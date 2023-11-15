package me.reaper_17.woolwars.managers;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.data.player.WoolWarsPlayer;
import org.bukkit.Bukkit;

import java.sql.*;

public class PlayerDatabaseManager {
    public static void uploadToDatabase(String jdbcURL, String username, String password){
        try(Connection connection = DriverManager.getConnection(jdbcURL, username, password)){
            for (WoolWarsPlayer player : WoolWars.getWoolWarsPlayers()){
                String name = player.getPlayer().getName();
                int level = player.getLevel();
                int currentXp = player.getCurrentXp();
                int finalXp = player.getFinalXp();
                int wool = player.getWool();
                int layers = player.getLayers();
                int wins = player.getWins();
                int kills = player.getKills();
                int deaths = player.getDeaths();
                boolean ignoreLeaderboard = player.isIgnoreLeaderboard();
                String insertQuery = "INSERT INTO player (name, level, currentxp, finalxp, wool, layers, wins, kills, deaths, ignore-leaderboard) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(insertQuery)){
                    statement.setString(1, name);
                    statement.setInt(2, level);
                    statement.setInt(3, currentXp);
                    statement.setInt(4, finalXp);
                    statement.setInt(5, wool);
                    statement.setInt(6, layers);
                    statement.setInt(7, wins);
                    statement.setInt(8, kills);
                    statement.setInt(9, deaths);
                    statement.setBoolean(10, ignoreLeaderboard);

                    statement.executeUpdate();
                }
            }
            WoolWars.getWoolWarsPlayers().clear();
        }
        catch (SQLException e){
            Bukkit.getLogger().severe("Error occurred: " + e.getMessage());
        }
    }

    public static void downloadFromDatabase(String jdbcUrl, String username, String password){
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            String selectQuery = "SELECT * FROM player";

            try (PreparedStatement statement = connection.prepareStatement(selectQuery)){
                ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()){
                        String name = resultSet.getString("name");
                        int level = resultSet.getInt("level");
                        int currentXp = resultSet.getInt("currentxp");
                        int finalXP = resultSet.getInt("finalxp");
                        int wool = resultSet.getInt("wool");
                        int layers = resultSet.getInt("layers");
                        int wins = resultSet.getInt("wins");
                        int kills = resultSet.getInt("kills");
                        int deaths = resultSet.getInt("deaths");
                        boolean ignoreLeaderboard = resultSet.getBoolean("ignore-leaderboard");

                        WoolWarsPlayer player = new WoolWarsPlayer(Bukkit.getPlayer(name), level, currentXp, finalXP, wool, layers, wins, kills, deaths, ignoreLeaderboard);
                        WoolWars.getWoolWarsPlayers().add(player);
                    }
            }
        }
        catch (SQLException e){
            Bukkit.getLogger().severe("Error occurred: " + e.getMessage());
        }
    }
}
