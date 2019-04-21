package com.JayPi4c.minecraftextensions.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

public class Tools {

	// toolmaterials:
	public static ToolMaterial adiomantiumToolMaterial = EnumHelper.addToolMaterial("adiomantiumtoolmaterial", 2, 300,
			5, 4, 3);
	// Tools:
	// Adiomantium Tools:
	public static ItemPickaxe adiomantium_pickaxe = new ItemPickaxeItem("adiomantium_pickaxe", "adiomantium_pickaxe",
			adiomantiumToolMaterial);
	public static ItemAxe adiomantium_axe = new ItemAxeItem("adiomantium_axe", "adiomantium_axe",
			adiomantiumToolMaterial);
	public static ItemSpade adiomantium_shovel = new ItemShovelItem("adiomantium_shovel", "adiomantium_shovel",
			adiomantiumToolMaterial);
	public static ItemHoe adiomantium_hoe = new ItemHoeItem("adiomantium_hoe", "adiomantium_hoe",
			adiomantiumToolMaterial);
	public static ItemSword adiomantium_sword = new ItemSwordItem("adiomantium_sword", "adiomantium_sword",
			adiomantiumToolMaterial);
	public static ItemTool adiomantium_pickaxe_axe = new ItemPickaxeAxeItem("adiomantium_pickaxe_axe",
			"adiomantium_pickaxe_axe", adiomantiumToolMaterial);

	// Teleporter:
	public static ItemTeleporter teleporter = new ItemTeleporter("teleporter", "teleporter");

	public static void init() {
		registerToolItem(adiomantium_pickaxe, adiomantium_pickaxe.getUnlocalizedName());
		registerToolItem(adiomantium_axe, adiomantium_axe.getUnlocalizedName());
		registerToolItem(adiomantium_hoe, adiomantium_hoe.getUnlocalizedName());
		registerToolItem(adiomantium_shovel, adiomantium_shovel.getUnlocalizedName());
		registerToolItem(adiomantium_sword, adiomantium_sword.getUnlocalizedName());
		registerToolItem(adiomantium_pickaxe_axe, adiomantium_pickaxe_axe.getUnlocalizedName());
		registerToolItem(teleporter, teleporter.getUnlocalizedName());
	}

	public static void registerToolItem(Item Item, String ItemName) {
		GameRegistry.registerItem(Item, ItemName);
	}
}
