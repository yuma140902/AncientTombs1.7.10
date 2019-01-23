package yuma140902.mcmod.ancienttombs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import yuma140902.mcmod.ancienttombs.blocks.ModBlocks;
import yuma140902.mcmod.ancienttombs.items.ModItems;
import yuma140902.mcmod.ancienttombs.proxy.CommonProxy;
import yuma140902.mcmod.ancienttombs.util.Stat;
import yuma140902.mcmod.ancienttombs.worldgen.WorldGenerators;

@Mod(modid = ModAncientTombs.MOD_ID, name = ModAncientTombs.MOD_NAME, version = ModAncientTombs.MOD_VERSION, useMetadata = true, guiFactory = Stat.MOD_CONFIG_GUI_FACTORY)
public class ModAncientTombs {
	@Mod.Metadata
	public static ModMetadata modMetadata;
	
	@Mod.Instance
	public static ModAncientTombs INSTANCE;
	
	@SidedProxy(clientSide = Stat.PROXY_CLIENT, serverSide = Stat.PROXY_SERVER)
	public static CommonProxy proxy;
	
	public static final String MOD_ID = "ancienttombs";
	public static final String MOD_NAME = "古墳MOD";
	public static final String MINECRAFT_VERSION = "1.7.10";
	public static final String MOD_VERSION = "0.0.0";
	public static final ModCreativeTab MOD_CREATIVE_TAB = new ModCreativeTab();
	
	private void loadModMetadata(ModMetadata modMetadata) {
		modMetadata.modId = MOD_ID;
		modMetadata.name = MOD_NAME;
		modMetadata.version = MOD_VERSION;
		modMetadata.authorList.add("yuma140902");
		modMetadata.description = "古墳などを追加します";
		modMetadata.autogenerated = false;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		loadModMetadata(modMetadata);
		ModConfigCore.loadConfig(event);
		
		ModBlocks.register();
		ModItems.register();
		
		proxy.registerTileEntities();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Recipes.register();
		proxy.registerEntities();
		proxy.registerRenderers();
		
		WorldGenerators.register();
		
		proxy.registerEventHandlers();
	}
}
