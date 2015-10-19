package com.andrewlray.mcmods.andrew_spartanmod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.lib.SMUtil;
import com.andrewlray.mcmods.andrew_spartanmod.proxy.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FeatheredArmor
		extends ItemArmor {

	@SideOnly(Side.CLIENT)
	private IIcon overlayIcon;
	@SideOnly(Side.CLIENT)
	private IIcon emptySlotIcon;

	public FeatheredArmor(ArmorMaterial material, int id, int slot) {
		super(material, id, slot);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
		this.setTextureName(Constants.MODID + ":" + SMUtil.getUnwrappedUnlocalizedName(getUnlocalizedName()));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (slot == 0 && layer == null) {
			String name = SMUtil.getUnwrappedUnlocalizedName(this.getUnlocalizedName());
			return String.format("%s:textures/model/%s.png", Constants.MODID, name);
		}
		if (slot == 0 && layer == "overlay" && this.getArmorMaterial() == SMItems.leatherF) {
			String name = SMUtil.getUnwrappedUnlocalizedName(this.getUnlocalizedName());
			return String.format("%s:textures/model/%s_overlay.png", Constants.MODID, name);
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(SMUtil.getResourceName(this));

		if (this.getArmorMaterial() == SMItems.leatherF)
		{
			this.overlayIcon = iconRegister.registerIcon(SMUtil.getResourceName(this) + "_overlay");
		}

		this.emptySlotIcon = iconRegister.registerIcon("empty_armor_slot_helmet");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot) {
		ModelBiped model = ClientProxy.armorModels.get(this);

		// Fix various stuff
		if (entityLiving != null) {
			model.isSneak = entityLiving.isSneaking();
			model.isRiding = entityLiving.isRiding();
			model.isChild = entityLiving.isChild();
		}

		return model;
	}

	/**
	 * Gets an icon index based on an item's damage value and the given render
	 * pass
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int damage, int pass)
	{
		return pass == 1 ? this.overlayIcon : super.getIconFromDamageForRenderPass(damage, pass);
	}

	@Override
	public boolean hasColor(ItemStack stack) {
		return this.getArmorMaterial() != SMItems.leatherF ? false : (!stack.hasTagCompound() ? false : (!stack.getTagCompound().hasKey("display", 10) ? false : stack.getTagCompound().getCompoundTag("display").hasKey("color", 3)));
	}

	@Override
	public int getColor(ItemStack stack) {
		if (this.getArmorMaterial() == SMItems.leatherF) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null)
				return 10511680;
			NBTTagCompound nbt1 = nbt.getCompoundTag("display");
			return nbt1 == null ? 10511680 : (nbt1.hasKey("color", 3) ? nbt1.getInteger("color") : 10511680);
		}

		return -1;
	}

	@Override
	public void func_82813_b(ItemStack stack, int color) {
		if (this.getArmorMaterial() != SMItems.leatherF) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
				stack.setTagCompound(nbt);
			}

			NBTTagCompound nbt1 = nbt.getCompoundTag("display");

			if (!nbt.hasKey("display", 10))
				nbt.setTag("display", nbt1);

			nbt1.setInteger("color", color);
		}
	}

	@Override
	public void removeColor(ItemStack stack) {
		if (this.getArmorMaterial() == SMItems.leatherF)
		{
			NBTTagCompound nbttagcompound = stack.getTagCompound();

			if (nbttagcompound != null)
			{
				NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

				if (nbttagcompound1.hasKey("color"))
				{
					nbttagcompound1.removeTag("color");
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return this.getArmorMaterial() == SMItems.leatherF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int x) {
		if (x > 0) {
			return 16777215;
		} else {
			int j = this.getColor(stack);
			if (j < 0) {
				j = 16777215;
			}
			return j;
		}
	}
}
