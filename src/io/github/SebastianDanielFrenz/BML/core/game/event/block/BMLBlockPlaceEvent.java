package io.github.SebastianDanielFrenz.BML.core.game.event.block;

import org.bukkit.block.Block;

public abstract class BMLBlockPlaceEvent extends BMLBlockEvent {

	public BMLBlockPlaceEvent(Block block) {
		super(block);
	}

}
