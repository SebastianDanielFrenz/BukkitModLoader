package io.github.SebastianDanielFrenz.BML.core;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.inventory.ItemStack;

import io.github.SebastianDanielFrenz.BML.BMLPlugin;
import io.github.SebastianDanielFrenz.BML.core.game.block.BMLBlock;
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

	public PlacedBlockStorage getPlacedBlockStorage() {
		return placedBlockStorage;
	}

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
		BMLPlugin.plugin.getLogger().info("placed block!");

		ItemStack itemStack = event.getItemInHand();
		List<String> lore = itemStack.getItemMeta().getLore();
		if (lore != null) {
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

	@EventHandler
	public void bukkit_onBlockBurn(BlockBurnEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockBurnEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockCanBuild(BlockCanBuildEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockCanBuildEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockDamage(BlockDamageEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockDamageEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockDispense(BlockDispenseEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockDispenseEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockFade(BlockFadeEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockFadeEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockFromTo(BlockFromToEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockFromToEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockGrow(BlockGrowEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockGrowEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockIgnite(BlockIgniteEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockIgniteEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockPhysics(BlockPhysicsEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockPhysicsEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockPiston(BlockPistonEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockPistonEvent(event);
		}
	}

	@EventHandler
	public void bukkit_onBlockRedstone(BlockRedstoneEvent event) {
		BMLBlock block = placedBlockStorage.getBlockAt(event.getBlock().getLocation());
		if (block != null) {
			block.MCblockRedstoneEvent(event);
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
