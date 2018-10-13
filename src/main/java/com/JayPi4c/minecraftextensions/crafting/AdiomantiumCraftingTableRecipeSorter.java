package com.JayPi4c.minecraftextensions.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

@SuppressWarnings("rawtypes")
public class AdiomantiumCraftingTableRecipeSorter implements Comparator {

	final AdiomantiumCraftingTableCraftingManager adiomantium_crafting_table;

	public AdiomantiumCraftingTableRecipeSorter(AdiomantiumCraftingTableCraftingManager cm) {
		this.adiomantium_crafting_table = cm;
	}

	public int compareRecipes(IRecipe recipe1, IRecipe recipe2) {
		if (recipe1 instanceof AdiomantiumCraftingTableShapelessRecipes
				&& recipe2 instanceof AdiomantiumCraftingTableShapedRecipes)
			return 1;
		else if (recipe2 instanceof AdiomantiumCraftingTableShapelessRecipes
				&& recipe1 instanceof AdiomantiumCraftingTableShapedRecipes)
			return -1;
		else if (recipe2.getRecipeSize() < recipe1.getRecipeSize())
			return -1;
		else if (recipe2.getRecipeSize() > recipe1.getRecipeSize())
			return 1;
		return 0;

		// return recipe1 instanceof AdiomantiumCraftingTableShapelessRecipe && recipe2
		// instanceof AdiomantiumCraftingTableShapedRecipe ? 1
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		return compareRecipes((IRecipe) obj1, (IRecipe) obj2);
	}

}
