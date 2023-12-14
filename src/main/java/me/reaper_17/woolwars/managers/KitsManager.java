package me.reaper_17.woolwars.managers;

import me.reaper_17.woolwars.WoolWars;
import me.reaper_17.woolwars.kits.Kits;

public class KitsManager {
    public KitsManager() {
        setup();
    }

    public void setup(){
        Kits.initializeKits();
        Kits.addKitsToArray();
    }
}
