package yuma140902.mcmod.ancienttombs.items;

import java.util.List;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import yuma140902.mcmod.ancienttombs.IRegisterable;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;

public class ItemMosesTenCommandments extends Item implements IRegisterable {
	public static final String NBT_MODE_KEY = "Mode";
	public static final byte
			NBT_MODE_DISABLED = 0,
			NBT_MODE_ENABLED = 1;
	
	public ItemMosesTenCommandments() {
		
	}
	
	@Override
	public void register() {
		this.setCreativeTab(ModAncientTombs.MOD_CREATIVE_TAB);
		this.setUnlocalizedName(ModAncientTombs.MOD_ID + ".moses_ten_commandments");
		this.setTextureName(ModAncientTombs.MOD_ID + ":moses_ten_commandments");
		GameRegistry.registerItem(this, "moses_ten_commandments");
	}
	
	private NBTTagCompound getTagCompoundOrDefault(ItemStack itemstack) {
		NBTTagCompound tagCompound = itemstack.getTagCompound();
		if(tagCompound == null) {
			tagCompound = new NBTTagCompound();
			tagCompound.setByte(NBT_MODE_KEY, NBT_MODE_DISABLED);
		}
		
		return tagCompound;
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
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubItems(Item item, CreativeTabs creativeTab, List list) {
		ItemStack itemstack = new ItemStack(this, 1, 0);
		
		NBTTagCompound tagCompound = getTagCompoundOrDefault(itemstack);
		itemstack.setTagCompound(tagCompound);
		
		list.add(itemstack);
	}
}
