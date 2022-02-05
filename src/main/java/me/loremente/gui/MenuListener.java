package me.loremente.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Random;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.RED.toString() + ChatColor.BOLD + "Gui")
                && e.getCurrentItem() != null) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();


            switch (e.getRawSlot()) {
                case 0: //exit

                    break;

                case 20: // tp random
                    Random random = new Random();
                    Player target = (Player)Bukkit.getOnlinePlayers().toArray()[random.nextInt(Bukkit.getOnlinePlayers().size())];
                    player.teleport(target);
                    player.sendMessage(ChatColor.GREEN + "You teleported to" + target.getName() + "!");
                 break;

                case 22: // ez died
                    player.setHealth(0);
                    player.sendMessage(ChatColor.GREEN + "You die (:");
                    break;

                case 24: //set inventory napule
                    player.closeInventory();
                    player.getInventory().clear();
                    player.sendMessage(ChatColor.GREEN + "You cleared inventory!");
                    return;
                default:
                    return;
            }
            player.closeInventory();
        }
    }
}
