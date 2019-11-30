package io.github.SebastianDanielFrenz.BML.core.registry;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

import io.github.SebastianDanielFrenz.BML.core.game.block.BMLBlock;

public class BlockRegistry {

	private Map<String, Class<? extends BMLBlock>> registeredBlocks = new HashMap<String, Class<? extends BMLBlock>>();

	public void registerBlock(String ID, Class<? extends BMLBlock> blockType) {
		registeredBlocks.put(ID, blockType);
	}

	public Class<? extends BMLBlock> getBlockType(String ID) {
		return registeredBlocks.get(ID);
	}

	public BMLBlock getBlockInstance(String ID) {
		try {
			return registeredBlocks.get(ID).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BlockRegistryInstanceCreationException(
					"The block corresponding to the given ID could not be instanciated!");
		} catch (NullPointerException e) {
			throw new BlockRegistryInstanceCreationException("The ID \"" + ID + "\" is not registered!");
		}
	}

	public BMLBlock getBlockInstance(String ID, Location location) {
		try {
			BMLBlock block = registeredBlocks.get(ID).newInstance();
			block.setLocation(location);
			return block;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BlockRegistryInstanceCreationException(
					"The block corresponding to the given ID could not be instanciated!");
		} catch (NullPointerException e) {
			throw new BlockRegistryInstanceCreationException("The ID \"" + ID + "\" is not registered!");
		}
	}
}
