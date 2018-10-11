package com.JayPi4c.extensionmod.container;

import com.JayPi4c.extensionmod.blocks.apparatuses.Apparatuses;
import com.JayPi4c.extensionmod.crafting.AdiomantiumCraftingTableCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerAdiomantiumCraftingTable extends Container {

	// für einen 5x5 Crafting Table:
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 5, 5);

	public IInventory craftResult;
	private World worldObj;
	private int posX, posY, posZ;

	public ContainerAdiomantiumCraftingTable(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;

		// Slot für das Ergebnis x y
		addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 132, 36));

		// Slots für das Craftingfeld
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.addSlotToContainer(new Slot(craftMatrix, j + i * 5, 4 + j * 18, 4 + i * 18));
			}
		}

		// Slots für das Inventory:
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 95 + i * 18));
			}
		}

		// Slots für die Hotbar:
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 153));
		}

		onCraftMatrixChanged(craftMatrix);
	}

	@Override
	public void onCraftMatrixChanged(IInventory iinventory) {
		craftResult.setInventorySlotContents(0,
				AdiomantiumCraftingTableCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (worldObj.getBlock(posX, posY, posZ) != Apparatuses.adiomantium_crafting_table)
			return false;
		else
			return player.getDistanceSq(posX + 0.5, posY + 0.5, posZ + 0.5) <= 64.0D;
	}

	/**
	 * Called when the container is closed.
	 */
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);

		if (!this.worldObj.isRemote) {
			// für jeden Slot in der Werkbank muss überprüft werden, ob ein ItemSack in dem
			// Slot liegt: in diesem Fall 5*5 = 25 Slots:
			for (int i = 0; i < 25; ++i) {
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

				if (itemstack != null) {
					player.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you
	 * will crash when someone does that.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (p_82846_2_ == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (p_82846_2_ >= 10 && p_82846_2_ < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (p_82846_2_ >= 37 && p_82846_2_ < 46) {
				if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(p_82846_1_, itemstack1);
		}

		return itemstack;
	}

}
