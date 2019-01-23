package yuma140902.mcmod.ancienttombs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ModConfigCore {
	public static final String
		CATEGORY_GENERAL = "General",
		CATEGORY_ITEMS = CATEGORY_GENERAL + ".Items";
	
	public static final String
		CONFIG_PROP_LANGKEY = "config.ancienttombs.prop.",
		CONFIG_CATEGORY_LANGKEY = "config.ancienttombs.category.";
	
	public static Configuration cfg;
	
	public static int goldenSealRarity;
	public static int mosesBlockRange;
	
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
		
		// Items
		cfg.addCustomCategoryComment(CATEGORY_ITEMS, "アイテムに関する設定");
		cfg.setCategoryLanguageKey(CATEGORY_ITEMS, CONFIG_CATEGORY_LANGKEY + "items");
	}
	
	public static void syncConfig() {
		// Items
		goldenSealRarity = cfg.getInt("goldenSealRarity", CATEGORY_ITEMS, 5000, 1, Integer.MAX_VALUE, 
				"金印の珍しさです。大きいほど出にくいです。", 
				CONFIG_PROP_LANGKEY + "golden_seal_rarity");
		
		mosesBlockRange = cfg.getInt("mosesBlockRange", CATEGORY_ITEMS, 5, 0, 256, 
				"モーセの十戒でどけられるブロックの範囲", 
				CONFIG_PROP_LANGKEY + "moses_block_range");
		cfg.save();
	}
	
}
