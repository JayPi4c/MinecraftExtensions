package com.JayPi4c.minecraftextensions.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GuiTeleporterInput extends GuiScreen {

	public static final int TELEPORTER_GUI_ID = 40;

	private GuiTextField textField;
	private GuiButton confirm;
	private GuiButton cancle;

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(confirm = new GuiButton(0, 100, 100, 60, 60, "confirm"));
		textField = new GuiTextField(fontRendererObj, width / 2 - 68, height / 2 - 46, 137, 20);
		textField.setMaxStringLength(25);
		textField.setText("further information.");
		textField.setFocused(true);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected void keyTyped(char c, int i) {
		textField.textboxKeyTyped(c, i);
		if (!(i == Keyboard.KEY_E && textField.isFocused()))
			super.keyTyped(c, i);

	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		textField.updateCursorCounter();
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		drawDefaultBackground();
		textField.drawTextBox();
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@Override
	protected void mouseClicked(int x, int y, int btn) {
		super.mouseClicked(x, y, btn);

	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button == confirm) {
			System.out.println("confirm was pressed");

		}
	}

	public static ItemStack updateNBT(ItemStack itemStack, String key, String value) {
		NBTTagCompound data = itemStack.getTagCompound();
		if (data == null)
			data = new NBTTagCompound();
		data.setString(key, value);
		itemStack.setTagCompound(data);
		return itemStack;
	}

}
