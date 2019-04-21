package com.JayPi4c.minecraftextensions.items.tools;

import com.JayPi4c.minecraftextensions.items.ItemItem;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemTeleporter extends ItemItem {

	protected ItemTeleporter(String name, String texturename) {
		super(name, texturename, 1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {

			NBTTagCompound data = itemStack.getTagCompound();
			if (data == null)
				data = new NBTTagCompound();
			data.setDouble("x-Pos", player.posX);
			data.setDouble("y-Pos", player.posY);
			data.setDouble("z-Pos", player.posZ);
			itemStack.setTagCompound(data);
		}
		return itemStack;

	}

	/**
	 * Dieses Item kann, soll keine Bl&oumlcke zerst&oumlren k&oumlnnen, da sofort
	 * teleportiert werden soll.
	 */
	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		NBTTagCompound data = stack.getTagCompound();
		if (data != null) {
			entityLiving.setPositionAndRotation(data.getDouble("x-Pos"), data.getDouble("y-Pos"),
					data.getDouble("z-Pos"), entityLiving.getRotationYawHead(), 0);
			((EntityPlayer) entityLiving).addChatComponentMessage(new ChatComponentTranslation(
					"Player " + entityLiving.getCommandSenderName() + " ported!", new Object[0]));
		} else
			((EntityPlayer) entityLiving)
					.addChatComponentMessage(new ChatComponentTranslation("No Location stored", new Object[0]));
		return true;
	}

}
