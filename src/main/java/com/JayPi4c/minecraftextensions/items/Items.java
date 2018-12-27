package com.JayPi4c.minecraftextensions.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items {
	// Adiomantium:
	public static Item adiomantium_ingot = new ItemItem("adiomantium_ingot", "adiomantium_ingot", 64);
	public static Item adiomantium_dust = new ItemItem("adiomantium_dust", "adiomantium_dust", 64);

	public static Item adiomantium_core = new ItemItem("adiomantium_core", "adiomantium_core", 64);
	public static Item adiomantium_multicore = new ItemItem("adiomantium_multicore", "adiomantium_multicore", 8);
	public static Item adiomantium_multitoolblade = new ItemItem("adiomantium_multitoolblade",
			"adiomantium_multitoolblade", 1);
	public static Item compressed_adiomantium_core_fragment = new ItemItem("compressed_adiomantium_core_fragment",
			"compressed_adiomantium_core_fragment", 64);
	public static Item compressed_adiomantium_core = new ItemItem("compressed_adiomantium_core",
			"compressed_adiomantium_core", 64);

	// Vagonid:
	public static Item vagonid_dust = new ItemItem("vagonid_dust", "vagonid_dust", 64);
	public static Item vagonid_ingot = new ItemItem("vagonid_ingot", "vagonid_ingot", 64);

	// Zagonid:
	public static Item zagonid_dust = new ItemItem("zagonid_dust", "zagonid_dust", 64);
	public static Item zagonid_ingot = new ItemItem("zagonid_ingot", "zagonid_ingot", 64);

	// miscellaneous:
	public static Item leather_handle = new ItemItem("leather_handle", "leather_handle", 64);
	public static Item toolrod = new ItemItem("toolrod", "toolrod", 64);
	public static Item raw_teleporter = new ItemItem("raw_teleporter", "raw_teleporter", 64);

	public static Item vazaad_dust = new ItemItem("vazaad_dust", "vazaad_dust", 64);

	public static void init() {
		registerItem(adiomantium_dust, adiomantium_dust.getUnlocalizedName());
		registerItem(adiomantium_ingot, adiomantium_ingot.getUnlocalizedName());
		registerItem(vagonid_dust, vagonid_dust.getUnlocalizedName());
		registerItem(vagonid_ingot, vagonid_ingot.getUnlocalizedName());
		registerItem(zagonid_dust, zagonid_dust.getUnlocalizedName());
		registerItem(zagonid_ingot, zagonid_ingot.getUnlocalizedName());
		registerItem(adiomantium_core, adiomantium_core.getUnlocalizedName());
		registerItem(adiomantium_multicore, adiomantium_multicore.getUnlocalizedName());
		registerItem(adiomantium_multitoolblade, adiomantium_multitoolblade.getUnlocalizedName());
		registerItem(compressed_adiomantium_core, compressed_adiomantium_core.getUnlocalizedName());
		registerItem(compressed_adiomantium_core_fragment, compressed_adiomantium_core_fragment.getUnlocalizedName());
		registerItem(leather_handle, leather_handle.getUnlocalizedName());
		registerItem(toolrod, toolrod.getUnlocalizedName());
		registerItem(raw_teleporter, raw_teleporter.getUnlocalizedName());
		registerItem(vazaad_dust, vazaad_dust.getUnlocalizedName());
	}

	public static void registerItem(Item Item, String ItemName) {
		GameRegistry.registerItem(Item, ItemName);
	}
}
