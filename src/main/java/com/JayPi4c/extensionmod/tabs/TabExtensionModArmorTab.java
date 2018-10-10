package com.JayPi4c.extensionmod.tabs;

import com.JayPi4c.extensionmod.items.armors.Armors;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabExtensionModArmorTab extends CreativeTabs {

	public TabExtensionModArmorTab() {
		super("ExtensionMod:_Armor");
	}

	@Override
	public Item getTabIconItem() {
		return Armors.ItemAdiomantiumChestplate;
	}

}
