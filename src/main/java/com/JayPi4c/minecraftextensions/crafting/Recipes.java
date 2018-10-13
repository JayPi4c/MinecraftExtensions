package com.JayPi4c.minecraftextensions.crafting;

import com.JayPi4c.minecraftextensions.blocks.Blocks;
import com.JayPi4c.minecraftextensions.blocks.apparatuses.Apparatuses;
import com.JayPi4c.minecraftextensions.items.Items;
import com.JayPi4c.minecraftextensions.items.tools.Tools;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class Recipes {
	public static void init() {
		// shapeless recipe:
		GameRegistry.addShapelessRecipe(new ItemStack(Items.adiomantium_ingot, 9), Blocks.adiomantium_block);
		// recipe:
		GameRegistry.addRecipe(new ItemStack(Blocks.adiomantium_block), "###", "###", "###", '#',
				new ItemStack(Items.adiomantium_ingot));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_sword), "#", "#", "*", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_hoe), "##", "* ", "* ", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_hoe), "##", " *", " *", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_shovel), "#", "*", "*", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_pickaxe), "###", " * ", " * ", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_axe), "## ", "#* ", " * ", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_axe), " ##", " *#", " * ", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(net.minecraft.init.Items.stick));
		GameRegistry.addRecipe(new ItemStack(Items.leather_handle), "#", "#", '#',
				new ItemStack(net.minecraft.init.Items.leather));
		GameRegistry.addRecipe(new ItemStack(Items.adiomantium_core), "#*#", "*+*", "#*#", '#',
				new ItemStack(Items.adiomantium_dust), '*', new ItemStack(Items.adiomantium_ingot), '+',
				new ItemStack(net.minecraft.init.Items.iron_ingot));
		GameRegistry.addRecipe(new ItemStack(Items.toolrod), "#", "*", '#',
				new ItemStack(net.minecraft.init.Items.stick), '*', new ItemStack(Items.leather_handle));
		GameRegistry.addRecipe(new ItemStack(Items.adiomantium_multitoolblade), "## ", "#*#", "#  ", '#',
				new ItemStack(Items.adiomantium_ingot), '*', new ItemStack(Items.adiomantium_core));
		GameRegistry.addRecipe(new ItemStack(Tools.adiomantium_pickaxe_axe), "#", "*", '#',
				new ItemStack(Items.adiomantium_multitoolblade), '*', new ItemStack(Items.toolrod));
		GameRegistry.addRecipe(new ItemStack(Items.compressed_adiomantium_core), "##", "##", '#',
				new ItemStack(Items.compressed_adiomantium_core_fragment));
		GameRegistry.addRecipe(new ItemStack(Items.adiomantium_multicore), "*#*", "#+#", "*#*", '*',
				new ItemStack(Items.compressed_adiomantium_core_fragment), '#',
				new ItemStack(Items.compressed_adiomantium_core), '+', new ItemStack(Items.adiomantium_core));
		GameRegistry.addRecipe(new ItemStack(Apparatuses.adiomantium_crafting_table), "##", "##", '#',
				new ItemStack(Blocks.adiomantium_block));
		// smelting:
		GameRegistry.addSmelting(Items.adiomantium_dust, new ItemStack(Items.adiomantium_ingot), 200);
		GameRegistry.addSmelting(Items.vagonid_dust, new ItemStack(Items.vagonid_ingot), 450);
		GameRegistry.addSmelting(Items.zagonid_dust, new ItemStack(Items.zagonid_ingot), 450);
		GameRegistry.addSmelting(Items.adiomantium_core, new ItemStack(Items.compressed_adiomantium_core_fragment),
				220);

	}
}
