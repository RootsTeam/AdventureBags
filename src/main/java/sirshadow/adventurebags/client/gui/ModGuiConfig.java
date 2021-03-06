package sirshadow.adventurebags.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import sirshadow.adventurebags.common.utils.handler.ConfigurationHandler;
import sirshadow.adventurebags.lib.ModLibrary;


/**
 * Created by SirShadow for the mod Roots on 27.7.2016.
 */
public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), ModLibrary.ModInfo.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
