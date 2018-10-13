package com.JayPi4c.minecraftextensions.blocks.apparatuses;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Apparatuses {

	public static Block adiomantium_crafting_table = new AdiomantiumCraftingTable();
	public static final int ADIOMANTIUM_CRAFTING_TABLE_GUI_ID = 42;

	public static void init() {
		registerBlocks(adiomantium_crafting_table, adiomantium_crafting_table.getUnlocalizedName());
	}

	public static void registerBlocks(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}

}
