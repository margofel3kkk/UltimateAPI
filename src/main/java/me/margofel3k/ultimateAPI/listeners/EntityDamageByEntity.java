package me.margofel3k.ultimateAPI.listeners;

import me.margofel3k.ultimateAPI.annotations.Event;
import me.margofel3k.ultimateAPI.events.PlayerDamageByEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@Event
public class EntityDamageByEntity implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        PlayerDamageByEntity customEvent = new PlayerDamageByEntity(player, event.getEntity());
        Bukkit.getServer().getPluginManager().callEvent(customEvent);
        if (customEvent.isCancelled()) {
            event.setCancelled(true);
        }
    }
}
