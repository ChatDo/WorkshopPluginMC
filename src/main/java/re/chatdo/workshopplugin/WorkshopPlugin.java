package re.chatdo.workshopplugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class WorkshopPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getPluginManager().registerEvents(new Events(), this);
        this.getCommand("epitech").setExecutor(new EpitechCommand());

        System.out.println("ENABLED");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("DISABLED");
    }

}
