package com.JayPi4c.extensionmod.items.tools;

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

	public static void init() {
		registerToolItems(adiomantium_pickaxe, adiomantium_pickaxe.getUnlocalizedName());
		registerToolItems(adiomantium_axe, adiomantium_axe.getUnlocalizedName());
		registerToolItems(adiomantium_hoe, adiomantium_hoe.getUnlocalizedName());
		registerToolItems(adiomantium_shovel, adiomantium_shovel.getUnlocalizedName());
		registerToolItems(adiomantium_sword, adiomantium_sword.getUnlocalizedName());
		registerToolItems(adiomantium_pickaxe_axe, adiomantium_pickaxe_axe.getUnlocalizedName());
	}

	public static void registerToolItems(Item Item, String ItemName) {
		GameRegistry.registerItem(Item, ItemName);
	}
}
