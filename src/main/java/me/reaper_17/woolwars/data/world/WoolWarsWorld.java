package me.reaper_17.woolwars.data.world;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.enums.WorldType;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WoolWarsWorld {
    private World bukkitWorld;
    private WorldType worldType;

    public WoolWarsWorld(World bukkitWorld, WorldType worldType){
        this.bukkitWorld = bukkitWorld;
        this. worldType = worldType;
    }

    public World getBukkitWorld() {
        return bukkitWorld;
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public void setBukkitWorld(World bukkitWorld) {
        this.bukkitWorld = bukkitWorld;
    }

    public void setWorldType(WorldType worldType) {
        this.worldType = worldType;
    }

    public static WoolWarsWorld findWoolWarsWorld(World world){
        for (WoolWarsWorld woolWarsWorld : WoolWars.getWoolWarsWorlds()){
            if (woolWarsWorld.getBukkitWorld().equals(world)){
                return woolWarsWorld;
            }
        }
        Bukkit.getLogger().severe(world.getName() + " is not a valid WoolWarsWorld. Contact developer or admin to fix the issue.");
        return null;
    }
}
