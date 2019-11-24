package io.github.SebastianDanielFrenz.BML.core.storage;

import org.bukkit.block.Block;

import io.github.SebastianDanielFrenz.SimpleDBMT.query.DataBaseQuery;
import io.github.SebastianDanielFrenz.SimpleDBMT.query.SearchedValue;

public class PlacedBlockStorage {

	private DataBaseQuery query;
	private String db;
	private String table;

	public void placeBlock(Block block) {
		query.Insert(table, table, new SearchedValue[]{new SearchedValue("location", new DBLocation())});
	}

}
