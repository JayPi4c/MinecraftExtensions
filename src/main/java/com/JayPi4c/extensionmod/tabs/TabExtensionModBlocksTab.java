package com.JayPi4c.extensionmod.tabs;

import com.JayPi4c.extensionmod.blocks.ores.Ores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExtensionModBlocksTab extends CreativeTabs {
	public TabExtensionModBlocksTab() {
		super("ExtensionMod:_Blocks");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Ores.adiomantium_ore);
	}
}
