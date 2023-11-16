package me.reaper_17.woolwars.managers;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.data.server.DatabaseConfigurator;

public class DatabaseConfigManager {
    public DatabaseConfigManager(){
        setup();
    }

    public void setup(){
        DatabaseConfigurator.setup();
        DatabaseConfigurator.getInstance().addDefault("jdbc-url", "");
        DatabaseConfigurator.getInstance().addDefault("username", "");
        DatabaseConfigurator.getInstance().addDefault("password", "");
        DatabaseConfigurator.getInstance().options().copyDefaults(true);
        DatabaseConfigurator.save();
    }
}
