package io.github.SebastianDanielFrenz.BML.core.game.block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;

import io.github.SebastianDanielFrenz.BML.core.game.event.block.BMLBlockPlaceEvent;
import io.github.SebastianDanielFrenz.SimpleDBMT.varTypes.DBvalue;

/**
 * For an expination of the events, visit
 * <a href="https://jd.bukkit.org/org/bukkit/event/block/BlockEvent.html">this
 * bukkit doc</a>. <br>
 * <br>
 * In order for your custom block to work with the BMLEngine class, you will
 * have to provide an empty constructor.
 * 
 * @since BML 0.0.1
 *
 */
public abstract class BMLBlock {

	public BMLBlock() {
	}

	public BMLBlock(Location location) {
		this.location = location;
	}

	protected Location location;

	protected DBvalue data;

	public DBvalue getData() {
		return data;
	}

	public void setData(DBvalue data) {
		this.data = data;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Block getMCblock() {
		return location.getBlock();
	}

	public void placeMCblock() {
		location.getWorld().getBlockAt(location).setType(getMaterial());
	}

	public abstract Material getMaterial();

	public abstract void BMLblockPlaceEvent(BMLBlockPlaceEvent event);

	public abstract void MCblockBurnEvent(BlockBurnEvent event);

	public abstract void MCblockCanBuildEvent(BlockCanBuildEvent event);

	public abstract void MCblockDamageEvent(BlockDamageEvent event);

	public abstract void MCblockDispenseEvent(BlockDispenseEvent event);

	// start BlockExpEvent
	public abstract void MCblockBreakEvent(BlockBreakEvent event);

	public abstract void MCfurnaceExtractEvent(FurnaceExtractEvent event);

	// stop BlockExpEvent

	public abstract void MCblockFadeEvent(BlockFadeEvent event);

	public abstract void MCblockFromToEvent(BlockFromToEvent event);

	public abstract void MCblockGrowEvent(BlockGrowEvent event);

	public abstract void MCblockIgniteEvent(BlockIgniteEvent event);

	public abstract void MCblockPhysicsEvent(BlockPhysicsEvent event);

	public abstract void MCblockPistonEvent(BlockPistonEvent event);

	/*
	 * Remember, this event should, if your representation block is not air,
	 * never be run.
	 */
	public abstract void MCblockPlaceEvent(BlockPlaceEvent event);

	public abstract void MCblockRedstoneEvent(BlockRedstoneEvent event);

	public abstract void MCfurnaceBurnEvent(FurnaceBurnEvent event);

	public abstract void MCleavesDecayEvent(LeavesDecayEvent event);

	public abstract void MCnotePlayEvent(NotePlayEvent event);

	public abstract void MCsignChangeEvent(SignChangeEvent event);

	public abstract void gameTickEvent();
}