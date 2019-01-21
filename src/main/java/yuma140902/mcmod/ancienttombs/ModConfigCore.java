package yuma140902.mcmod.ancienttombs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ModConfigCore {
	public static final String
		CATEGORY_GENERAL = "General";
	
	public static final String
		CONFIG_PROP_LANGKEY = "config.ancienttombs.prop.",
		CONFIG_CATEGORY_LANGKEY = "config.ancienttombs.category.";
	
	public static Configuration cfg;
	
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		cfg = new Configuration(event.getSuggestedConfigurationFile(), true);
		initConfig();
		syncConfig();
	}
	
	private static void initConfig() {
		// General
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "Settings of UpToDateMod");
		cfg.setCategoryLanguageKey(CATEGORY_GENERAL, CONFIG_CATEGORY_LANGKEY + "general");
		cfg.setCategoryRequiresMcRestart(CATEGORY_GENERAL, true);
	}
	
	public static void syncConfig() {
		cfg.save();
	}
	
}
