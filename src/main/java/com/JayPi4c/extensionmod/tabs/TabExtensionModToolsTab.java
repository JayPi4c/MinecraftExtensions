package com.JayPi4c.extensionmod.tabs;

import com.JayPi4c.extensionmod.items.tools.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExtensionModToolsTab extends CreativeTabs {
	public TabExtensionModToolsTab() {
		super("ExtensionMod:_Tools");
	}

	@Override
	public Item getTabIconItem() {
		return Tools.adiomantium_pickaxe;
	}
}
