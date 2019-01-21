package yuma140902.mcmod.ancienttombs.event_handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;
import yuma140902.mcmod.ancienttombs.ModConfigCore;

public class CommonEventHandler {
	private CommonEventHandler() {}
	
	public static final CommonEventHandler INSTANCE = new CommonEventHandler();
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(ModAncientTombs.MOD_ID.equals(event.modID))
			ModConfigCore.syncConfig();
	}
}
