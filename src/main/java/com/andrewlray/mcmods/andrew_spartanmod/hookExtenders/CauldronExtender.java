package com.andrewlray.mcmods.andrew_spartanmod.hookExtenders;

import org.apache.logging.log4j.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.andrewlray.mcmods.andrew_spartanmod.items.FeatheredArmor;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CauldronExtender {
	
	@SubscribeEvent
	public void blockClick(PlayerInteractEvent pie) {
		FMLLog.log(Level.INFO, "Checkpoint A.");
		if (pie.action == Action.RIGHT_CLICK_BLOCK) {
			Block block = pie.entityPlayer.worldObj.getBlock(pie.x, pie.y, pie.z);
			ItemStack item = pie.entityPlayer.getCurrentEquippedItem();
			FMLLog.log(Level.INFO, "Checkpoint A. Item in use: ", item);
			if (block == Blocks.cauldron && item != null && item.getItem() instanceof FeatheredArmor){
				FeatheredArmor farmor = (FeatheredArmor) item.getItem();
				if (farmor.getArmorMaterial() == SMItems.leatherF && pie.entityPlayer.worldObj.getBlockMetadata(pie.x, pie.y, pie.z) != 0) {
					farmor.removeColor(item);
					((BlockCauldron) block).func_150024_a(pie.entityPlayer.worldObj, pie.x, pie.y, pie.z, pie.entityPlayer.worldObj.getBlockMetadata(pie.x, pie.y, pie.z) - 1);
				}
			}
		}
	}
}
