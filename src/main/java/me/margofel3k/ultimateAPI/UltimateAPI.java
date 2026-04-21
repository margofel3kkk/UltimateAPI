package me.margofel3k.ultimateAPI;

import lombok.Getter;
import me.margofel3k.ultimateAPI.annotations.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

public final class UltimateAPI extends JavaPlugin {

    @Getter public static UltimateAPI instance;

    @Override
    public void onEnable() {
        instance = this;
            registerListeners();
    }

    @Override
    public void onDisable() {
    }

    /**
    Class need to be static
    and have public constructor without argument
     */
    private void registerListeners(){
        for (Class<?> clazz : this.getClass().getDeclaredClasses()) {
            if (clazz.isAnnotationPresent(Event.class)) {
                if (Listener.class.isAssignableFrom(clazz)) {
                    try {
                        Listener listenerInstance = (Listener) clazz.getDeclaredConstructor().newInstance();
                        getServer().getPluginManager().registerEvents(listenerInstance, this);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                             InvocationTargetException ignored) {}
                }
            }
        }
    }

}
