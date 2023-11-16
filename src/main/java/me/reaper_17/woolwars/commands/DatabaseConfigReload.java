package me.reaper_17.woolwars.commands;

import me.reaper_17.woolwars.data.server.DatabaseConfigurator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DatabaseConfigReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        DatabaseConfigurator.reload();

        return true;
    }
}
