package com.JayPi4c.minecraftextensions.fluids;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BasicFluidBlock extends BlockFluidClassic {

	@SideOnly(Side.CLIENT)

	protected IIcon stillIcon;

	@SideOnly(Side.CLIENT)

	protected IIcon flowingIcon;

	private String textureName;

	public BasicFluidBlock(Fluid fluid, Material material, String name, String textureName) {

		super(fluid, material);
		this.textureName = textureName;

	}

	@Override

	public IIcon getIcon(int side, int meta) {

		return (side == 0 || side == 1) ? stillIcon : flowingIcon;

	}

	@SideOnly(Side.CLIENT)

	@Override

	public void registerBlockIcons(IIconRegister register) {

		stillIcon = register.registerIcon(MinecraftExtensions.MODID + ":" + this.textureName + "_still");

		flowingIcon = register.registerIcon(MinecraftExtensions.MODID + ":" + this.textureName + "_flow");
	}

	@Override

	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {

		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;

		return super.canDisplace(world, x, y, z);

	}

	@Override

	public boolean displaceIfPossible(World world, int x, int y, int z) {

		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;

		return super.displaceIfPossible(world, x, y, z);

	}

}
