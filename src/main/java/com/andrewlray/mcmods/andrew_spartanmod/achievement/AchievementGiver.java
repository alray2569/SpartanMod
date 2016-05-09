package com.andrewlray.mcmods.andrew_spartanmod.achievement;

import org.apache.logging.log4j.Level;

import com.andrewlray.mcmods.andrew_spartanmod.SpartanMod;
import com.andrewlray.mcmods.andrew_spartanmod.items.FeatheredArmor;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.init.Items;

/**
 * Gives achievements when they should be given.
 * 
 * @author Andrew Ray
 * @since version 1.1.0.1
 */
public class AchievementGiver {

	private static boolean initialized = false;
	
	public static void init() {
		if (!initialized) {
			FMLCommonHandler.instance().bus().register(new AchievementGiver.OnCraftEvent());
			SpartanMod.log(Level.INFO, "OnCraftEvent has been registered with FMLCommonHandler's eventbus.");
		}
	}
	
	/**
	 * Called when an item is crafted.
	 * 
	 * @author Andrew Ray
	 * @since 1.1.0.1
	 */
	public static class OnCraftEvent {
		
		/**
		 * Called when an item is crafted.
		 * 
		 * @param e The crafting event that triggered the function call
		 */
		@SubscribeEvent
		public void whenCrafted(PlayerEvent.ItemCraftedEvent e) {
			if (e.crafting.getItem() instanceof FeatheredArmor) {
				FeatheredArmor farmor = (FeatheredArmor) e.crafting.getItem();
				if (farmor.isLeather) {
					e.player.addStat(SMAchievements.macaroni, 1);
				} else if (farmor.getArmorMaterial().customCraftingMaterial == Items.iron_ingot) {
					e.player.addStat(SMAchievements.sparta, 1);
				} else if (farmor.getArmorMaterial().customCraftingMaterial == Items.gold_ingot) {
					e.player.addStat(SMAchievements.goldhelm, 1);
				} else if (farmor.getArmorMaterial().customCraftingMaterial == Items.diamond) {
					e.player.addStat(SMAchievements.corps, 1);
				}
			}
		}
	}
}
