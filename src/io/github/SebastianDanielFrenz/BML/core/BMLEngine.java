package io.github.SebastianDanielFrenz.BML.core;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.github.SebastianDanielFrenz.BML.BMLPlugin;
import io.github.SebastianDanielFrenz.BML.core.game.BMLBlock;
import io.github.SebastianDanielFrenz.BML.core.game.event.block.BMLBlockPlaceEvent;
import io.github.SebastianDanielFrenz.BML.core.game.event.block.BMLPlayerBlockPlaceEvent;
import io.github.SebastianDanielFrenz.BML.core.storage.PlacedBlockStorage;
import io.github.SebastianDanielFrenz.SimpleDBMT.adapter.AutoSaveListener;
import io.github.SebastianDanielFrenz.SimpleDBMT.adapter.PostAutoSaveListener;

public class BMLEngine implements Listener, AutoSaveListener, PostAutoSaveListener {

	public BMLEngine() {
		BMLPlugin.plugin.getServer().getPluginManager().registerEvents(this, BMLPlugin.plugin);
	}

	private PlacedBlockStorage placedBlockStorage = new PlacedBlockStorage("BML", "placed_blocks");

	public void placeBlock(BMLBlock block, BMLBlockPlaceEvent event) {
		block.BMLblockPlaceEvent(event);
		if (!event.isCancelled()) {
			placedBlockStorage.placeBlock(block);
			block.placeMCblock();
		}
	}

	/**
	 * Removes the block from storage. This does <b>NOT</b> replace the block
	 * with air, because it could have been destroyed by other means than just
	 * being removed, such as being replaced via command.
	 * 
	 * @param block
	 * @param event
	 * @return
	 */
	public boolean destroyBlock(BMLBlock block, BlockBreakEvent event) {
		block.MCblockBreakEvent(event);
		if (!event.isCancelled()) {
			placedBlockStorage.destroyBlock(block);
		}
		return false;
	}

	@EventHandler
	public void bukkit_onBlockBreak(BlockBreakEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			destroyBlock(block, event);
		}
	}

	@EventHandler
	public void bukkit_onBlockPlace(BlockPlaceEvent event) {
		ItemStack itemStack = event.getItemInHand();
		List<String> lore = itemStack.getItemMeta().getLore();
		if (lore.size() != 0) {
			String raw = lore.get(lore.size() - 1);
			if (raw.startsWith("ID: ")) {
				String ID = raw.substring(4);
				BMLBlock block;

				try {
					block = (BMLBlock) Class.forName(ID).newInstance();
					block.setLocation(event.getBlock().getLocation());
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}

				placeBlock(block, new BMLPlayerBlockPlaceEvent(event.getBlock()));
			}
		}
	}

	@Override
	public void onAutoSave() {
		placedBlockStorage.storeInDB();
	}

	@Override
	public void onPostAutoSave() {
		placedBlockStorage.clearDB();
	}

}
