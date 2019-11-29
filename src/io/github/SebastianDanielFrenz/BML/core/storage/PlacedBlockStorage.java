package io.github.SebastianDanielFrenz.BML.core.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

import io.github.SebastianDanielFrenz.BML.BMLPlugin;
import io.github.SebastianDanielFrenz.BML.adapter.SimpleDBMT.DBLocation;
import io.github.SebastianDanielFrenz.BML.core.game.block.BMLBlock;
import io.github.SebastianDanielFrenz.SimpleDBMT.Table;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBString;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBvalue;

public class PlacedBlockStorage {

	public PlacedBlockStorage(String db, String table) {
		this.db = db;
		this.table = table;
		loadFromDB();
	}

	private String db;
	private String table;

	private Map<Location, BMLBlock> placed_blocks = new HashMap<Location, BMLBlock>();

	public void placeBlock(BMLBlock block) {
		placed_blocks.put(block.getLocation(), block);
	}

	public void destroyBlock(BMLBlock block) {
		placed_blocks.remove(block.getLocation());
	}

	public BMLBlock getBlockAt(Location location) {
		return placed_blocks.get(location);
	}

	public void storeInDB() {
		BMLPlugin.dbh.getDataBase(db).createTable(table);
		Table t = BMLPlugin.dbh.getDataBase(db).getTable(table);
		t.addColumn("ID");
		t.addColumn("location");
		t.addColumn("data");
		ArrayList<DBvalue> row;

		for (BMLBlock block : placed_blocks.values()) {
			row = new ArrayList<DBvalue>(2);

			row.add(new DBString(block.getClass().getCanonicalName()));
			row.add(new DBLocation(block.getLocation()));
			row.add(block.getData());
			t.addRow(row);
		}
	}

	public void clearDB() {
		BMLPlugin.dbh.getDataBase(db).deleteTable(table);
	}

	@SuppressWarnings("unchecked")
	public void loadFromDB() {
		Table table = BMLPlugin.dbh.getDataBase(db).getTable(this.table);
		for (ArrayList<DBvalue> row : table.getValues()) {
			try {
				BMLBlock block = ((Class<? extends BMLBlock>) Class.forName(((DBString) row.get(0)).getValue()))
						.newInstance();

				block.setData(row.get(2));

				placed_blocks.put(((DBLocation) row.get(1)).getValue(), block);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
