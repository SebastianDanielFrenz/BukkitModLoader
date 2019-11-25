package io.github.SebastianDanielFrenz.BML;

import org.bukkit.Location;

public class Utils {

	public static Location BlockLocationFromString(String text) {
		String[] split = text.split(";");

		return new Location(BMLPlugin.plugin.getServer().getWorld(split[0]), Integer.parseInt(split[1]),
				Integer.parseInt(split[2]), Integer.parseInt(split[3]));
	}

	public static String BlockLocationToString(Location location) {
		return location.getWorld().getName() + ";" + location.getBlockX() + ";" + location.getBlockY() + ";"
				+ location.getBlockZ();
	}

}
