package com.JayPi4c.minecraftextensions.blocks.apparatuses;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Apparatuses {

	public static Block adiomantium_crafting_table = new AdiomantiumCraftingTable();
	public static Block MelterActive = new BlockMelter(true);
	public static Block MelterInactive = new BlockMelter(false);

	public static void init() {
		registerBlock(adiomantium_crafting_table, adiomantium_crafting_table.getUnlocalizedName());
		registerBlock(MelterActive, "melter_active");
		registerBlock(MelterInactive, "melter_inactive");
	}

	public static void registerBlock(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}

}
