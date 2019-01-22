package yuma140902.mcmod.ancienttombs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import yuma140902.mcmod.ancienttombs.IRegisterable;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;

public class ItemMosesTenCommandments extends Item implements IRegisterable {
	public ItemMosesTenCommandments() {
	}
	
	@Override
	public void register() {
		this.setCreativeTab(ModAncientTombs.MOD_CREATIVE_TAB);
		this.setUnlocalizedName(ModAncientTombs.MOD_ID + ".moses_ten_commandments");
		this.setTextureName(ModAncientTombs.MOD_ID + ":moses_ten_commandments");
		GameRegistry.registerItem(this, "moses_ten_commandments");
	}
}
