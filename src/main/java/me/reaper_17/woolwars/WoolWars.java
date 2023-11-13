package me.reaper_17.woolwars;

import lombok.Getter;
import me.reaper_17.woolwars.events.BasicEvents;
import me.reaper_17.woolwars.events.JoinScoreShowEvent;
import me.reaper_17.woolwars.managers.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class WoolWars extends JavaPlugin {

    @Getter
    public static WoolWars instance;
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        registerEvents();
        initiateManagers();
    }


    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    private void initiateManagers() {
        new CommandManager(this);
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new JoinScoreShowEvent(this), this);
        getServer().getPluginManager().registerEvents(new BasicEvents(this), this);
    }

}
