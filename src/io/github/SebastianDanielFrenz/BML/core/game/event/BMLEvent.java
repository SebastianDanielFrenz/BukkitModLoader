package io.github.SebastianDanielFrenz.BML.core.game.event;

import org.bukkit.event.Cancellable;

public abstract class BMLEvent implements Cancellable {

	protected boolean cancelled = false;

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
