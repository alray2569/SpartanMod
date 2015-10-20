package com.andrewlray.mcmods.andrew_spartanmod;

import net.minecraftforge.common.MinecraftForge;

import com.andrewlray.mcmods.andrew_spartanmod.hookExtenders.CauldronExtender;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;
import com.andrewlray.mcmods.andrew_spartanmod.items.crafting.SMRecipes;
import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * The mod class for SpartanMod.
 * 
 * @author Andrew Ray
 */
@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = "1.0.2")
public class SpartanMod {

	/**
	 * The single static instance of the SpartanMod class.<br>
	 * <br>
	 * "There can only be one."
	 */
	@Mod.Instance(Constants.MODID)
	public static SpartanMod instance;

	/**
	 * The single static instance of the SpartanMod proxy. For calls made on the
	 * client side, the value is the
	 * {@linkplain com.andrewlray.mcmods.andrew_spartanmod.proxy.ClientProxy
	 * ClientProxy}. For calls made on the server side, the value is the
	 * {@linkplain com.andrewlray.mcmods.andrew_spartanmod.proxy.CommonProxy
	 * CommonProxy}.<br>
	 * <br>
	 * "Like in quantum physics, the value is unknowable until it is observed.
	 * When observed, its value changes based on its observer."
	 */
	@SidedProxy(clientSide = Constants.PROXY_CLIENT, serverSide = Constants.PROXY_COMMON)
	public static CommonProxy proxy;

	/**
	 * The EventHandler that handles FMLPreInitializationEvents. It calls the
	 * various preInit functions for the handlers, registers, and proxies in
	 * SpartanMod.<br>
	 * <br>
	 * 
	 * @param e
	 *            The {@linkplain FMLPreInitializationEvent}.
	 * @see com.andrewlray.mcmods.andrew_spartanmod.items.SMItems#preInit
	 *      SMItems.preInit()
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		SMItems.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		// Resistance is futile
		proxy.registerProxies();
		SMItems.init();
		SMRecipes.init();
		MinecraftForge.EVENT_BUS.register(new CauldronExtender());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
