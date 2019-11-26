package io.github.SebastianDanielFrenz.BML.core.game.event.block;

import org.bukkit.block.Block;

import io.github.SebastianDanielFrenz.BML.core.game.event.BMLEvent;

public abstract class BMLBlockEvent extends BMLEvent {

	protected Block block;

	public BMLBlockEvent(Block block) {
		this.block = block;
	}

	public Block getBlock() {
		return block;
	}

}
