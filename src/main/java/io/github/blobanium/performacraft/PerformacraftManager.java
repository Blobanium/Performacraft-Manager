package io.github.blobanium.performacraft;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerformacraftManager implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Performacraft Manager");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Performacraft Manager");
	}
}
