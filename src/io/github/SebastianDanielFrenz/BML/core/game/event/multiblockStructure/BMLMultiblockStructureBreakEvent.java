package io.github.SebastianDanielFrenz.BML.core.game.event.multiblockStructure;

import org.bukkit.event.block.BlockBreakEvent;

import io.github.SebastianDanielFrenz.BML.core.game.block.BMLMultiblockStructureBlock;
import io.github.SebastianDanielFrenz.BML.core.game.event.BMLEvent;

public class BMLMultiblockStructureBreakEvent extends BMLEvent {

	public BMLMultiblockStructureBreakEvent(BMLMultiblockStructureBlock block, BlockBreakEvent event) {
		this.block = block;
		this.event = event;
	}

	private BMLMultiblockStructureBlock block;
	private BlockBreakEvent event;

	public BMLMultiblockStructureBlock getBlock() {
		return block;
	}

	public BlockBreakEvent getEvent() {
		return event;
	}

}
