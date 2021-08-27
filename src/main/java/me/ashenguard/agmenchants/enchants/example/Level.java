package me.ashenguard.agmenchants.enchants.example;

import me.ashenguard.api.placeholder.Placeholder;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * A simple class to keep track of enchantment features and configurations
 */
public class Level {
    public final int level;
    public final double chance;

    public Level(int level, double chance) {
        this.level = level;
        this.chance = chance;
    }

    public Level(int level, @Nullable ConfigurationSection section) {
        this(level, section != null ? section.getDouble("Chance") : 5);
    }

    public List<Placeholder> getPlaceholders() {
        return Collections.singletonList(new Placeholder("Chance", (player, s) -> String.valueOf(chance)));
    }
}
