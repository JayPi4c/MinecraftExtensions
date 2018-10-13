package com.JayPi4c.minecraftextensions.blocks.ores;

import java.util.ArrayList;
import java.util.Random;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.items.Items;
import com.JayPi4c.minecraftextensions.tabs.Tabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockOre extends Block {
	/**
	 * 
	 * @param name
	 * @param texturename
	 * @param lightlevel  Lichtlevel, welcher vom Block ausgeht (ein Wert zwischen 0
	 *                    und 1) 5 / 16f f&uumlr Level 5
	 * @param hardness    Die Zeit, die es braucht, diesen Block zu zerst&oumlren
	 *                    (dirt: 0.5; stone: 1.5)
	 * @param tooltype    Das Tool, dass f&uumlr den Abbau ben&oumltigt wird.
	 * @param level       Das Level, das von dem Toolmaterial ben&oumltigt wird, um
	 *                    das Erz korregt abzubauen.
	 */
	protected BlockOre(String name, String texturename, float lightlevel, float hardness, String tooltype, int level) {
		super(Material.rock);
		this.setLightLevel(lightlevel);
		this.setHardness(hardness);
		this.setStepSound(Block.soundTypeStone);
		this.setBlockName(name);
		this.setBlockTextureName(MinecraftExtensions.MODID + ":" + texturename);
		this.setCreativeTab(Tabs.tabBlocksTab);
		this.setHarvestLevel(tooltype, level);
	}

	@Override
	public int quantityDropped(Random random) {
		if (this == Ores.adiomantium_ore)
			return 3 + random.nextInt(3);
		if (this == Ores.zagonid_ore)
			return 1 + random.nextInt(3);
		if (this == Ores.vagonid_ore)
			return 1 + random.nextInt(3);
		return 1;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
		if (this == Ores.adiomantium_ore)
			return Items.adiomantium_dust;
		if (this == Ores.vagonid_ore)
			return Items.vagonid_dust;
		if (this == Ores.zagonid_ore)
			return Items.zagonid_dust;
		if (this == Ores.ragonid_ore)
			return null;
		return super.getItemDropped(p_149650_1_, random, p_149650_3_);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		if (this == Ores.ragonid_ore) {
			Random random = new Random();
			ArrayList<ItemStack> stack = super.getDrops(world, x, y, z, metadata, fortune);
			stack.add(new ItemStack(Items.adiomantium_dust, random.nextInt(2)));
			stack.add(new ItemStack(Items.vagonid_dust, random.nextInt(4)));
			stack.add(new ItemStack(Items.zagonid_dust, random.nextInt(4)));
			return stack;
		}
		return super.getDrops(world, x, y, z, metadata, fortune);
	}

}
