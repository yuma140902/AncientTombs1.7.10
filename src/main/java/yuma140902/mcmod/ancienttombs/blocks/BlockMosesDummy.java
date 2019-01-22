package yuma140902.mcmod.ancienttombs.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import yuma140902.mcmod.ancienttombs.IRegisterable;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;

public class BlockMosesDummy extends Block implements IRegisterable {
	public BlockMosesDummy() {
		super(Material.air);
		setResistance(-1);
		setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		setBlockUnbreakable();
	}
	
	@Override
	public void register() {
		this.setCreativeTab(ModAncientTombs.MOD_CREATIVE_TAB);
		this.setBlockName(ModAncientTombs.MOD_ID + ".moses_dummy_block");
		this.setBlockTextureName(ModAncientTombs.MOD_ID + ":moses_dummy_block");
		GameRegistry.registerBlock(this, "moses_dummy_block");
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return false;
	}
}
