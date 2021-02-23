package com.github.konfig;

import com.github.konfig.faddonplugin.listener.BlockBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public class FAddonPlugin extends JavaPlugin {

    public void onEnable() {
        new BlockBreakListener(this);
        System.out.println("dnd snow");
    }

}
