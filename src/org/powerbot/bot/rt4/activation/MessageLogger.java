package org.powerbot.bot.rt4.activation;

import java.util.logging.Logger;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.MessageListener;

public class MessageLogger implements MessageListener {
	private static final Logger log = Logger.getLogger("Messages");
	private final ClientContext ctx;

	public MessageLogger(final ClientContext ctx) {
		this.ctx = ctx;
	}

	public void messaged(final MessageEvent e) {
		if (e.getSender().isEmpty()) {
			log.info("[" + e.getId() + "] " + e.getMessage());
		} else {
			log.info("[" + e.getId() + "] " + e.getSender() + ": " + e.getMessage());
		}
	}
}
