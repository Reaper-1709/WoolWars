package me.reaper_17.woolwars.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Collection;

public class Kits {
    public static Collection<ArrayList<ItemStack>> kits = new ArrayList<>();

    public static ArrayList<ItemStack> tank = new ArrayList<>();
    public static ArrayList<ItemStack> assault = new ArrayList<>();
    public static ArrayList<ItemStack> archer = new ArrayList<>();
    public static ArrayList<ItemStack> swordsman = new ArrayList<>();
    public static ArrayList<ItemStack> golem = new ArrayList<>();
    public static ArrayList<ItemStack> engineer = new ArrayList<>();

    public static void initializeKits(){
        initKits(tank, assault, archer, swordsman, golem, engineer);
    }

    public static void addKitsToArray(){
        kits.add(tank);
        kits.add(assault);
        kits.add(archer);
        kits.add(swordsman);
        kits.add(golem);
        kits.add(engineer);
    }
    public static Collection<ArrayList<ItemStack>> getKits() {
        return kits;
    }

    public static ArrayList<ItemStack> getTank() {
        return tank;
    }

    public static ArrayList<ItemStack> getAssault() {
        return assault;
    }

    public static ArrayList<ItemStack> getArcher() {
        return archer;
    }

    public static ArrayList<ItemStack> getSwordsman() {
        return swordsman;
    }

    public static ArrayList<ItemStack> getGolem() {
        return golem;
    }

    public static ArrayList<ItemStack> getEngineer() {
        return engineer;
    }

    public static void initKits(ArrayList<ItemStack> tank, ArrayList<ItemStack> assault, ArrayList<ItemStack> archer, ArrayList<ItemStack> swordsman, ArrayList<ItemStack> golem, ArrayList<ItemStack> engineer){
        //tank setup
        tank.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        tank.add(new ItemStack(Material.LEATHER_LEGGINGS));
        tank.add(new ItemStack(Material.LEATHER_BOOTS));
        tank.add(new ItemStack(Material.WOOD_SWORD));

        //assault setup
        assault.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        assault.add(new ItemStack(Material.LEATHER_LEGGINGS));
        assault.add(new ItemStack(Material.WOOD_SWORD));

        ItemStack healPotion = new ItemStack(Material.POTION);
        Potion potion = new Potion(PotionType.INSTANT_HEAL);
        potion.setSplash(true);
        potion.setLevel(1);
        potion.setHasExtendedDuration(false);
        potion.apply(healPotion);

        assault.add(healPotion);
        assault.add(new ItemStack(Material.IRON_PICKAXE));
        assault.add(new ItemStack(Material.STONE_SPADE));
        assault.add(new ItemStack(Material.SHEARS));

        //archer setup
        archer.add(new ItemStack(Material.BOW));
        archer.add(new ItemStack(Material.ARROW, 6));
        archer.add(new ItemStack(Material.WOOD_AXE));
        archer.add(new ItemStack(Material.LEATHER_BOOTS));

        //swordsman setup
        swordsman.add(new ItemStack(Material.STONE_SWORD));
        swordsman.add(healPotion);
        swordsman.add(new ItemStack(Material.LEATHER_LEGGINGS));
        swordsman.add(new ItemStack(Material.LEATHER_BOOTS));

        //golem setup
        golem.add(new ItemStack(Material.STONE_SWORD));
        ItemStack golemBoots = new ItemStack(Material.GOLD_BOOTS);
        ItemMeta bootsMeta = golemBoots.getItemMeta();
        bootsMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 2, false);
        golemBoots.setItemMeta(bootsMeta);
        golem.add(golemBoots);

        //engineer setup
        engineer.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        engineer.add(new ItemStack(Material.WOOD_SWORD));
        engineer.add(new ItemStack(Material.BOW));
        engineer.add(new ItemStack(Material.ARROW, 4));
        engineer.add(new ItemStack(Material.SHEARS));
        engineer.add(new ItemStack(Material.STONE_PICKAXE));

        ItemStack absPotion = new ItemStack(Material.POTION, 2);
        Potion abs = new Potion(1);
        abs.setSplash(true);
        abs.setType(PotionType.getByEffect(PotionEffectType.ABSORPTION));
        abs.setLevel(1);
        abs.setHasExtendedDuration(true);
        abs.apply(absPotion);

        engineer.add(absPotion);
    }
}
