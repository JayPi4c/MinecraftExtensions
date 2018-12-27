package com.JayPi4c.minecraftextensions.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {
	public static Block adiomantium_block = new BlockBlock("adiomantium_block", "adiomantium_block",
			Block.soundTypeMetal, 0F, 5F, Material.iron, "pickaxe", 1);
	public static Block deko_leaves = new BlockDekoLeaves("deko_leaves", "deko_leaves", Block.soundTypeGrass, 0F, 0.8F,
			Material.leaves, "shears", 0);

	public static void init() {
		registerBlock(adiomantium_block, adiomantium_block.getUnlocalizedName());
		registerBlock(deko_leaves, deko_leaves.getUnlocalizedName());
	}

	public static void registerBlock(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}

}
