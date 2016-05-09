package com.andrewlray.mcmods.andrew_spartanmod.achievement;

import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;
import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.lib.SMUtil;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

/**
 * Handles all SpartanMod achievements.
 * 
 * @author Andrew Ray
 * @since version 1.1.0.1
 */
public class SMAchievements extends FMLCommonHandler {
	
	/**
	 * Singleton instance of this class
	 */
	public static SMAchievements instance;

	/** 
	 * True if this has been initialized
	 */
	private static boolean initialized = false;
	
	/**
	 * Achievement earned by crafting a feathered cap.
	 * 
	 * @since version 1.1.0.1
	 */
	public static Achievement macaroni;
	
	/**
	 * For macaroni icon.
	 */
	private static Item macicon;
	
	/**
	 * Achievement earned by crafting a feathered helm.
	 * 
	 * @since version 1.1.0.1
	 */
	public static Achievement sparta;
	
	/**
	 * Achievement earned by crafting a feathered gold helm.
	 * 
	 * @since version 1.1.0.1
	 */
	public static Achievement goldhelm;
	
	/**
	 * Achievement earned by crafting a feathered diamond helm.
	 * 
	 * @since version 1.1.0.1
	 */
	public static Achievement corps;
	
	/**
	 * Achievement Page for SpartanMod
	 * 
	 * @since version 1.1.0.1
	 */
	public static AchievementPage smAchievements;
	
	/**
	 * Initializes the achievements and the achievement page.
	 */
	public static void init() {
		if (!initialized) {
			
			// define the macicon
			macicon = new Item();
			macicon.setUnlocalizedName("macicon");
			macicon.setTextureName(Constants.MODID + ":" + SMUtil.getUnwrappedUnlocalizedName(macicon.getUnlocalizedName()));
			GameRegistry.registerItem(macicon, "macicon");
			
			macaroni = new Achievement("achievement.macaroni", "macaroni", -2, 0, macicon, AchievementList.buildWorkBench).registerStat();
			sparta = new Achievement("achievement.sparta", "sparta", 2, 0, SMItems.oldIronHelmF, AchievementList.acquireIron).registerStat();
			goldhelm = new Achievement("achievement.goldhelm", "goldhelm", 0, -2, SMItems.oldGoldHelmF, AchievementList.acquireIron).registerStat();
			corps = new Achievement("achievement.corps", "corps", 0, 2, SMItems.oldDiamondHelmF, AchievementList.diamonds).registerStat();
			
			smAchievements = new AchievementPage(Constants.MODNAME, new Achievement[] { macaroni, sparta, goldhelm, corps });
			AchievementPage.registerAchievementPage(smAchievements);
			
			initialized = true;
		}
	}
}
