package me.reaper_17.woolwars.data.player;

import org.bukkit.entity.Player;

public class WoolWarsPlayer {
    private Player player;
    private int level;
    private int currentXp;
    private int finalXp;
    private int wool;
    private int layers;
    private int wins;
    private int kills;
    private int deaths;
    private boolean ignoreLeaderboard;

    public WoolWarsPlayer(Player player, int level, int currentXp, int finalXp, int wool, int layers, int wins, int kills, int deaths, boolean ignoreLeaderboard) {
        this.player = player;
        this.level = level;
        this.currentXp = currentXp;
        this.finalXp = finalXp;
        this.wool = wool;
        this.layers = layers;
        this.wins = wins;
        this.kills = kills;
        this.deaths = deaths;
        this.ignoreLeaderboard = ignoreLeaderboard;
    }

    public Player getPlayer() {
        return player;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public int getFinalXp() {
        return finalXp;
    }

    public int getWool() {
        return wool;
    }

    public int getLayers() {
        return layers;
    }

    public int getWins() {
        return wins;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public boolean isIgnoreLeaderboard() {
        return ignoreLeaderboard;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public void setFinalXp(int finalXp) {
        this.finalXp = finalXp;
    }

    public void setWool(int wool) {
        this.wool = wool;
    }

    public void setLayers(int layers) {
        this.layers = layers;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setIgnoreLeaderboard(boolean ignoreLeaderboard) {
        this.ignoreLeaderboard = ignoreLeaderboard;
    }

}
