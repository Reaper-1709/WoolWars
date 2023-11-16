package me.reaper_17.woolwars.scoreboards;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.data.player.WoolWarsPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class LobbyScoreboard {
    private static int counter = 0;
    public static void showLobbyScoreboard(Player p){

        WoolWarsPlayer player = WoolWarsPlayer.findWoolWarPlayer(p);

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard lobbyScoreboard = scoreboardManager.getNewScoreboard();
        Objective title = lobbyScoreboard.registerNewObjective("wool wars", "dummy");

        title.setDisplayName(ChatColor.BOLD + ("       " + ChatColor.YELLOW + "WOOL  WARS       "));
        String[] animates = new String[]{
                ChatColor.BOLD + ("       " + ChatColor.GOLD + "W" + ChatColor.YELLOW + "OOL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "W" + ChatColor.GOLD + "O" + ChatColor.YELLOW + "OL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WO" + ChatColor.GOLD + "O" + ChatColor.YELLOW + "L  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOO" + ChatColor.GOLD + "L  " + ChatColor.YELLOW + "WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  " + ChatColor.GOLD + "W" + ChatColor.YELLOW + "ARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  W" + ChatColor.GOLD + "A" + ChatColor.YELLOW + "RS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WA" + ChatColor.GOLD + "R" + ChatColor.YELLOW + "S       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WAR" + ChatColor.GOLD + "S" + ChatColor.YELLOW + "       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WARS" + ChatColor.YELLOW + "       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.YELLOW + "WOOL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WARS       "),
                ChatColor.BOLD + ("       " + ChatColor.WHITE + "WOOL  WARS       ")
        };

        new BukkitRunnable(){
            @Override
            public void run(){
                if (p.isOnline()) {
                    if (counter < animates.length) {
                        title.setDisplayName(animates[counter]);
                        counter++;
                    } else {
                        counter = 0;
                    }
                }
                else {
                    counter = 0;
                    cancel();
                }
            }
        }.runTaskTimer(WoolWars.getInstance(), 0, 5);


        title.setDisplaySlot(DisplaySlot.SIDEBAR);

        //11 scores including blanks

        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone(ZoneId.systemDefault()));

        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String year = String.valueOf((calendar.get(Calendar.YEAR) - 2000));

        Score dateLobbyScore = title.getScore(ChatColor.GRAY + month + "/" + day + "/" + year + "  " + ChatColor.DARK_GRAY + p.getWorld().getName());
        dateLobbyScore.setScore(11);

        Score blank1 = title.getScore("    ");
        blank1.setScore(10);

        int level = p.getLevel();
        Score levelScore = title.getScore(ChatColor.WHITE + "Level: " + ChatColor.GRAY + "[" + level + "❤]");
        levelScore.setScore(9);

        Score blank2 = title.getScore("   ");
        blank2.setScore(8);

        String currentXp = simplifyCurrentXp(player.getCurrentXp());
        String finalXp = simplifyFinalXp(player.getFinalXp());
        Score progressScore = title.getScore(ChatColor.WHITE + "Progress: " + ChatColor.AQUA + currentXp + ChatColor.GRAY + "/" + ChatColor.GREEN + finalXp);
        progressScore.setScore(7);
        float currentXpNumber;
        float finalXpNumber;

        if (currentXp.contains("k")){
            currentXp = currentXp.replace("k", "");
            currentXpNumber = Float.parseFloat(currentXp) * 1000;
        }
        else {
            currentXpNumber = Float.parseFloat(currentXp);
        }

        if (finalXp.contains("k")){
            finalXp = finalXp.replace("k", "");
            finalXpNumber = Float.parseFloat(finalXp) * 1000;
        }
        else {
            finalXpNumber = Float.parseFloat(finalXp);
        }

        float percentProgress = (float) Math.floor((currentXpNumber/finalXpNumber) * 10);
        Score progressBar = title.getScore(generatePointString((int) percentProgress));
        progressBar.setScore(6);

        Score blank3 = title.getScore("  ");
        blank3.setScore(5);

        int wool = player.getWool();
        Score woolScore = title.getScore(ChatColor.WHITE + "Wool: " + ChatColor.GOLD + wool);
        woolScore.setScore(4);

        int layers = player.getLayers();
        Score layerScore = title.getScore(ChatColor.WHITE + "Layers: " + ChatColor.GREEN + layers);
        layerScore.setScore(3);

        Score blank4 = title.getScore(" ");
        blank4.setScore(2);

        Score ip = title.getScore(ChatColor.YELLOW + "mc.gamepixel.fun");
        ip.setScore(1);

        p.setScoreboard(lobbyScoreboard);
    }

    public static String generatePointString(int x) {
        x = Math.max(1, Math.min(10, x));
        int totalPoints = 10;
        StringBuilder pointString = new StringBuilder("[");

        // Append blue points
        for (int i = 0; i < x; i++) {
            pointString.append(ChatColor.AQUA + "■");
        }

        // Append gray points
        for (int i = x; i < totalPoints; i++) {
            pointString.append(ChatColor.GRAY + "■");
        }
        pointString.append("]");

        return pointString.toString();
    }

    public static String simplifyCurrentXp(int currentXp){
        if (currentXp > 1000){
            return (currentXp / 1000) + "k";
        }
        return String.valueOf(currentXp);
    }

    public static String simplifyFinalXp(int finalXp){
        if (finalXp > 1000){
            return (finalXp / 1000) + "k";
        }
        return String.valueOf(finalXp);
    }
}
