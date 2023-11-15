package me.reaper_17.woolwars;

import lombok.Getter;
import me.reaper_17.woolwars.data.player.WoolWarsPlayer;
import me.reaper_17.woolwars.data.world.WoolWarsWorld;
import me.reaper_17.woolwars.events.BasicLobbyEvents;
import me.reaper_17.woolwars.events.JoinScoreShowEvent;
import me.reaper_17.woolwars.managers.CommandManager;
import me.reaper_17.woolwars.managers.PlayerDatabaseManager;
import me.reaper_17.woolwars.managers.WorldDatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;

public final class WoolWars extends JavaPlugin {

    @Getter
    public static WoolWars instance;

    @Getter
    public static Collection<WoolWarsWorld> woolWarsWorlds = new ArrayList<>();

    //there is no need to persist this woolWarsPlayers list as the values will be directly stored to db
    @Getter
    public static Collection<WoolWarsPlayer> woolWarsPlayers = new ArrayList<>();

    public void onEnable() {
        // Plugin startup logic
        instance = this;
        registerEvents();
        initiateManagers();
        PlayerDatabaseManager.downloadFromDatabase("", "", ""); //Replace with your own values
        WorldDatabaseManager.downloadFromDatabase("", "", "");
    }


    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        PlayerDatabaseManager.uploadToDatabase("", "", ""); //Replace with your own values
        WorldDatabaseManager.uploadToDatabase("", "", "");
    }

    private void initiateManagers() {
        new CommandManager(this);
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new JoinScoreShowEvent(this), this);
        getServer().getPluginManager().registerEvents(new BasicLobbyEvents(this), this);
    }
}
