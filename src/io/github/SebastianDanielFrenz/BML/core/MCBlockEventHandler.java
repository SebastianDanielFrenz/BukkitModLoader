package io.github.SebastianDanielFrenz.BML.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockExpEvent;
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
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;

public class MCBlockEventHandler implements Listener {

	@EventHandler
	public void MCblockCanBuildEvent(BlockCanBuildEvent event) {

	}

	@EventHandler
	public void MCblockDamageEvent(BlockDamageEvent event) {

	}

	@EventHandler
	public void MCblockDispenseEvent(BlockDispenseEvent event) {

	}

	// start BlockExpEvent
	@EventHandler
	public void MCblockBreakEvent(BlockExpEvent event) {
	}

	@EventHandler
	public void MCfurnaceExtractEvent(FurnaceExtractEvent event) {
	}

	// stop BlockExpEvent
	@EventHandler
	public void MCblockFadeEvent(BlockFadeEvent event) {
	}

	@EventHandler
	public void MCblockFromToEvent(BlockFromToEvent event) {
	}

	@EventHandler
	public void MCblockGrowEvent(BlockGrowEvent event) {
	}

	@EventHandler
	public void MCblockIgniteEvent(BlockIgniteEvent event) {
	}

	@EventHandler
	public void MCblockPhysicsEvent(BlockPhysicsEvent event) {
	}

	@EventHandler
	public void MCblockPistonEvent(BlockPistonEvent event) {
	}

	/*
	 * Remember, this event should, if your representation block is not air,
	 * never be run.
	 */
	@EventHandler
	public void MCblockPlaceEvent(BlockPlaceEvent event) {
	}

	@EventHandler
	public void MCblockRedstoneEvent(BlockRedstoneEvent event) {
	}

	@EventHandler
	public void MCbrewEvent(BrewEvent event) {
	}

	@EventHandler
	public void MCfurnaceBurnEvent(FurnaceBurnEvent event) {
	}

	@EventHandler
	public void MCleavesDecayEvent(LeavesDecayEvent event) {
	}

	@EventHandler
	public void MCnotePlayEvent(NotePlayEvent event) {
	}

	@EventHandler
	public void MCsignChangeEvent(SignChangeEvent event) {
	}

}
