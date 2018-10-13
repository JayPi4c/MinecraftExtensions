package com.JayPi4c.minecraftextensions.tabs;

import com.JayPi4c.minecraftextensions.items.tools.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExtensionModToolsTab extends CreativeTabs {
	public TabExtensionModToolsTab() {
		super("MinecraftExtensions:_Tools");
	}

	@Override
	public Item getTabIconItem() {
		return Tools.adiomantium_pickaxe;
	}
}
