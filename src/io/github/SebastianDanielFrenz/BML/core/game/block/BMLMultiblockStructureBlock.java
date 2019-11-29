package io.github.SebastianDanielFrenz.BML.core.game.block;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

import io.github.SebastianDanielFrenz.BML.BMLPlugin;
import io.github.SebastianDanielFrenz.BML.core.BMLEngine;
import io.github.SebastianDanielFrenz.BML.core.game.event.multiblockStructure.BMLMultiblockStructureBreakEvent;

public abstract class BMLMultiblockStructureBlock extends BMLBlock {

	private BMLMultiblockStructureBlock[] other_blocks;

	public abstract void BMLMultiblockStructureBreakEvent(BMLMultiblockStructureBreakEvent event);

	public void remove(BMLEngine engine) {
		location.getWorld().getBlockAt(location).setType(Material.AIR);

		engine.getPlacedBlockStorage().destroyBlock(this);

	}

	@Override
	public void MCblockBreakEvent(BlockBreakEvent event) {
		BMLMultiblockStructureBreakEvent multiBlockEvent = new BMLMultiblockStructureBreakEvent(this, event);
		BMLMultiblockStructureBreakEvent(multiBlockEvent);

		for (BMLMultiblockStructureBlock block : other_blocks) {
			block.BMLMultiblockStructureBreakEvent(multiBlockEvent);
		}

		if (!multiBlockEvent.isCancelled()) {
			remove(BMLPlugin.engine);

			for (BMLMultiblockStructureBlock block : other_blocks) {
				block.remove(BMLPlugin.engine);
			}
		}
	}

	public BMLMultiblockStructureBlock[] getOther_blocks() {
		return other_blocks;
	}

	public void setOther_blocks(BMLMultiblockStructureBlock[] other_blocks) {
		this.other_blocks = other_blocks;
	}

}
