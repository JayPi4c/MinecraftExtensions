package com.JayPi4c.minecraftextensions.items.tools;

import java.util.List;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.gui.GuiTeleporterInput;
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
			player.openGui(MinecraftExtensions.instance, GuiTeleporterInput.TELEPORTER_GUI_ID, world, (int) player.posX,
					(int) player.posY, (int) player.posZ);
			data.setString("UserInfo", "No further information stored.");
		} else {
			data.setDouble("x-Pos", player.posX);
			data.setDouble("y-Pos", player.posY);
			data.setDouble("z-Pos", player.posZ);
		}
		itemStack.setTagCompound(data);
		return itemStack;
	}

	@Override
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_,
			int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		return true;
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
