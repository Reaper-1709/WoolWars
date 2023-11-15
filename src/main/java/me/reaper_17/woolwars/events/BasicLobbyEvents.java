package me.reaper_17.woolwars.events;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.data.world.WoolWarsWorld;
import me.reaper_17.woolwars.enums.WorldType;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.Objects;

public class BasicLobbyEvents implements Listener {

    private WoolWars woolwars;
    World world;

    public BasicLobbyEvents(WoolWars woolwars) {
        this.woolwars = woolwars;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        world = event.getPlayer().getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        world = event.getPlayer().getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        world = event.getPlayer().getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        world = event.getPlayer().getWorld();
        Location location = player.getLocation();

        if (location.getY() <= 0 && Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY) {
            player.teleport(player.getWorld().getSpawnLocation());
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        world = event.getEntity().getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        world = event.getEntity().getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        world = event.getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        world = event.getPlayer().getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();

        player.setFoodLevel(20);
        player.setSaturation(20.0f);
        player.setHealth(20.0);

        world = player.getWorld();
        event.setCancelled(Objects.requireNonNull(WoolWarsWorld.findWoolWarsWorld(world)).getWorldType() == WorldType.LOBBY);
    }

}
