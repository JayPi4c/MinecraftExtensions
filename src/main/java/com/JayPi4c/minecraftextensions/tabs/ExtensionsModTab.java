package com.JayPi4c.minecraftextensions.tabs;

import com.JayPi4c.minecraftextensions.blocks.ores.Ores;
import com.JayPi4c.minecraftextensions.items.Items;
import com.JayPi4c.minecraftextensions.items.armors.Armors;
import com.JayPi4c.minecraftextensions.items.tools.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExtensionsModTab extends CreativeTabs {
	public static final CreativeTabs tabBlocks = new ExtensionsModTab("MinecraftExtensions:_Blocks");
	public static final CreativeTabs tabItems = new ExtensionsModTab("MinecraftExtensions:_Items");
	public static final CreativeTabs tabTools = new ExtensionsModTab("MinecraftExtensions:_Tools");
	public static final CreativeTabs tabArmors = new ExtensionsModTab("MinecraftExtensions:_Armor");

	public ExtensionsModTab(String name) {
		super(name);

	}

	@Override
	public Item getTabIconItem() {
		Item icon = Items.adiomantium_dust;
		if (this.getTabLabel() == "MinecraftExtensions:_Blocks")
			icon = Item.getItemFromBlock(Ores.adiomantium_ore);
		else if (this.getTabLabel() == "MinecraftExtensions:_Items")
			icon = Items.adiomantium_ingot;
		else if (this.getTabLabel() == "MinecraftExtensions:_Tools")
			icon = Tools.adiomantium_pickaxe;
		else if (this.getTabLabel() == "MinecraftExtensions:_Armor")
			icon = Armors.ItemAdiomantiumChestplate;
		return icon;
	}
}
