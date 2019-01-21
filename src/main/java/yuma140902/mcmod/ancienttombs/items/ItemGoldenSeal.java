package yuma140902.mcmod.ancienttombs.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import yuma140902.mcmod.ancienttombs.IRegisterable;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;

public class ItemGoldenSeal extends Item implements IRegisterable {
	public ItemGoldenSeal() {
	}
	
	@Override
	public void register() {
		this.setCreativeTab(ModAncientTombs.MOD_CREATIVE_TAB);
		this.setUnlocalizedName(ModAncientTombs.MOD_ID + ".golden_seal");
		this.setTextureName(ModAncientTombs.MOD_ID + ":golden_seal");
		GameRegistry.registerItem(this, "golden_seal");
	}

	@Override
	public boolean hasEffect(ItemStack itemstack) {
		return true;
	}
}
