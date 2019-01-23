package yuma140902.mcmod.ancienttombs.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import yuma140902.mcmod.ancienttombs.blocks.ModBlocks;

public class TileEntityMosesDummyBlock extends TileEntity {
	
	private static final String 
			NBT_KEY_REPLACED_BLOCK_ID = "ReplacedBlockId",
			NBT_KEY_REPLACED_BLOCK_META = "ReplacedBlockMeta",
			NBT_KEY_LIFESTAN_COUNT = "LifespanCount";
	
	private static final short LIFESPAN_MAX = 40;
	
	private int replacedBlockId;
	private byte meta;
	private short lifespanCount = LIFESPAN_MAX;
	
	
	public void tryReplace(World world, int x, int y, int z) {
		if(y == 0 || world.getTileEntity(x, y, z) != null || world.isAirBlock(x, y, z)) {
			return;
		}
		
		Block replacedBlock = world.getBlock(x, y, z);
		this.replacedBlockId = Block.getIdFromBlock(replacedBlock);
		this.meta = (byte) world.getBlockMetadata(x, y, z);
		
		world.setBlock(x, y, z, ModBlocks.mosesDummyBlock, 0, 2);
		this.lifespanCount = LIFESPAN_MAX;
		world.setTileEntity(x, y, z, this);
		this.markDirty();
		
		return;
	}
	
	public static void restoreBlockAt(World world, int x, int y, int z) {
		if(world.getBlock(x, y, z) != ModBlocks.mosesDummyBlock) {
			return;
		}
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if(tileEntity != null && tileEntity instanceof TileEntityMosesDummyBlock) {
			TileEntityMosesDummyBlock tileEntityMosesDummyBlock = (TileEntityMosesDummyBlock) tileEntity;
			
			tileEntityMosesDummyBlock.restoreBlock();
		}
	}
	
	public void restoreBlock() {
		Block replacedBlock = getReplacedBlock();
		worldObj.setBlock(xCoord, yCoord, zCoord, replacedBlock, meta, 2);
		worldObj.setTileEntity(xCoord, yCoord, zCoord, null);
	}
	
	public Block getReplacedBlock() {
		return Block.getBlockById(replacedBlockId);
	}
	
	public byte getMeta() {
		return meta;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger(NBT_KEY_REPLACED_BLOCK_ID, replacedBlockId);
		nbt.setByte(NBT_KEY_REPLACED_BLOCK_META, meta);
		nbt.setShort(NBT_KEY_LIFESTAN_COUNT, lifespanCount);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		replacedBlockId = nbt.getInteger(NBT_KEY_REPLACED_BLOCK_ID);
		meta = nbt.getByte(NBT_KEY_REPLACED_BLOCK_META);
		lifespanCount = nbt.getShort(NBT_KEY_LIFESTAN_COUNT);
	}
	
	@Override
	public void updateEntity() {
		--lifespanCount;
		if(lifespanCount <= 0) {
			lifespanCount = LIFESPAN_MAX;
			restoreBlock();
		}
	}
}
