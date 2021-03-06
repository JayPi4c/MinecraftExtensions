package com.JayPi4c.minecraftextensions.blocks;

import java.util.Random;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.tabs.ExtensionsModTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBlock extends Block {

	protected BlockBlock(String name, String texturename, Block.SoundType stepsound, float lightlevel, float hardness,
			Material material, String tooltype, int level) {
		super(material);
		this.setStepSound(stepsound);
		this.setBlockName(name);
		this.setBlockTextureName(MinecraftExtensions.MODID + ":" + texturename);
		this.setLightLevel(lightlevel);
		this.setHardness(hardness);
		this.setHarvestLevel(tooltype, level);
		this.setCreativeTab(ExtensionsModTab.tabBlocks);
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_) {
		return Item.getItemFromBlock(this);
	}

}
