package yuma140902.mcmod.ancienttombs.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import yuma140902.mcmod.ancienttombs.event_handler.CommonEventHandler;

public class CommonProxy {
	public void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(CommonEventHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(CommonEventHandler.INSTANCE);
	}
	
	private int id = 0;
	public void registerEntities() {
	}
	
	public void registerRenderers() { }
}
