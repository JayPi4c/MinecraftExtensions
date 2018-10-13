package com.JayPi4c.minecraftextensions.items.tools;

import java.util.Set;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.tabs.Tabs;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.ForgeHooks;

public class ItemPickaxeAxeItem extends ItemTool {

	@SuppressWarnings("unchecked")
	protected ItemPickaxeAxeItem(String name, String texturename, ToolMaterial material) {
		super(0, material, Sets.newHashSet(Block.blockRegistry));
		this.setHarvestLevel("pickaxe", material.getHarvestLevel());
		this.setHarvestLevel("axe", material.getHarvestLevel());
		this.setUnlocalizedName(name);
		this.setTextureName(MinecraftExtensions.MODID + ":" + texturename);
		this.setCreativeTab(Tabs.tabToolsTab);
	}

	/**
	 * The {@link Material}s that this tool is effective on.
	 */
	private static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(
			// Pickaxe
			Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil,
			Material.circuits,

			// Axe
			Material.wood, Material.gourd, Material.plants, Material.vine
	// Shovel
	// ,Material.grass, Material.ground, Material.sand, Material.snow,
	// Material.craftedSnow, Material.clay);
	);

	/**
	 * Can this tool harvest the {@link Block}?
	 * <p>
	 * This should only be used by
	 * {@link EntityPlayer#isCurrentToolAdventureModeExempt(int, int, int)} and
	 * {@link ForgeHooks#canHarvestBlock(Block, EntityPlayer, int)}, use the tool
	 * class/harvest level system where possible.
	 *
	 * @param block     The Block
	 * @param itemStack The tool
	 * @return Is this tool effective on the {@link Block}'s {@link Material}?
	 */
	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return EFFECTIVE_MATERIALS.contains(block.getMaterial()) || block == Blocks.web;
	}

}
