package io.github.SebastianDanielFrenz.BML.core.game;

import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBCompareable;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBvalue;

public class PlacedBlock implements DBvalue {

	public PlacedBlock(int x, int y, int z, Block type) {
		setX(x);
		setY(y);
		setZ(z);
	}

	private int x;
	private int y;
	private int z;
	private Block type;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Block getType() {
		return type;
	}

	public void setType(Block type) {
		this.type = type;
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
