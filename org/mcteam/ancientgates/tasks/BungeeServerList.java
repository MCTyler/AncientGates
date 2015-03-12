package org.mcteam.ancientgates.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;
import org.mcteam.ancientgates.Plugin;
import org.mcteam.ancientgates.util.types.PluginMessage;

import java.util.Iterator;

public class BungeeServerList extends BukkitRunnable {
 
	private final Plugin plugin;
 
	public BungeeServerList(Plugin plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public void run() {
		if (plugin.getServer().getOnlinePlayers().size() == 0) return;
		// Send BungeeCord "GetServers" command
		final PluginMessage msg = new PluginMessage("GetServers");
		Iterables.getFirst(Bukkit.getOnlinePlayers(), null).sendPluginMessage(plugin, "BungeeCord", msg.toByteArray());
	}
}
