package me.reaper_17.woolwars;

import lombok.Getter;
import me.reaper_17.woolwars.data.world.WoolWarsWorld;
import me.reaper_17.woolwars.events.BasicLobbyEvents;
import me.reaper_17.woolwars.events.JoinScoreShowEvent;
import me.reaper_17.woolwars.managers.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;

public final class WoolWars extends JavaPlugin {

    @Getter
    public static WoolWars instance;

    @Getter
    public static Collection<WoolWarsWorld> woolWarsWorlds = new ArrayList<>();

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
        getServer().getPluginManager().registerEvents(new BasicLobbyEvents(this), this);
    }

    public String persistWoolWarsWorldsToString(Collection<WoolWarsWorld> worlds){
        StringBuilder builder = new StringBuilder("{");
        for (WoolWarsWorld world : worlds){
            if (!worlds.isEmpty()) {
                builder.append(world.getBukkitWorld().getName());
                builder.append(":");
                builder.append(world.getWorldType().toString());
                builder.append(", ");
            }
            else {
                builder.append("{}");
            }
        }
        return builder.toString();
    }
}
