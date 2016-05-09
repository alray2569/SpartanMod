package com.andrewlray.mcmods.andrew_spartanmod.hookExtenders;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.andrewlray.mcmods.andrew_spartanmod.items.FeatheredArmor;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Forge Hooks for using a cauldron to remove dye from a leather feathered cap.
 * 
 * @author Andrew Ray
 * @see MinecraftForge
 * @see SubscribeEvent
 */
public class PlayerInteractEventHookExtender {

	/** true iff this class has been initialized. */
	private static boolean init = false;

	/**
	 * ForgeHook for {@linkplain PlayerInteractEvent}. If a player interacts
	 * with a block, this function is called. If the player has right-clicked on
	 * a non-empty cauldron with a dyed feathered leather cap, the color is
	 * removed from the cap and the water level is decreased.
	 * 
	 * @param pie The PlayerInteractionEvent
	 * @see PlayerInteractEvent
	 * @see BlockCauldron#func_150024_a(World, int, int, int, int)
	 * @see FeatheredArmor#removeColor(ItemStack)
	 */
	@SubscribeEvent
	public void blockClick(PlayerInteractEvent pie) {
		if (pie.action == Action.RIGHT_CLICK_BLOCK) {
			Block block = pie.world.getBlock(pie.x, pie.y, pie.z);
			if (block == Blocks.cauldron) {
				cauldron_onRightClick(pie, (BlockCauldron) block, pie.world.getBlockMetadata(pie.x, pie.y, pie.z));
			}
		}
	}
	
	private static void cauldron_onRightClick(PlayerInteractEvent pie, BlockCauldron cauldron, int meta) {
		ItemStack item = pie.entityPlayer.getCurrentEquippedItem();
		if (item != null && item.getItem() instanceof FeatheredArmor) {
			FeatheredArmor farmor = (FeatheredArmor) item.getItem();
			if (farmor.isLeather && farmor.hasColor(item) && meta != 0) {
				farmor.removeColor(item);
				cauldron.func_150024_a(pie.world, pie.x, pie.y, pie.z, meta - 1);
			}
		}
	}

	/**
	 * Initializes the PlayerInteractEventHookExtender and registers it with the Forge Event
	 * bus.
	 * 
	 * @see cpw.mods.fml.common.eventhandler.EventBus#register(Object)
	 *      EventBus.register(Object)
	 */
	public static void init() {
		if (!init) {
			MinecraftForge.EVENT_BUS.register(new PlayerInteractEventHookExtender());
		}
		init = true;
	}
}
