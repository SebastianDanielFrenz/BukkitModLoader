package io.github.SebastianDanielFrenz.BML;

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

		if (dbh.getDataBase("BML") == null) {
			dbh.createDataBase("BML", "BML.db");
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
