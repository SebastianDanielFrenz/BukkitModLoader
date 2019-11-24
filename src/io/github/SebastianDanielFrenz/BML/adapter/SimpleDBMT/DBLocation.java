package io.github.SebastianDanielFrenz.BML.adapter.SimpleDBMT;

import org.bukkit.Location;

import io.github.SebastianDanielFrenz.BML.Utils;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBCompareable;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBvalue;

public class DBLocation implements DBvalue {
	
	private Location value;

	@Override
	public void Parse(String arg0) {
		Utils.BlockLocationFromString(arg0);
	}

	@Override
	public String Save() {
		return Utils.
	}

	@Override
	public boolean Equals(DBCompareable arg0) {
		return 
	}

	@Override
	public String Display() {
		// TODO Auto-generated method stub
		return null;
	}

}
