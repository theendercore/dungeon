package team.voided.voidlesscrypt;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoidlessCrypt implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("voidless_crypt");

    @Override
    public void onInitialize() {
        LOGGER.info("Initialized");
    }
}
