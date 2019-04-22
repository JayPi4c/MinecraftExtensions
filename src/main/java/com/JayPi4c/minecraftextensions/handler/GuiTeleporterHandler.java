package com.JayPi4c.minecraftextensions.handler;

import com.JayPi4c.minecraftextensions.gui.GuiTeleporterInput;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiTeleporterHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GuiTeleporterInput.TELEPORTER_GUI_ID)
			return new GuiTeleporterInput();
		return null;
	}

}
