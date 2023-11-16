package me.reaper_17.woolwars.data.server;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DatabaseConfigurator {
    private static File file;
    private static FileConfiguration configFile;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("WoolWars").getDataFolder(), "DatabaseConfig.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e){
                 Bukkit.getLogger().severe("Error occurred: " + e.getMessage());
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getInstance(){
        return configFile;
    }

    public static void save(){
        try {
            configFile.save(file);
        }
        catch (IOException e){
            Bukkit.getLogger().severe("Error occurred: " + e.getMessage());
        }
    }

    public static void reload(){
        configFile = YamlConfiguration.loadConfiguration(file);
    }
}
