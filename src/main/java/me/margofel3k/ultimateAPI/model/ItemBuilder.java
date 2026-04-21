package me.margofel3k.ultimateAPI.model;

import me.margofel3k.ultimateAPI.annotations.Event;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Event
public class ItemBuilder implements Listener {

    //TODO wjebać każde meta bzdety

    protected ItemStack item;
    private Consumer<InventoryClickEvent> callback;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        if (callback == null) return;
        if (event.getClickedInventory() == null) return;
        if (event.getCurrentItem() == null) return;
        if (!item.isSimilar(event.getCurrentItem())) return;
        callback.accept(event);
    }

    public void onClick(Consumer<InventoryClickEvent> callback) {
        this.callback = callback;
    }

    public ItemBuilder setDisplayName(String name) {
        ItemMeta meta = item.getItemMeta();
        meta.customName(Component.text(name));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta meta = item.getItemMeta();
        List<Component> loreComponents = new ArrayList<>();
        lore.forEach(component -> loreComponents.add(Component.text(component)));
        meta.lore(loreComponents);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setCustomModelData(int customModelData) {
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(customModelData);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setMaxStackSize(int maxStackSize) {
        ItemMeta meta = item.getItemMeta();
        meta.setMaxStackSize(maxStackSize);
        item.setItemMeta(meta);
        return this;
    }



    public ItemStack build() {
        return item;
    }
}
