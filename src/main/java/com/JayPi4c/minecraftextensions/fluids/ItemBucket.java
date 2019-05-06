package com.JayPi4c.minecraftextensions.fluids;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.tabs.ExtensionsModTab;

import net.minecraft.block.Block;
import net.minecraft.init.Items;

public class ItemBucket extends net.minecraft.item.ItemBucket {

	public ItemBucket(Block fluid, String name, String texturename) {
		super(fluid);
		this.setUnlocalizedName(name);
		this.setTextureName(MinecraftExtensions.MODID + ":" + texturename);
		this.setContainerItem(Items.bucket);
		this.maxStackSize = 1;
		this.setCreativeTab(ExtensionsModTab.tabItems);
	}

}
