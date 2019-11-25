package io.github.SebastianDanielFrenz.BML.adapter.SimpleDBMT;

import org.bukkit.Location;

import io.github.SebastianDanielFrenz.BML.Utils;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBCompareable;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBvalue;

public class DBLocation implements DBvalue {

	public DBLocation() {

	}

	public DBLocation(Location value) {
		this.value = value;
	}

	private Location value;

	@Override
	public void Parse(String arg0) {
		Utils.BlockLocationFromString(arg0);
	}

	@Override
	public String Save() {
		return Utils.BlockLocationToString(value);
	}

	@Override
	public boolean Equals(DBCompareable arg0) {
		if (arg0 instanceof DBvalue) {
			return ((DBvalue) arg0).Display().equals(Display());
		}
		return false;
	}

	@Override
	public String Display() {
		return Utils.BlockLocationToString(value);
	}

	public Location getValue() {
		return value;
	}

	public void setValue(Location value) {
		this.value = value;
	}

}
