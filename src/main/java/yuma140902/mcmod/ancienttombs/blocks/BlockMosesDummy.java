package yuma140902.mcmod.ancienttombs.blocks;

import java.util.List;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockAir;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import yuma140902.mcmod.ancienttombs.IRegisterable;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;
import yuma140902.mcmod.ancienttombs.tileentity.TileEntityMosesDummyBlock;

public class BlockMosesDummy extends BlockAir implements ITileEntityProvider, IRegisterable {
	public BlockMosesDummy() {
		setResistance(-1);
		setBlockUnbreakable();
	}
	
	@Override
	public void register() {
		this.setBlockName(ModAncientTombs.MOD_ID + ".moses_dummy_block");
		this.setBlockTextureName(ModAncientTombs.MOD_ID + ":moses_dummy_block");
		GameRegistry.registerBlock(this, "moses_dummy_block");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMosesDummyBlock();
	}
}
