package plugin.sample;

import org.bukkit.*;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    // Plugin startup logic
    Bukkit.getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  public void onPlayerToggleSneak(PlayerToggleSneakEvent e) {
    Player player = e.getPlayer();
    String netherWorldId = player.getWorld().getName() + "_nether";
    World netherWorld = Bukkit.getServer().getWorld(netherWorldId);
    Location location = new Location(
            netherWorld,
            0,
            10,
            0
    );
    player.teleport(location);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
