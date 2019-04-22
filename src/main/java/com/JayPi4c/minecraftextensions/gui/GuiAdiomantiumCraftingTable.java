package com.JayPi4c.minecraftextensions.gui;

import org.lwjgl.opengl.GL11;

import com.JayPi4c.minecraftextensions.MinecraftExtensions;
import com.JayPi4c.minecraftextensions.container.ContainerAdiomantiumCraftingTable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiAdiomantiumCraftingTable extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(
			MinecraftExtensions.MODID + ":" + "textures/gui/adiomantium_crafting_table.png");
	public static final int ADIOMANTIUM_CRAFTING_TABLE_GUI_ID = 42;

	public GuiAdiomantiumCraftingTable(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerAdiomantiumCraftingTable(invPlayer, world, x, y, z));
		this.xSize = 176;
		this.ySize = 177;
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("ACT"), 100, 5, 0x000000);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
