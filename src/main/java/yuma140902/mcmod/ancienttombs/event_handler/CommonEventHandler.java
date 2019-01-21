package yuma140902.mcmod.ancienttombs.event_handler;

import java.util.Random;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import yuma140902.mcmod.ancienttombs.ModAncientTombs;
import yuma140902.mcmod.ancienttombs.ModConfigCore;
import yuma140902.mcmod.ancienttombs.items.ModItems;

public class CommonEventHandler {
	private CommonEventHandler() {}
	
	public static final CommonEventHandler INSTANCE = new CommonEventHandler();
	
	@SubscribeEvent
	public void onUseHoeEvent(UseHoeEvent event) {
		int x = event.x;
		int y = event.y;
		int z = event.z;
		World world = event.world;
		EntityPlayer player = event.entityPlayer;
		Random rand = event.world.rand;
		
		if(world.getBlock(x, y, z) != Blocks.farmland && rand.nextInt(ModConfigCore.goldenSealRarity) == 0) {
			if(!world.isRemote) {
				EntityItem goldenSeal = new EntityItem(world, x + 0.5D, y + 1.5D, z + 0.5D, new ItemStack(ModItems.goldenSeal));
				world.spawnEntityInWorld(goldenSeal);
			}
		}
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(ModAncientTombs.MOD_ID.equals(event.modID))
			ModConfigCore.syncConfig();
	}
}
