package com.JayPi4c.minecraftextensions.items.tools;

import com.JayPi4c.minecraftextensions.items.ItemItem;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemTeleporter extends ItemItem {
	// the position stored in the teleporter
	double x, y, z;

	protected ItemTeleporter(String name, String texturename, int stacksize) {
		super(name, texturename, stacksize);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		this.x = player.posX;
		this.y = player.posY;
		this.z = player.posZ;
		return super.onItemRightClick(itemStack, world, player);
	}

	/**
	 * Dieses Item kann soll keine Bl&oumlcke zerst&oumlren k&oumlnnen, da sofort
	 * teleportiert werden soll.
	 */
	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		entityLiving.setPositionAndRotation(x, y, z, entityLiving.getRotationYawHead(), 0);
		((EntityPlayer) entityLiving).addChatComponentMessage(new ChatComponentTranslation(
				"Player " + entityLiving.getCommandSenderName() + " ported!", new Object[0]));
		return true;
	}

}
