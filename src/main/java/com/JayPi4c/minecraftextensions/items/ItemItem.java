package com.JayPi4c.minecraftextensions.items;

import com.JayPi4c.minecraftextensions.tabs.Tabs;

import net.minecraft.item.Item;

public class ItemItem extends Item {
	protected ItemItem(String name, String texturename, int stacksize) {
		this.setUnlocalizedName(name);
		this.setTextureName("extensionmod:" + texturename);
		this.setMaxStackSize(stacksize);
		this.setCreativeTab(Tabs.tabItemsTab);
	}
}
