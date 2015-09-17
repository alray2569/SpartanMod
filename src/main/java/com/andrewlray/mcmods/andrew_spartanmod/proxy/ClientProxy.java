package com.andrewlray.mcmods.andrew_spartanmod.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;
import com.andrewlray.mcmods.andrew_spartanmod.items.models.ModelHelmetF;
import com.andrewlray.mcmods.andrew_spartanmod.items.models.ModelLeatherCapF;

public class ClientProxy extends CommonProxy {
	
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	@Override
	public void registerRenderers() {
		
		ModelLeatherCapF leathercap = new ModelLeatherCapF(0.5f);
		ModelHelmetF helmet = new ModelHelmetF(0.5f);
		
		armorModels.put(SMItems.leathCapF, leathercap);
		armorModels.put(SMItems.ironHelmF, helmet);
		armorModels.put(SMItems.goldHelmF, helmet);
		armorModels.put(SMItems.diamHelmF, helmet);
		
	}
}