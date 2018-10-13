package com.JayPi4c.minecraftextensions.handler;

import com.JayPi4c.minecraftextensions.blocks.apparatuses.Apparatuses;
import com.JayPi4c.minecraftextensions.container.ContainerAdiomantiumCraftingTable;
import com.JayPi4c.minecraftextensions.gui.GuiAdiomantiumCraftingTable;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Apparatuses.ADIOMANTIUM_CRAFTING_TABLE_GUI_ID)
			return world.getBlock(x, y, z) == Apparatuses.adiomantium_crafting_table
					? new ContainerAdiomantiumCraftingTable(player.inventory, world, x, y, z)
					: null;

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Apparatuses.ADIOMANTIUM_CRAFTING_TABLE_GUI_ID)
			return world.getBlock(x, y, z) == Apparatuses.adiomantium_crafting_table
					? new GuiAdiomantiumCraftingTable(player.inventory, world, x, y, z)
					: null;
		return null;

	}

}
