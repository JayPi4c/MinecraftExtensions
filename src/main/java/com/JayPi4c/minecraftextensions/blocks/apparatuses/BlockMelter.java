package com.JayPi4c.minecraftextensions.blocks.apparatuses;

import java.util.Random;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.tile_entities.TileEntityMelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMelter extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;

	private static boolean isActive;

	private final boolean isActive2;
	private final Random random = new Random();

	protected BlockMelter(boolean active) {
		super(Material.rock);
		isActive2 = active;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(MinecraftExtensions.MODID + ":" + "melter_side");
		this.top = iconRegister.registerIcon(MinecraftExtensions.MODID + ":" + "melter_top");
		this.front = iconRegister
				.registerIcon(MinecraftExtensions.MODID + ":" + (isActive2 ? "melter_active" : "melter_inactive"));
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (side == 1 ? top : side == 3 ? front : blockIcon);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_,
			float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		player.openGui(MinecraftExtensions.instance, GuiMelter.ID, world, x, y, z);
		return true;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(Apparatuses.MelterInactive);
	}

	@Override
	public Item getItem(World world, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
		return Item.getItemFromBlock(Apparatuses.MelterInactive);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.direction(world, x, y, z);
	}

	private void direction(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block direction = world.getBlock(x, y, z - 1);
			Block direction1 = world.getBlock(x, y, z + 1);
			Block direction2 = world.getBlock(x - 1, y, z);
			Block direction3 = world.getBlock(x + 1, y, z);
			byte byte0 = 3;

			if (direction.func_149730_j() && !direction1.func_149730_j()) {
				byte0 = 3;
			}

			if (direction1.func_149730_j() && direction1.func_149730_j()) {
				byte0 = 2;
			}

			if (direction2.func_149730_j() && direction2.func_149730_j()) {
				byte0 = 5;
			}

			if (direction3.func_149730_j() && direction3.func_149730_j()) {
				byte0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		int direction = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		if (direction == 0)
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if (direction == 1)
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		if (direction == 2)
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if (direction == 3)
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);

		if (itemstack.hasDisplayName())
			((TileEntityMelter) world.getTileEntity(x, y, z)).melterName(itemstack.getDisplayName());

	}

	public static void updateBlockState(boolean act, World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentitiy = world.getTileEntity(x, y, z);
		isActive = true;
		if (act) {
			world.setBlock(x, y, z, Apparatuses.MelterActive);
		} else {
			world.setBlock(x, y, z, Apparatuses.MelterInactive);
		}
		isActive = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
		if (tileentitiy != null) {
			tileentitiy.validate();
			world.setTileEntity(x, y, z, tileentitiy);
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!isActive) {
			TileEntityMelter tileEntitiyMelter = ((TileEntityMelter) world.getTileEntity(x, y, z));
			if (tileEntitiyMelter != null) {
				for (int i = 0; i < tileEntitiyMelter.getSizeInventory(); i++) {
					ItemStack itemstack = tileEntitiyMelter.getStackInSlot(i);
					if (itemstack != null) {
						float f1 = random.nextFloat() * 0.6F + 0.1F;
						float f2 = random.nextFloat() * 0.6F + 0.1F;
						float f3 = random.nextFloat() * 0.6F + 0.1F;
						while (itemstack.stackSize > 0) {
							int j = random.nextInt(21) + 10;
							if (j > itemstack.stackSize)
								j = itemstack.stackSize;
							itemstack.stackSize -= j;
							EntityItem entityItem = new EntityItem(world, x + f1, y + f2, z + f3,
									new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							if (itemstack.hasTagCompound()) {
								entityItem.getEntityItem()
										.setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float f4 = 0.025F;
							entityItem.motionX = (float) random.nextGaussian() * f4;
							entityItem.motionY = (float) random.nextGaussian() * f4 + 0.01F;
							entityItem.motionZ = (float) random.nextGaussian() * f4;
							world.spawnEntityInWorld(entityItem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);

			}

		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (this.isActive2) {
			int direction = world.getBlockMetadata(x, y, z);

			float xx = x + 0.5F, yy = y + random.nextFloat() * 6.0F / 16.0F, zz = z + 0.5F,
					xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;

			if (direction == 4) {
				world.spawnParticle("smoke", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
			} else if (direction == 5) {
				world.spawnParticle("smoke", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
			} else if (direction == 3) {
				world.spawnParticle("smoke", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
			} else if (direction == 2) {
				world.spawnParticle("smoke", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", xx - zz2, yy, zz + xx2, 0.0F, 0.0F, 0.0F);
			}
		}
	}
}