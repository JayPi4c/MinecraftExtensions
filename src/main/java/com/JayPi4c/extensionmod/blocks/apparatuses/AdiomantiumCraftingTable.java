package com.JayPi4c.extensionmod.blocks.apparatuses;

import com.JayPi4c.extensionmod.ExtensionMod;
import com.JayPi4c.extensionmod.blocks.Blocks;
import com.JayPi4c.extensionmod.tabs.Tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
* https://www.youtube.com/watch?v=Vcnv18pe-cw
*/
public class AdiomantiumCraftingTable extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	protected AdiomantiumCraftingTable() {
		super(Material.iron);
		this.setBlockName("adiomantium_crafting_table");
		this.setHardness(3.5F);
		this.setResistance(5F);
		this.setCreativeTab(Tabs.tabBlocksTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.iconTop
				: side == 0 ? Blocks.adiomantium_block.getBlockTextureFromSide(side) : this.blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(ExtensionMod.MODID + ":adiomantium_crafting_table_side");
		this.iconTop = iconRegister.registerIcon(ExtensionMod.MODID + ":adiomantium_crafting_table_top");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int a, float b, float c,
			float d) {
		if (!player.isSneaking()) {
			player.openGui(ExtensionMod.instance, Apparatuses.ADIOMANTIUM_CRAFTING_TABLE_GUI_ID, world, x, y, z);
			return true;
		}
		return false;
	}
}
