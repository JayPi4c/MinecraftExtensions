package com.JayPi4c.minecraftextensions.items.tools;

import com.JayPi4c.minecraftextensions.tabs.Tabs;

import net.minecraft.item.ItemAxe;

public class ItemAxeItem extends ItemAxe {
	protected ItemAxeItem(String name, String texturename, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName("extensionmod:" + texturename);
		this.setCreativeTab(Tabs.tabToolsTab);
	}
}
