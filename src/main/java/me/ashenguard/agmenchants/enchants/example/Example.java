package me.ashenguard.agmenchants.enchants.example;

import me.ashenguard.agmenchants.enchants.CustomEnchant;
import me.ashenguard.api.placeholder.Placeholder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.*;

public class Example extends CustomEnchant {
    public Example(File JAR) {
        super(JAR, "ID", "1.0.0");

        for (int i = 1; i <= getMaxLevel(); i++)
            levels.put(i, new Level(i, config.getConfigurationSection("Levels." + i)));
    }

    /**
     * Returns all possible items that will trigger this enchantment.
     * For example for a Combat enchantment like Toxic, Main hand is only item that will trigger the enchantment.
     *
     * @param entity that enchantment should be get from
     * @return all possible items that will trigger this enchantment.
     */
    @Override public List<ItemStack> getItemStacks(Entity entity) {
        if (!(entity instanceof LivingEntity)) return new ArrayList<>();
        LivingEntity target = (LivingEntity) entity;

        return Arrays.asList(target.getEquipment().getArmorContents());
    }
    /**
     * This method will be called when the enchantment has been added to an item.
     * @param itemStack the item stack enchantment is going to be added to
     * @param i the enchantment level
     */
    @Override public void onEnchanting(ItemStack itemStack, int i) {}

    /**
     * This method will be called when an enchantment has been removed from an item
     * @param itemStack the item stack enchantment is going to be removed from
     * @param i the enchantment level
     */
    @Override public void onDisenchanting(ItemStack itemStack, int i) {}

    /**
     * A method that will replace placeholders in lore. It's recommended to have a class like {@link Level} to manage them and link them as follow.
     * @param i the enchantment level
     * @return all placeholders for the lore
     */
    @Override public List<Placeholder> getPlaceholders(int i) {
        return getLevel(i).getPlaceholders();
    }

    /**
     * A basic storage for levels of this enchantment. {@link #getLevel(int)} will return the {@link Level}
     */
    LinkedHashMap<Integer, Level> levels = new LinkedHashMap<>();
    protected Level getLevel(int level) {
        return levels.getOrDefault(level, null);
    }

    /* Events and tasks - All stuff which make this enchantment */
}
