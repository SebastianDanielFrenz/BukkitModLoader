package io.github.SebastianDanielFrenz.BML.core.game.event.block;

import org.bukkit.block.Block;

public abstract class BMLBlockEvent {

	protected Block block;

	public BMLBlockEvent(Block block) {
		this.block = block;
	}

	public Block getBlock() {
		return block;
	}

}
