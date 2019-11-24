package io.github.SebastianDanielFrenz.BML.core.game;

import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBCompareable;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBvalue;

public class PlacedBlock implements DBvalue {

	public PlacedBlock(BMLBlock block) {
		this.block = block;
	}

	private BMLBlock block;

	public BMLBlock getBlock() {
		return block;
	}

	@Override
	public void Parse(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String Save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Equals(DBCompareable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Display() {
		// TODO Auto-generated method stub
		return null;
	}

}
