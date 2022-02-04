package me.loremente.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inv = Bukkit.createInventory(player, 45, ChatColor.RED.toString() + ChatColor.BOLD + "Tool menu!");

            ItemStack teleport = new ItemStack(Material.ENDER_PEARL);
            ItemMeta teleportMeta = teleport.getItemMeta();
            teleportMeta.setDisplayName(ChatColor.RED + "Random teleport");
            teleportMeta.setLore(Arrays.asList(ChatColor.GRAY + "Teleport a random"));
            teleport.setItemMeta(teleportMeta);

            inv.setItem(20,teleport);

            ItemStack kys = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta kysMeta = kys.getItemMeta();
            kysMeta.setDisplayName(ChatColor.RED + "Kill yourself");
            kysMeta.setLore(Arrays.asList(ChatColor.GRAY + "Kill you."));
            kys.setItemMeta(kysMeta);

            inv.setItem(22, kys);

            ItemStack clear = new ItemStack(Material.BUCKET);
            ItemMeta clearMeta = clear.getItemMeta();
            clearMeta.setDisplayName(ChatColor.GOLD + "Clear Inventory");
            clearMeta.setLore(Arrays.asList(ChatColor.GRAY + "Clears your inventory."));
            clear.setItemMeta(clearMeta);

            inv.setItem(24, clear);

            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = close.getItemMeta();
            closeMeta.setDisplayName(ChatColor.RED + "Close!");
            close.setItemMeta(closeMeta);

            inv.setItem(0, close);

            ItemStack frame = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            for (int i : new int[] {1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
                inv.setItem(i, frame);
            }

            player.openInventory(inv);
        }
        return false;
    }
}
