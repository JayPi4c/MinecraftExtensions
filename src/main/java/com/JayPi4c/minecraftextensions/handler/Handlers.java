package com.JayPi4c.minecraftextensions.handler;

import com.JayPi4c.minecraftextensions.ExtensionMod;

import cpw.mods.fml.common.network.NetworkRegistry;

public class Handlers {
	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtensionMod.instance, new GuiHandler());
	}
}