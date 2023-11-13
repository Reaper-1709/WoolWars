package me.reaper_17.woolwars;

import me.reaper_17.woolwars.events.JoinScoreShowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WoolWars extends JavaPlugin {
    private static WoolWars instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinScoreShowEvent(), this);
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static WoolWars getInstance() {
        return instance;
    }
}
