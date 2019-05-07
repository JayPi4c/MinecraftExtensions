package com.JayPi4c.minecraftextensions.tile_entities;

import com.JayPi4c.minecraftextensions.blocks.apparatuses.BlockMelter;
import com.JayPi4c.minecraftextensions.items.Items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMelter extends TileEntity implements ISidedInventory {

	private static final int[] slotsTop = new int[] {};
	private static final int[] slotsBottom = new int[] { 2, 1 };
	private static final int[] slotsSide = new int[] { 1 };

	private ItemStack[] melterItemStacks = new ItemStack[3];
	public int melterActiveTime;
	public int currentActiveTime;
	public int melterWorkingTime;

	private String melterName;

	public void melterName(String name) {
		melterName = name;
	}

	@Override
	public int getSizeInventory() {
		return melterItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return melterItemStacks[index];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if (this.melterItemStacks[var1] != null) {
			ItemStack itemstack;
			if (melterItemStacks[var1].stackSize <= var2) {
				itemstack = melterItemStacks[var1];
				melterItemStacks[var1] = null;
				return itemstack;
			} else {
				itemstack = melterItemStacks[var1].splitStack(var2);
				if (melterItemStacks[var1].stackSize == 0) {
					melterItemStacks[var1] = null;
				}
				return itemstack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (melterItemStacks[slot] != null) {
			ItemStack itemstack = melterItemStacks[slot];
			melterItemStacks[slot] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		melterItemStacks[slot] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return hasCustomInventoryName() ? melterName : "Melter";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return melterName != null && melterName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		NBTTagList taglist = tag.getTagList("Items", 10);
		melterItemStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < taglist.tagCount(); ++i) {
			NBTTagCompound tag1 = taglist.getCompoundTagAt(i);
			byte b = tag1.getByte("Slot");
			if (b >= 0 && b < melterItemStacks.length) {
				melterItemStacks[b] = ItemStack.loadItemStackFromNBT(tag1);
			}
		}
		melterActiveTime = tag.getShort("ActiveTime");
		melterWorkingTime = tag.getShort("WorkingTime");
		currentActiveTime = getItemActiveTime(melterItemStacks[1]);

		if (tag.hasKey("CustomName", 8)) {
			melterName = tag.getString("CustomName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setShort("ActiveTime", (short) melterActiveTime);
		tag.setShort("WorkingTime", (short) melterWorkingTime);
		NBTTagList taglist = new NBTTagList();

		for (int i = 0; i < melterItemStacks.length; ++i) {
			if (melterItemStacks[i] != null) {
				NBTTagCompound tag1 = new NBTTagCompound();
				tag1.setByte("Slot", (byte) i);
				melterItemStacks[i].writeToNBT(tag1);
				taglist.appendTag(tag1);
			}
		}

		tag.setTag("Items", taglist);
		if (hasCustomInventoryName()) {
			tag.setString("CustomName", melterName);
		}
	}

	@SideOnly(Side.CLIENT)
	public int getWorkingProgessScaled(int par1) {
		return melterWorkingTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getActiveTimeRemainingScaled(int par1) {
		if (melterActiveTime == 0)
			currentActiveTime = 200;
		return melterActiveTime * par1 / currentActiveTime;
	}

	public boolean isActive() {
		return melterActiveTime > 0;
	}

	@Override
	public void updateEntity() {
		boolean flag = melterActiveTime > 0;
		boolean flag1 = false;
		if (melterActiveTime > 0)
			--melterActiveTime;
		if (!worldObj.isRemote) {
			if (melterActiveTime == 0 && canMelt()) {
				currentActiveTime = melterActiveTime = getItemActiveTime(melterItemStacks[1]);
				if (melterActiveTime > 0) {
					flag1 = true;
					if (melterItemStacks[1] != null) {
						--melterItemStacks[1].stackSize;
						if (melterItemStacks[1].stackSize == 0) {
							melterItemStacks[1] = melterItemStacks[1].getItem().getContainerItem(melterItemStacks[1]);
						}
					}
				}
			}
			if (isActive() && canMelt()) {
				++melterWorkingTime;
				if (melterWorkingTime == 200) {
					melterWorkingTime = 0;
					meltItem();
					flag1 = true;
				}
			} else {
				melterWorkingTime = 0;
			}
		}
		if (flag != melterActiveTime > 0) {
			flag1 = true;
			BlockMelter.updateBlockState(melterActiveTime > 0, worldObj, xCoord, yCoord, zCoord);
		}
		if (flag1)
			markDirty();
	}

	private boolean canMelt() {
		if (melterItemStacks[0] == null)
			return false;
		ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(melterItemStacks[0]);
		if (itemstack == null)
			return false;
		if (melterItemStacks[2] == null)
			return true;
		if (melterItemStacks[2].isItemEqual(itemstack))
			return false;
		int result = melterItemStacks[2].stackSize + itemstack.stackSize;
		return result <= getInventoryStackLimit() && result <= melterItemStacks[2].getMaxStackSize();
	}

	public void meltItem() {
		if (canMelt()) {
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(melterItemStacks[0]);
			if (melterItemStacks[2] == null) {
				melterItemStacks[2] = itemstack.copy();
			} else if (melterItemStacks[2].getItem() == itemstack.getItem()) {
				melterItemStacks[2].stackSize += itemstack.stackSize;
			}
		}
	}

	public static int getItemActiveTime(ItemStack stack) {
		if (stack == null)
			return 0;
		net.minecraft.item.Item item = stack.getItem();
		if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
			Block block = Block.getBlockFromItem(item);
			if (block == com.JayPi4c.minecraftextensions.blocks.Blocks.adiomantium_block)
				return 1600;
			if (block.getMaterial() == Material.rock)
				return 100;
			if (item == Items.adiomantium_ingot)
				return 150;
			// if(item instanceof ItemTool &&
			// ((ItemTool)item).getToolMaterialName().equals("DIAMOND"))) return 200;

		}
		return GameRegistry.getFuelValue(stack);
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemActiveTime(stack) > 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer palyer) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false
				: palyer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {

		return slot == 2 ? false : (slot == 1 ? isItemFuel(stack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int slot) {
		return slot == 0 ? slotsBottom : slot == 1 ? slotsTop : slotsSide;
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack stack, int par2) {
		return isItemValidForSlot(par1, stack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack stack, int par2) {

		return par2 != 0 || par1 != 1 || stack.getItem() == net.minecraft.init.Items.bucket;
	}

}
