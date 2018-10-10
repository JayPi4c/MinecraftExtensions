package com.JayPi4c.extensionmod.blocks.apparatuses;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Apparatuses {

	public static void init() {
	}

	public static void registerBlocks(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}

}
