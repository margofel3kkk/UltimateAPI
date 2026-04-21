package me.margofel3k.ultimateAPI.utils;

import me.margofel3k.ultimateAPI.UltimateAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.TimeUnit;

public class TaskUtil {

    public static BukkitTask runSyncTimer(Runnable runnable, TimeUnit timeUnit, double time) {
        double ticks = 20;
        switch (timeUnit) {
            case DAYS -> ticks  = (((20 * 60) * 60) * 24) * time;
            case HOURS -> ticks  = ((20 * 60) * 60) * time;
            case MINUTES -> ticks  = (20 * 60) * time;
            case MILLISECONDS -> ticks = time / 50.0;
            default -> ticks = time * 20;
        }
        return Bukkit.getScheduler().runTaskTimer(UltimateAPI.getInstance(), runnable, 0L, (long) ticks);
    }

    public static BukkitTask runAsyncTimer(Runnable runnable, TimeUnit timeUnit, double time) {
        double ticks = 20;
        switch (timeUnit) {
            case DAYS -> ticks  = (((20 * 60) * 60) * 24) * time;
            case HOURS -> ticks  = ((20 * 60) * 60) * time;
            case MINUTES -> ticks  = (20 * 60) * time;
            case MILLISECONDS -> ticks = time / 50.0;
            default -> ticks = time * 20;
        }
        return Bukkit.getScheduler().runTaskTimerAsynchronously(UltimateAPI.getInstance(), runnable, 0L, (long) ticks);
    }

    public static BukkitTask runSyncLater(Runnable runnable, TimeUnit timeUnit, double time) {
        double ticks = 20;
        switch (timeUnit) {
            case DAYS -> ticks  = (((20 * 60) * 60) * 24) * time;
            case HOURS -> ticks  = ((20 * 60) * 60) * time;
            case MINUTES -> ticks  = (20 * 60) * time;
            case MILLISECONDS -> ticks = time / 50.0;
            default -> ticks = time * 20;
        }
        return Bukkit.getScheduler().runTaskLater(UltimateAPI.getInstance(), runnable, (long) ticks);
    }

    public static BukkitTask runAsyncLater(Runnable runnable, TimeUnit timeUnit, double time) {
        double ticks = 20;
        switch (timeUnit) {
            case DAYS -> ticks  = (((20 * 60) * 60) * 24) * time;
            case HOURS -> ticks  = ((20 * 60) * 60) * time;
            case MINUTES -> ticks  = (20 * 60) * time;
            case MILLISECONDS -> ticks = time / 50.0;
            default -> ticks = time * 20;
        }
        return Bukkit.getScheduler().runTaskLaterAsynchronously(UltimateAPI.getInstance(), runnable, (long) ticks);
    }

    public static BukkitTask runSync(Runnable runnable) {
        return Bukkit.getScheduler().runTask(UltimateAPI.getInstance(), runnable);
    }

    public static BukkitTask runAsync(Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(UltimateAPI.getInstance(), runnable);
    }


}
