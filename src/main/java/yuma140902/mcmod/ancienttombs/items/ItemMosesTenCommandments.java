package yuma140902.mcmod.ancienttombs.items;

import java.util.List;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import yuma140902.mcmod.ancienttombs.IRegisterable;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;
import yuma140902.mcmod.ancienttombs.ModConfigCore;
import yuma140902.mcmod.ancienttombs.tileentity.TileEntityMosesDummyBlock;

public class ItemMosesTenCommandments extends Item implements IRegisterable {
	public static final String NBT_MODE_KEY = "Mode";
	public static final byte
			NBT_MODE_DISABLED = 0,
			NBT_MODE_ENABLED = 1;
	public static final int 	height = 3;
	
	public ItemMosesTenCommandments() {
		
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean isHeld) {
		super.onUpdate(itemstack, world, entity, slot, isHeld);
		
		if(world.getTotalWorldTime() % 10 != 0) return;
		
		if(!(entity instanceof EntityPlayer)) return;
		
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		if(tagCompound.getByte(NBT_MODE_KEY) != NBT_MODE_ENABLED) {
			return;
		}
		
		int playerX = MathHelper.ceiling_double_int(entity.posX) - 1;
		int playerY = MathHelper.ceiling_double_int(entity.posY - 0.5D);
		int playerZ = MathHelper.ceiling_double_int(entity.posZ) - 1;
		
		int startX = playerX;
		int startY = playerY - (entity.isSneaking() ? 1 : 0);
		int startZ = playerZ;
		int range = ModConfigCore.mosesBlockRange;
		
		for(int x = startX - range; x <= startX + range; ++x) {
			for(int z = startZ - range; z <= startZ + range; ++z) {
				for(int y = startY; y <= startY + height; ++y) {
					TileEntityMosesDummyBlock tileEntity = new TileEntityMosesDummyBlock();
					tileEntity.tryReplace(world, x, y, z);
				}
			}
		}
		
		TileEntityMosesDummyBlock tileEntity = (TileEntityMosesDummyBlock) world.getTileEntity(playerX, playerY, playerZ);
		if(tileEntity != null) {
			Block block = tileEntity.getReplacedBlock();
			if(block != null && !(block instanceof BlockLiquid)) {
				tileEntity.restoreBlock();
			}
		}
	}
	
	@Override
	public void register() {
		this.setCreativeTab(ModAncientTombs.MOD_CREATIVE_TAB);
		this.setUnlocalizedName(ModAncientTombs.MOD_ID + ".moses_ten_commandments");
		this.setTextureName(ModAncientTombs.MOD_ID + ":moses_ten_commandments");
		GameRegistry.registerItem(this, "moses_ten_commandments");
	}
	
	private static NBTTagCompound getTagCompoundOrDefault(ItemStack itemstack) {
		NBTTagCompound tagCompound = itemstack.getTagCompound();
		if(tagCompound == null) {
			tagCompound = new NBTTagCompound();
			tagCompound.setByte(NBT_MODE_KEY, NBT_MODE_DISABLED);
		}
		
		return tagCompound;
	}
	
	public static boolean isEnabled(ItemStack itemstack) {
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		return tagCompound.getByte(NBT_MODE_KEY) == NBT_MODE_ENABLED;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		
		byte mode = tagCompound.getByte(NBT_MODE_KEY);
		if(mode == NBT_MODE_DISABLED) {
			tagCompound.setByte(NBT_MODE_KEY, NBT_MODE_ENABLED);
		}
		else {
			tagCompound.setByte(NBT_MODE_KEY, NBT_MODE_DISABLED);
		}
		
		itemstack.setTagCompound(tagCompound);
		return itemstack;
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		byte mode = tagCompound.getByte(NBT_MODE_KEY);
		
		return mode == NBT_MODE_ENABLED;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean advanced) {
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		
		byte mode = tagCompound.getByte(NBT_MODE_KEY);
		switch(mode) {
			case NBT_MODE_DISABLED:
				list.add("モード: Disabled");
				break;
			case NBT_MODE_ENABLED:
				list.add("モード: Enabled");
				break;
			default:
				list.add("モード: 不明");
				break;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubItems(Item item, CreativeTabs creativeTab, List list) {
		ItemStack itemstack = new ItemStack(this, 1, 0);
		
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		itemstack.setTagCompound(tagCompound);
		
		list.add(itemstack);
	}
}
