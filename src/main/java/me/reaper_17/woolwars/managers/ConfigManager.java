package me.reaper_17.woolwars.managers;

import me.reaper_17.woolwars.WoolWars;

public class ConfigManager {
    public WoolWars woolWars;
    public ConfigManager(WoolWars woolWars) {
        this.woolWars = woolWars;
        setup(this.woolWars);
    }

    public static void setup(WoolWars instance){
        instance.getConfig().options().copyDefaults();
        instance.saveDefaultConfig();
    }
}
