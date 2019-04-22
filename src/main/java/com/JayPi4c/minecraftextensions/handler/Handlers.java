package com.JayPi4c.minecraftextensions.handler;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;

import cpw.mods.fml.common.network.NetworkRegistry;

public class Handlers {
	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MinecraftExtensions.instance,
				new GuiAdiomantiumCraftingTableHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(MinecraftExtensions.instance, new GuiTeleporterHandler());
	}
}
