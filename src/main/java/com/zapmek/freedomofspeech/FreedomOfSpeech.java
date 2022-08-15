package com.zapmek.freedomofspeech;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.zapmek.freedomofspeech.plugevents.ChatListener;

public final class FreedomOfSpeech extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("FreedomOfSpeech plugin loaded.");
        new ChatListener(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("FreedomOfSpeech plugin was shutdown.");
    }
}
