package com.andrewlray.mcmods.andrew_spartanmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.*;

public class SMItems {

	private static boolean preinitialized = false;
	private static boolean initialized = false;

	public static ArmorMaterial leatherF = EnumHelper.addArmorMaterial("LeatherF", 5, new int[] { 1, 3, 2, 1 }, 15);
	public static ArmorMaterial ironF = EnumHelper.addArmorMaterial("IronF", 15, new int[] { 2, 6, 5, 2 }, 9);
	public static ArmorMaterial goldF = EnumHelper.addArmorMaterial("GoldF", 7,	new int[] { 2, 5, 3, 1 }, 25);
	public static ArmorMaterial diamondF = EnumHelper.addArmorMaterial("DiamondF", 33, new int[] { 3, 8, 6, 3 }, 10);

	public static Item leathCapF;
	public static Item ironHelmF;
	public static Item goldHelmF;
	public static Item diamHelmF;
	public static Item chain;

	public static void preInit() {
		if (!preinitialized) /* Only run once! */{

			leathCapF = new FeatheredArmor(leatherF, leathCapFID, 0).setUnlocalizedName(leathCapFName);
			ironHelmF = new FeatheredArmor(ironF, ironHelmFID, 0).setUnlocalizedName(ironHelmFName);
			goldHelmF = new FeatheredArmor(goldF, goldHelmFID, 0).setUnlocalizedName(goldHelmFName);
			diamHelmF = new FeatheredArmor(diamondF, diamHelmFID, 0).setUnlocalizedName(diamHelmFName);
		}
		preinitialized = true;
	}

	public static void init() {
		if (!initialized) /* Only run once! */{
			GameRegistry.registerItem(leathCapF, leathCapFName);
			GameRegistry.registerItem(ironHelmF, ironHelmFName);
			GameRegistry.registerItem(goldHelmF, goldHelmFName);
			GameRegistry.registerItem(diamHelmF, diamHelmFName);
		}
		initialized = true;
	}

}
