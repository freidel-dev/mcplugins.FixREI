package freidel.dev.mcplugins;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Set;
import org.bukkit.NamespacedKey;

public final class FixREI extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    // onPlayerJoin listener
    public void onPlayerJoin(PlayerJoinEvent playerJoin) {
        // Get recipes player has discovered
        Set<NamespacedKey> discoveredRecipes = playerJoin.getPlayer().getDiscoveredRecipes();
        // Undiscover and rediscover the recipes -- re-triggers REIs recipe discovery system
        playerJoin.getPlayer().undiscoverRecipes(discoveredRecipes);
        playerJoin.getPlayer().discoverRecipes(discoveredRecipes);
    }
}