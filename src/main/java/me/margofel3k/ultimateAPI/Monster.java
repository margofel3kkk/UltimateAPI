package me.margofel3k.ultimateAPI;

import me.margofel3k.ultimateAPI.model.MonsterBuilder;
import org.bukkit.entity.EntityType;

public class Monster extends MonsterBuilder {

    public Monster() {
        super(EntityType.ZOMBIE);
    }
}
