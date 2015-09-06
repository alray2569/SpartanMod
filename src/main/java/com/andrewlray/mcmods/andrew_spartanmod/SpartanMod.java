package com.andrewlray.mcmods.andrew_spartanmod;

import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;
import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.proxy.CommonProxy;
import com.andrewlray.mcmods.andrew_spartanmod.proxy.SMRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = "1.0.1")
public class SpartanMod {

	@Mod.Instance(Constants.MODID)
	public static SpartanMod instance;
	
	@SidedProxy(clientSide=Constants.PROXY_CLIENT, serverSide=Constants.PROXY_COMMON)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		// Bring out the penguins
		SMItems.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		// Resistance is futile
		proxy.registerProxies();
		SMItems.init();
		SMRecipes.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}

}
