package de.maxhenkel.cyclehotbar;

import de.maxhenkel.cyclehotbar.config.ClientConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class CycleHotbar implements ClientModInitializer {

    public static final String MODID = "cyclehotbar";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ClientConfig CLIENT_CONFIG;

    @Override
    public void onInitializeClient() {
        // CLIENT_CONFIG = ConfigBuilder.build(FabricLoader.getInstance().getConfigDir().resolve(MODID).resolve("cyclehotbar.properties"), ClientConfig::new);
        KeyEvents.init();
    }
}
