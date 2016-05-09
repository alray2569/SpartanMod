package com.andrewlray.mcmods.andrew_spartanmod.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class SMItems {

	/** true iff this class has been preinitialized. */
	private static boolean preinitialized = false;
	
	/** true iff this class has been initialized. */
	private static boolean initialized = false;

	/** 
	 * The armor material for the feathered leather cap 
	 */
	public static ArmorMaterial leatherF = EnumHelper.addArmorMaterial("LeatherF", 5, new int[] { 1, 3, 2, 1 }, 15);
	
	/** The armor material for the feathered iron helmet. */
	public static ArmorMaterial ironF = EnumHelper.addArmorMaterial("IronF", 15, new int[] { 2, 6, 5, 2 }, 9);
	
	/** The armor material for the feathered gold helmet. */
	public static ArmorMaterial goldF = EnumHelper.addArmorMaterial("GoldF", 7,	new int[] { 2, 5, 3, 1 }, 25);
	
	/** The armor material for the feathered diamond helmet. */
	public static ArmorMaterial diamondF = EnumHelper.addArmorMaterial("DiamondF", 33, new int[] { 3, 8, 6, 3 }, 10);

	/** 
	 * The feathered leather cap. 
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldLeathCapF;
	
	/** 
	 * The feathered iron helmet. 
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldIronHelmF;
	
	/** 
	 * The feathered gold helmet.
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldGoldHelmF;

	/** 
	 * The feathered diamond helmet. 
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldDiamondHelmF;
	
	/**
	 * The feathered leather helmets
	 * 
	 * @since version 1.1
	 */
	public static Item leathCapF[];
	
	/**
	 * The feathered iron helmets
	 * 
	 * @since version 1.1
	 */
	public static Item ironHelmF[];
	
	/**
	 * The feathered gold helmets
	 * 
	 * @since version 1.1
	 */
	public static Item goldHelmF[];
	
	/**
	 * The feathered diamond helmets
	 * 
	 * @since version 1.1
	 */
	public static Item diamHelmF[];
	
	/**
	 * The Colored feathers
	 * 
	 * @since version 1.1
	 */
	public static Item colored_feather;

	/**
	 * Preinitializes the SMItems class by initializing the armor materials and
	 * armor.
	 */
	public static void preInit() {
		if (!preinitialized) /* Only run once! */{

			leatherF.customCraftingMaterial = Items.leather;
			ironF.customCraftingMaterial = Items.iron_ingot;
			goldF.customCraftingMaterial = Items.gold_ingot;
			diamondF.customCraftingMaterial = Items.diamond;
			
			leathCapF = new Item[16];
			ironHelmF = new Item[16];
			goldHelmF = new Item[16];
			diamHelmF = new Item[16];
			
			for (int i = 0; i < 16; ++i) {
				leathCapF[i] = new FeatheredArmor(leatherF, 0, 0, true).setUnlocalizedName(Constants.leathCapFName + i);
				ironHelmF[i] = new FeatheredArmor(ironF, 0, 0, false).setUnlocalizedName(Constants.ironHelmFName + i);
				goldHelmF[i] = new FeatheredArmor(goldF, 0, 0, false).setUnlocalizedName(Constants.goldHelmFName + i);
				diamHelmF[i] = new FeatheredArmor(diamondF, 0, 0, false).setUnlocalizedName(Constants.diamHelmFName + i);
			}

			oldLeathCapF = new FeatheredArmor(leatherF, Constants.leathCapFID, 0, true).setUnlocalizedName(Constants.leathCapFName);
			oldIronHelmF = new FeatheredArmor(ironF, Constants.ironHelmFID, 0, false).setUnlocalizedName(Constants.ironHelmFName);
			oldGoldHelmF = new FeatheredArmor(goldF, Constants.goldHelmFID, 0, false).setUnlocalizedName(Constants.goldHelmFName);
			oldDiamondHelmF = new FeatheredArmor(diamondF, Constants.diamHelmFID, 0, false).setUnlocalizedName(Constants.diamHelmFName);
			
			colored_feather = new ColoredFeather().setUnlocalizedName(Constants.featherName);
		}
		preinitialized = true;
	}

	/**
	 * Initializes the SMItems class by registering the armor with the
	 * GameRegistry.
	 * 
	 * @see GameRegistry#registerItem(Item, String)
	 */
	public static void init() {
		if (!initialized) /* Only run once! */{
			GameRegistry.registerItem(oldLeathCapF, Constants.leathCapFName);
			GameRegistry.registerItem(oldIronHelmF, Constants.ironHelmFName);
			GameRegistry.registerItem(oldGoldHelmF, Constants.goldHelmFName);
			GameRegistry.registerItem(oldDiamondHelmF, Constants.diamHelmFName);
			
			GameRegistry.registerItem(colored_feather, Constants.featherName);
			
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(leathCapF[i], Constants.leathCapFName + i);
			}
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(ironHelmF[i], Constants.ironHelmFName + i);
			}
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(goldHelmF[i], Constants.goldHelmFName + i);
			}
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(diamHelmF[i], Constants.diamHelmFName + i);
			}
		}
		initialized = true;
	}

}
