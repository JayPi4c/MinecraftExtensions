package com.JayPi4c.extensionmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {
	public static Block adiomantium_block = new BlockBlock("adiomantium_block", "adiomantium_block",
			Block.soundTypeMetal, 0F, 5F, Material.iron, "pickaxe", 1);

	public static void init() {
		registerBlocks(adiomantium_block, adiomantium_block.getUnlocalizedName());
	}

	public static void registerBlocks(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}

}
