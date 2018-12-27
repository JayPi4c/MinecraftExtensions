package com.JayPi4c.minecraftextensions.blocks.ores;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Ores {

	public static Block adiomantium_ore = new BlockOre("adiomantium_ore", "adiomantium_ore", 0f, 3f, "pickaxe", 2);
	public static Block ragonid_ore = new BlockOre("ragonid_ore", "ragonid_ore", 7 / 16F, 5F, "pickaxe", 2);
	public static Block vagonid_ore = new BlockOre("vagonid_ore", "vagonid_ore", 0F, 3F, "pickaxe", 2);
	public static Block zagonid_ore = new BlockOre("zagonid_ore", "zagonid_ore", 0F, 3F, "pickaxe", 2);

	public static void init() {
		registerBlock(adiomantium_ore, adiomantium_ore.getUnlocalizedName());
		registerBlock(vagonid_ore, vagonid_ore.getUnlocalizedName());
		registerBlock(zagonid_ore, zagonid_ore.getUnlocalizedName());
		registerBlock(ragonid_ore, ragonid_ore.getUnlocalizedName());
	}

	public static void registerBlock(Block block, String BlockName) {
		GameRegistry.registerBlock(block, BlockName);
	}
}
