package com.andrewlray.mcmods.andrew_spartanmod.items;

import java.util.List;

import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.lib.SMUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class ColoredFeather
		extends Item {
	
	public static final int SUBS = 15;
	
	private IIcon icons[];
	
	/**
	 * Creates a new instance of ColoredFeather
	 */
	public ColoredFeather() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	/**
	 * Returns the unlocalized name of this item.
	 */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getItemDamage();
		return super.getUnlocalizedName() + "." + ItemDye.field_150923_a[i];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        for (int i = 0; i < SUBS; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IIconRegister iconRegister)
    {
        this.icons = new IIcon[SUBS];

        for (int i = 0; i < SUBS; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(Constants.MODID + ":" + SMUtil.getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_" + ItemDye.field_150923_a[i]);
        }
    }
	
	/**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        int j = MathHelper.clamp_int(damage, 0, 15);
        return this.icons[j];
    }
}
