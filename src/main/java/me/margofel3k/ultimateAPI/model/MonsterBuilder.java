package me.margofel3k.ultimateAPI.model;

import lombok.Getter;
import lombok.Setter;
import me.margofel3k.ultimateAPI.annotations.Event;
import me.margofel3k.ultimateAPI.events.PlayerDamageByEntity;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

@Event
public class MonsterBuilder implements Listener {

    protected EntityType entityType;
    private final UUID uuid;
    @Setter @Getter private Double damage;
    @Setter @Getter private Double health;
    @Setter @Getter private boolean invisible;
    @Setter @Getter private ItemStack helmet;
    @Setter @Getter private Integer helmetDropChance;
    @Setter @Getter private ItemStack chestplate;
    @Setter @Getter private Integer chestplateDropChance;
    @Setter @Getter private ItemStack leggings;
    @Setter @Getter private Integer leggingsDropChance;
    @Setter @Getter private ItemStack boots;
    @Setter @Getter private Integer bootsDropChance;

    public MonsterBuilder(EntityType entityType) {
        this.entityType = entityType;
        uuid = UUID.randomUUID();
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onDamagePlayer(PlayerDamageByEntity event) {
        if (!event.getEntity().getPersistentDataContainer().get(new NamespacedKey("ultimateapi", "customMonster"), PersistentDataType.STRING).equalsIgnoreCase(uuid.toString())) return;
        event.getPlayer().damage(damage);

    }

    public void spawn(Location location) {
        Monster entity = (Monster) location.getWorld().spawnEntity(location, entityType);
        entity.getPersistentDataContainer().set(new NamespacedKey("ultimateapi", "customMonster"), PersistentDataType.STRING, uuid.toString());
        entity.setInvisible(invisible);
        if (helmet != null) entity.getEquipment().setHelmet(helmet);
        if (helmetDropChance != null) entity.getEquipment().setHelmetDropChance(helmetDropChance);
        if (chestplate != null) entity.getEquipment().setChestplate(chestplate);
        if (chestplateDropChance != null) entity.getEquipment().setChestplateDropChance(chestplateDropChance);
        if (leggings != null) entity.getEquipment().setLeggings(leggings);
        if (leggingsDropChance != null) entity.getEquipment().setLeggingsDropChance(leggingsDropChance);
        if (boots != null) entity.getEquipment().setBoots(boots);
        if (bootsDropChance != null) entity.getEquipment().setBootsDropChance(bootsDropChance);
        if (health != null) entity.setHealth(health);

    }

}
