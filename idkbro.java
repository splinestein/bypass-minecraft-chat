package me.jdavis.idkbro.idkbro;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.cacheddata.CachedMetaData;

public final class Idkbro extends JavaPlugin implements Listener {
    private LuckPerms luckPerms;

    //public Idkbro(LuckPerms lp) {
    //    this.luckPerms = lp;
    //}

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("My first plugin has started. v2");
        getServer().getPluginManager().registerEvents(this, this);
        this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        // RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        // LuckPerms api;
        // if (provider != null) {
        //     api = provider.getProvider();
        //     getServer().getPluginManager().registerEvents(new Idkbro(api), this);
        //}
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        System.out.println("Someone joined the server.");
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        System.out.println("Someone wrote something?.");
        event.setCancelled(true);

        Player player = (Player) event.getPlayer();

        CachedMetaData metaData = this.luckPerms.getPlayerAdapter(Player.class).getMetaData(player);

        // Get their prefix.
        String prefix = metaData.getPrefix();

        System.out.println("The prefix is: " + prefix);

        if (event.getPlayer().isOp()) {
            //getServer().broadcastMessage(ChatColor.RED + "[Owner] " + ChatColor.WHITE + event.getPlayer().getName() + ": " + event.getMessage());
            getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.WHITE + event.getPlayer().getName() + ": " + event.getMessage()));
        } else {
            getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.WHITE + event.getPlayer().getName() + ": " + event.getMessage()));
        }
    }
}

