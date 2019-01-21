package yuma140902.mcmod.ancienttombs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import yuma140902.mcmod.ancienttombs.items.ModItems;

public class ModCreativeTab extends CreativeTabs {
	public ModCreativeTab() {
		super("ancienttombs");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ModItems.goldenSeal;
	}
}
