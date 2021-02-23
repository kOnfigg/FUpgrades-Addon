package com.github.konfig.faddonplugin.listener;

import com.github.konfig.FAddonPlugin;
import com.github.konfig.faddonplugin.libs.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBreakListener implements Listener {

    private ItemStack itemStack;

    public BlockBreakListener(FAddonPlugin instance) {
        Bukkit.getPluginManager().registerEvents(this, instance);

        itemStack = new ItemBuilder(351)
                .name("§eFragmento de Moeda")
                .lore("§7Ao juntar quatro fragmentos de moedas",
                        "§7é possível realizar uma junção e",
                        "§7transformar em §eMoeda.")
                .durability(11)
                .build();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBreak(BlockBreakEvent event) {
        Material blockType = event.getBlock().getType();

        if (blockType == Material.MELON_BLOCK || blockType == Material.NETHER_WARTS) {
            Player player = event.getPlayer();

            if (isMore(5.2)) {
                player.getInventory().addItem(itemStack);
                player.sendMessage("§aVocê achou um fragmento de moeda!");
            }
        }
    }

    public boolean isMore(double qnt) {
        return new Random().nextDouble() < qnt / 100.0;
    }

}
