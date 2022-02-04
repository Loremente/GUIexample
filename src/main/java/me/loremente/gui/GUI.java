package me.loremente.gui;

import org.bukkit.plugin.java.JavaPlugin;

public final class GUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gui").setExecutor(new MenuCommand());
    }
}
