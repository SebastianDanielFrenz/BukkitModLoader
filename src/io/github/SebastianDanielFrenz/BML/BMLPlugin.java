package io.github.SebastianDanielFrenz.BML;

import org.bukkit.plugin.java.JavaPlugin;

public class BMLPlugin extends JavaPlugin {

	public static BMLPlugin plugin;

	@Override
	public void onEnable() {
		plugin = this;
	}

	@Override
	public void onDisable() {

	}
}
