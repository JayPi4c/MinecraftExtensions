package com.JayPi4c.minecraftextensions.items.tools;

import java.util.List;

import com.JayPi4c.minecraftextensions.items.ItemItem;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
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
		NBTTagCompound data = itemStack.getTagCompound();
		if (data == null)
			data = new NBTTagCompound();

		if (GuiScreen.isShiftKeyDown()) {
			data.setString("UserInfo", "No further information stored.");
		} else {
			data.setDouble("x-Pos", player.posX);
			data.setDouble("y-Pos", player.posY);
			data.setDouble("z-Pos", player.posZ);
		}
		itemStack.setTagCompound(data);
		return itemStack;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
		NBTTagCompound data = itemStack.getTagCompound();
		if (data == null)
			list.add("No Location stored!");

		else
			list.add("Location stored: (" + Math.round(data.getDouble("x-Pos") * 10) / 10.0 + "|"
					+ Math.round(data.getDouble("y-Pos") * 10) / 10.0 + "|"
					+ Math.round(data.getDouble("z-Pos") * 10) / 10.0 + ")");
		list.add("");
		if (!GuiScreen.isShiftKeyDown())
			list.add("Press shift for further information.");
		else {
			if (data != null) {
				if (data.hasKey("UserInfo"))
					list.add(data.getString("UserInfo"));
			} else
				list.add("No further information stored.");
		}
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
		if (data.hasKey("x-Pos")) {
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
