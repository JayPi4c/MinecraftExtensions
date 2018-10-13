package com.JayPi4c.minecraftextensions.tabs;

import com.JayPi4c.minecraftextensions.blocks.ores.Ores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExtensionModBlocksTab extends CreativeTabs {
	public TabExtensionModBlocksTab() {
		super("MinecraftExtensions:_Blocks");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Ores.adiomantium_ore);
	}
}
