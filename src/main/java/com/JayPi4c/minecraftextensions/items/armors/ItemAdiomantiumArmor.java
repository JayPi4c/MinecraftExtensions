package com.JayPi4c.minecraftextensions.items.armors;

import com.JayPi4c.minecraftextensions.tabs.Tabs;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemAdiomantiumArmor extends ItemArmor {

	public ItemAdiomantiumArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		switch (armorType) {
		case 0:
			this.setUnlocalizedName("adiomantium_helmet");
			break;
		case 1:
			this.setUnlocalizedName("adiomantium_chestplate");
			break;
		case 2:
			this.setUnlocalizedName("adiomantium_leggings");
			break;
		case 3:
			this.setUnlocalizedName("adiomantium_boots");
			break;
		default:
			this.setUnlocalizedName("adiomantium_armor");
		}
		this.setCreativeTab(Tabs.tabArmorsTab);
		this.setTextureName("extensionmod:" + getUnlocalizedName().substring(5));

	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (slot == 0 || slot == 1 || slot == 3) {
			return "extensionmod:textures/models/armor/adiomantium_layer_1.png";
		} else if (slot == 2) {
			return "extensionmod:textures/models/armor/adiomantium_layer_2.png";
		} else {
			return null;
		}
	}

}
