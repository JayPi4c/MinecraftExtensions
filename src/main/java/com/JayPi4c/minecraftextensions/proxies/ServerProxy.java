package com.JayPi4c.minecraftextensions.proxies;

import com.JayPi4c.minecraftextensions.tile_entities.TileEntityMelter;

import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	public void registerRenderThings() {

	}

	public int addArmor(String armor) {
		return 0;
	}

	public void registerNetworkStuff() {
		// NetworkRegistry.INSTANCE.registerGuiHandler(MainRegistry.modInstance, new
		// TMGuiHandler());
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMelter.class, "TileEntityMelter");
	}
}
