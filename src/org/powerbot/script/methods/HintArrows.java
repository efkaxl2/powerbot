package org.powerbot.script.methods;

import java.util.Arrays;

import org.powerbot.client.Client;
import org.powerbot.client.RSHintArrow;
import org.powerbot.script.wrappers.HintArrow;

/**
 * {@link HintArrows} is a static utility which provides access to the game's hint (directional) arrows.
 *
 * @author Timer
 */
public class HintArrows extends Filtering<HintArrow> {
	public HintArrows(ClientFactory factory) {
		super(factory);
	}

	/**
	 * Returns the loaded {@link HintArrow}s.
	 *
	 * @return an array of loaded {@link HintArrow}s
	 */
	@Override
	public HintArrow[] list() {
		Client client = ctx.getClient();
		if (client == null) return new HintArrow[0];

		final RSHintArrow[] arr = client.getRSHintArrows();
		final HintArrow[] arrows = new HintArrow[arr != null ? arr.length : 0];
		int d = 0;
		for (final RSHintArrow arrow : arr != null ? arr : new RSHintArrow[0]) {
			if (arrow != null) arrows[d++] = new HintArrow(ctx, arrow);
		}
		return Arrays.copyOf(arrows, d);
	}
}
