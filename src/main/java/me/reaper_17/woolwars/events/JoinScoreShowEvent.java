package me.reaper_17.woolwars.events;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.scoreboards.LobbyScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinScoreShowEvent implements Listener {

    private WoolWars woolwars;

    public JoinScoreShowEvent(WoolWars woolwars) {
        this.woolwars = woolwars;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        LobbyScoreboard.showLobbyScoreboard(p);
    }
}
