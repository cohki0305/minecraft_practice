package plugin.sample;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.World;
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
    Bukkit.getPluginManager().registerEvents(this, this);
  }

  @EventHandler
  public void onPlayerToggleSneak(PlayerToggleSneakEvent e) {
    Player player = e.getPlayer();
    World world = player.getWorld();

    Firework firework = world.spawn(player.getLocation(), Firework.class);
    FireworkMeta fireworkMeta = firework.getFireworkMeta();

    fireworkMeta.addEffect(
            FireworkEffect.builder()
                    .withColor(Color.BLUE)
                    .with(Type.STAR)
                    .withFlicker()
                    .build());
    fireworkMeta.setPower(0);

    firework.setFireworkMeta(fireworkMeta);
  }
}
