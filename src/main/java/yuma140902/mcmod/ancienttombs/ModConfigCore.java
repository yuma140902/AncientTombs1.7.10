package yuma140902.mcmod.ancienttombs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ModConfigCore {
	public static final String
		CATEGORY_GENERAL = "General",
		CATEGORY_DIFFICULTY = CATEGORY_GENERAL + ".Difficulty";
	
	public static final String
		CONFIG_PROP_LANGKEY = "config.ancienttombs.prop.",
		CONFIG_CATEGORY_LANGKEY = "config.ancienttombs.category.";
	
	public static Configuration cfg;
	
	public static int goldenSealRarity;
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		cfg = new Configuration(event.getSuggestedConfigurationFile(), true);
		initConfig();
		syncConfig();
	}
	
	private static void initConfig() {
		// General
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "古墳MODの設定");
		cfg.setCategoryLanguageKey(CATEGORY_GENERAL, CONFIG_CATEGORY_LANGKEY + "general");
		cfg.setCategoryRequiresMcRestart(CATEGORY_GENERAL, true);
		
		// Difficulty
		cfg.addCustomCategoryComment(CATEGORY_DIFFICULTY, "難易度に関する設定");
		cfg.setCategoryLanguageKey(CATEGORY_DIFFICULTY, CONFIG_CATEGORY_LANGKEY + "difficulty");
	}
	
	public static void syncConfig() {
		// Difficulty
		goldenSealRarity = cfg.getInt("goldenSealRarity", CATEGORY_DIFFICULTY, 5000, 1, Integer.MAX_VALUE, 
				"金印の珍しさです。大きいほど出にくいです。", 
				CONFIG_PROP_LANGKEY + "golden_seal_rarity");
		cfg.save();
	}
	
}
