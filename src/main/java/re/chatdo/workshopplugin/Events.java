package re.chatdo.workshopplugin;

import com.google.common.eventbus.DeadEvent;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GREEN + "[+] " + ChatColor.BOLD + event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.RED + "[-] " + ChatColor.BOLD + event.getPlayer().getName());
    }


    @EventHandler
    public void onDirtBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.DIRT) {
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.DIAMOND));
        }

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.COW) {
            event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
        }
    }

}
