package com.JayPi4c.extensionmod.blocks.ores;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Ores {

	public static Block adiomantium_ore = new BlockOre("adiomantium_ore", "adiomantium_ore", 0f, 3f, "pickaxe", 2);
	public static Block ragonid_ore = new BlockOre("ragonid_ore", "ragonid_ore", 7 / 16F, 5F, "pickaxe", 2);
	public static Block vagonid_ore = new BlockOre("vagonid_ore", "vagonid_ore", 0F, 3F, "pickaxe", 2);
	public static Block zagonid_ore = new BlockOre("zagonid_ore", "zagonid_ore", 0F, 3F, "pickaxe", 2);

	public static void init() {
		registerBlocks(adiomantium_ore, adiomantium_ore.getUnlocalizedName());
		registerBlocks(ragonid_ore, ragonid_ore.getUnlocalizedName());
		registerBlocks(vagonid_ore, vagonid_ore.getUnlocalizedName());
		registerBlocks(zagonid_ore, zagonid_ore.getUnlocalizedName());
	}

	public static void registerBlocks(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}
}
