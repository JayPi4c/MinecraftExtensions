package com.JayPi4c.minecraftextensions.items.tools;

import com.JayPi4c.minecraftextensions.tabs.Tabs;

import net.minecraft.item.ItemSword;

public class ItemSwordItem extends ItemSword {
	protected ItemSwordItem(String name, String texturename, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName("extensionmod:" + texturename);
		this.setCreativeTab(Tabs.tabToolsTab);
	}
}
