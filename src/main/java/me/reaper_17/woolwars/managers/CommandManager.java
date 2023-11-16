package me.reaper_17.woolwars.managers;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.commands.DatabaseConfigReload;

public class CommandManager {

    public CommandManager() {
        registerCommands();
    }


    public void registerCommands() {
        WoolWars.getInstance().getCommand("reloadDatabaseConfig").setExecutor(new DatabaseConfigReload());
    }

}
