package io.github.SebastianDanielFrenz.BML;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.SebastianDanielFrenz.BML.core.BMLEngine;
import io.github.SebastianDanielFrenz.SimpleDBMT.DataBaseHandler;

public class BMLPlugin extends JavaPlugin {

	public static BMLPlugin plugin;
	public static DataBaseHandler dbh;
	public static BMLEngine engine;

	@Override
	public void onEnable() {
		plugin = this;
		if (!setupDB()) {
			getLogger().info("Could not access SimpleDBMT!");

			Bukkit.getPluginManager().disablePlugin(this);
		}

		getLogger().info("Starting engine...");

		try {
			dbh.addDataBase("BML.db");
		} catch (IOException e) {
			dbh.createDataBase("BML", "BML.db");
			dbh.getDataBase("BML").createTable("placed_blocks");
		}

		engine = new BMLEngine();
	}

	@Override
	public void onDisable() {
	}

	public boolean setupDB() {
		RegisteredServiceProvider<DataBaseHandler> dataBaseProvider = getServer().getServicesManager()
				.getRegistration(DataBaseHandler.class);
		if (dataBaseProvider != null) {
			dbh = dataBaseProvider.getProvider();
		}

		return dataBaseProvider != null;
	}
}
