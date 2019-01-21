package yuma140902.mcmod.ancienttombs.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;
import yuma140902.mcmod.ancienttombs.ModConfigCore;

public class ModConfigGui extends GuiConfig {
	public ModConfigGui(GuiScreen parent) {
		super(parent, 
				(new ConfigElement<Object>(ModConfigCore.cfg.getCategory(ModConfigCore.CATEGORY_GENERAL))).getChildElements(), 
				ModAncientTombs.MOD_ID, false, false, ModAncientTombs.MOD_NAME);
	}
}
