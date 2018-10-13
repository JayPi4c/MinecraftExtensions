package com.JayPi4c.minecraftextensions.items.armors;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Armors {
	public static ArmorMaterial adiomantiumArmorMaterial = EnumHelper.addArmorMaterial("adiomantiumarmormaterial", 300,
			new int[] { 2, 6, 5, 2 }, 3);
	public static ItemArmor ItemAdiomantiumHelmet = new ItemAdiomantiumArmor(adiomantiumArmorMaterial, 0, 0);
	public static ItemArmor ItemAdiomantiumChestplate = new ItemAdiomantiumArmor(adiomantiumArmorMaterial, 0, 1);
	public static ItemArmor ItemAdiomantiumLeggings = new ItemAdiomantiumArmor(adiomantiumArmorMaterial, 0, 2);
	public static ItemArmor ItemAdiomantiumBoots = new ItemAdiomantiumArmor(adiomantiumArmorMaterial, 0, 3);

	public static void init() {
		registerArmorItems(ItemAdiomantiumHelmet, ItemAdiomantiumHelmet.getUnlocalizedName());
		registerArmorItems(ItemAdiomantiumChestplate, ItemAdiomantiumChestplate.getUnlocalizedName());
		registerArmorItems(ItemAdiomantiumLeggings, ItemAdiomantiumLeggings.getUnlocalizedName());
		registerArmorItems(ItemAdiomantiumBoots, ItemAdiomantiumBoots.getUnlocalizedName());

	}

	public static void registerArmorItems(Item Item, String ItemName) {
		GameRegistry.registerItem(Item, ItemName);
	}
}
