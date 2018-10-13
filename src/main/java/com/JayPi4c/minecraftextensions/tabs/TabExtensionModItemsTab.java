package com.JayPi4c.minecraftextensions.tabs;

import com.JayPi4c.minecraftextensions.items.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExtensionModItemsTab extends CreativeTabs {
	public TabExtensionModItemsTab() {
		super("MinecraftExtensions:_Items");
	}

	@Override
	public Item getTabIconItem() {
		return Items.adiomantium_ingot;
	}
}
