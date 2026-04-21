package me.margofel3k.ultimateAPI.events;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
public class PlayerDamageByEntity extends Event implements Cancellable {

    final Player player;
    final Entity entity;

    public PlayerDamageByEntity(Player player, Entity entity) {
        this.player = player;
        this.entity = entity;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {

    }
}
