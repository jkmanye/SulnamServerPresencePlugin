package com.schoolvote.MCPlugin.Sulnam.SulnamServerPresencePlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onDisable() {
        URL url;
        HttpURLConnection checkIn = null;
        try {
            url = new URL("https://sulnamserverpresence-db.herokuapp.com/toggle/" +  Bukkit.getIp());
            checkIn = (HttpURLConnection) url.openConnection();

            checkIn.setRequestMethod("POST");
            checkIn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            checkIn.setDoOutput(true);

            System.out.println(checkIn.getResponseCode());
            checkIn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        URL url;
        HttpURLConnection checkIn = null;
        try {
            url = new URL("https://sulnamserverpresence-db.herokuapp.com/toggle/"  + Bukkit.getIp());
            checkIn = (HttpURLConnection) url.openConnection();

            checkIn.setRequestMethod("POST");
            checkIn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            checkIn.setDoOutput(true);

            System.out.println(checkIn.getResponseCode());
            checkIn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        URL url;
        HttpURLConnection checkIn = null;
        try {
            url = new URL("https://sulnamserverpresence-db.herokuapp.com/addplayer/" + event.getPlayer().getName() + "/" + Bukkit.getIp());
            checkIn = (HttpURLConnection) url.openConnection();

            checkIn.setRequestMethod("POST");
            checkIn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            checkIn.setDoOutput(true);

            System.out.println(checkIn.getResponseCode());
            checkIn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        URL url;
        HttpURLConnection checkIn = null;
        try {
            url = new URL("https://sulnamserverpresence-db.herokuapp.com/deleteplayer/" + event.getPlayer().getName() + "/" + Bukkit.getIp());
            checkIn = (HttpURLConnection) url.openConnection();

            checkIn.setRequestMethod("POST");
            checkIn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            checkIn.setDoOutput(true);

            System.out.println(checkIn.getResponseCode());
            checkIn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
