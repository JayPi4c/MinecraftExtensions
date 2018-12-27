package com.JayPi4c.minecraftextensions.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockDekoLeaves extends BlockBlock {

	// TODO: Adding Texture for FenceLeaves
	public BlockDekoLeaves(String name, String texturename, SoundType stepsound, float lightlevel, float hardness,
			Material material, String tooltype, int level) {
		super(name, texturename, stepsound, lightlevel, hardness, material, tooltype, level);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list,
			Entity colliding_entity) {
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.3F, 1F);
		super.addCollisionBoxesToList(world, x, y, z, mask, list, colliding_entity);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.0F, 1F);
	}

}
