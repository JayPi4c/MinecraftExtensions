package com.JayPi4c.minecraftextensions.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AdiomantiumCraftingTableShapelessRecipes implements IRecipe {
	/** Is the ItemStack that you get when craft the recipe. */
	private final ItemStack recipeOutput;
	/** Is a List of ItemStack that composes the recipe. */
	@SuppressWarnings("rawtypes")
	public final List recipeItems;
	@SuppressWarnings("unused")
	private static final String __OBFID = "CL_00000094";

	public AdiomantiumCraftingTableShapelessRecipes(ItemStack p_i1918_1_,
			@SuppressWarnings("rawtypes") List p_i1918_2_) {
		this.recipeOutput = p_i1918_1_;
		this.recipeItems = p_i1918_2_;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean matches(InventoryCrafting p_77569_1_, World p_77569_2_) {
		@SuppressWarnings({ "unchecked" })
		ArrayList arraylist = new ArrayList(this.recipeItems);

		// Anpassen an die Größe des Tables!!!!
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				ItemStack itemstack = p_77569_1_.getStackInRowAndColumn(j, i);

				if (itemstack != null) {
					boolean flag = false;
					Iterator iterator = arraylist.iterator();

					while (iterator.hasNext()) {
						ItemStack itemstack1 = (ItemStack) iterator.next();

						if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767
								|| itemstack.getItemDamage() == itemstack1.getItemDamage())) {
							flag = true;
							arraylist.remove(itemstack1);
							break;
						}
					}

					if (!flag) {
						return false;
					}
				}
			}
		}

		return arraylist.isEmpty();
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
		return this.recipeOutput.copy();
	}

	/**
	 * Returns the size of the recipe area
	 */
	@Override
	public int getRecipeSize() {
		return this.recipeItems.size();
	}
}