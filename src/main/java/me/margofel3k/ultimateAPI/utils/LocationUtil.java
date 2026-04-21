package me.margofel3k.ultimateAPI.utils;

import org.bukkit.HeightMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.concurrent.ThreadLocalRandom;

public class LocationUtil {

    /**
     * If there's no block it's return 0
     */
    public static int getHighestBlock(Location location, Material material) {
        int x = location.getBlockX();
        int z = location.getBlockZ();
        int y = 0;
        for (int newY = 360; newY > -60; newY--) {
            if (location.getWorld().getBlockAt(x, y, z).getType() == material) {
                y = newY;
                break;
            }
        }
        return y;
    }

    /**
     * If there's no block it's return 0
     */
    public static int getHighestBlock(int x, int z, World world, Material material) {
        int y = 0;
        for (int newY = 360; newY > -60; newY--) {
            if (world.getBlockAt(x, y, z).getType() == material) {
                y = newY;
                break;
            }
        }
        return y;
    }


    public static Location getRandomLocation(Location center, int radius) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int x = random.nextInt(center.getBlockX() - radius, center.getBlockX() + radius + 1);
        int z = random.nextInt(center.getBlockZ() - radius, center.getBlockZ() + radius + 1);
        int y = center.getWorld().getHighestBlockYAt(x, z);
        return new Location(center.getWorld(), x, y, z);
    }



}
