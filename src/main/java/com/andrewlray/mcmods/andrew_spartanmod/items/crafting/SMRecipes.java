package com.andrewlray.mcmods.andrew_spartanmod.items.crafting;

import com.andrewlray.mcmods.andrew_spartanmod.items.ColoredFeather;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public final class SMRecipes {
	
	private static boolean initialized = false;
	
	public static void init() {
		if (!initialized) {
			
			// Converter Recipes for old helmets.
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(SMItems.oldLeathCapF, 1, OreDictionary.WILDCARD_VALUE)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(SMItems.oldIronHelmF, 1, OreDictionary.WILDCARD_VALUE)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(SMItems.oldGoldHelmF, 1, OreDictionary.WILDCARD_VALUE)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(SMItems.oldDiamondHelmF, 1, OreDictionary.WILDCARD_VALUE)));
			
			// Recipes for new helmets using SMItems.colored_feather
			for (int i = 0; i < ColoredFeather.SUBS; ++i) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.leathCapF[i], 1, 0), new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.ironHelmF[i], 1, 0), new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.goldHelmF[i], 1, 0), new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.diamHelmF[i], 1, 0), new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
			}
			
			// Recipes for new helmets using Items.feather
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.leathCapF[15], 1, 0), new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(Items.feather, 1, 0)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.ironHelmF[15], 1, 0), new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(Items.feather, 1, 0)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.goldHelmF[15], 1, 0), new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(Items.feather, 1, 0)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.diamHelmF[15], 1, 0), new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(Items.feather, 1, 0)));
		
			// Recipes for colored feathers
			for (int i = 0; i < ColoredFeather.SUBS; ++i) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.colored_feather, 1, i), new ItemStack(Items.feather, 1), new ItemStack(Items.dye, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.colored_feather, 1, i), new ItemStack(SMItems.colored_feather, 1), new ItemStack(Items.dye, 1, i)));
			}
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.feather, 1), new ItemStack(SMItems.colored_feather, 1), new ItemStack(Items.dye, 1, 15)));
			
			// Dye Converters
			String colorNames[] = new String[] { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };
			for (int i = 0; i < ItemDye.field_150921_b.length; ++i) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.dye, 1, i), "dye" + colorNames[i]));
			}
			
		}
		initialized = true;
	}
}
