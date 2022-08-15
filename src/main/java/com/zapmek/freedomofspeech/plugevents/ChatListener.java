package com.zapmek.freedomofspeech.plugevents;

import com.zapmek.freedomofspeech.FreedomOfSpeech;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;

import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    private final LuckPerms luckPerms;

    public ChatListener(FreedomOfSpeech plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.luckPerms = Bukkit.getServicesManager().load(LuckPerms.class);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        CachedMetaData metaData = this.luckPerms.getPlayerAdapter(Player.class).getMetaData(player);
        String prefix = metaData.getPrefix();
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.WHITE + player.getName() + ": " + event.getMessage()));
    }
}
