package com.JayPi4c.minecraftextensions;

import com.JayPi4c.minecraftextensions.blocks.Blocks;
import com.JayPi4c.minecraftextensions.blocks.apparatuses.Apparatuses;
import com.JayPi4c.minecraftextensions.blocks.ores.Ores;
import com.JayPi4c.minecraftextensions.crafting.Recipes;
import com.JayPi4c.minecraftextensions.handler.Handlers;
import com.JayPi4c.minecraftextensions.items.Items;
import com.JayPi4c.minecraftextensions.items.armors.Armors;
import com.JayPi4c.minecraftextensions.items.tools.Tools;
import com.JayPi4c.minecraftextensions.utils.OreGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Das ist die Hauptklasse, in der alle Items und Bl&oumlcke und so weiter
 * registriert werden m&uumlssen.
 * 
 * @author JayPi4c
 *
 */
@Mod(modid = ExtensionMod.MODID, name = ExtensionMod.NAME, version = ExtensionMod.VERSION)
public class ExtensionMod {
	public static final String MODID = "minecraftextensions";
	public static final String VERSION = "0.1";
	public static final String NAME = "MinecraftExtensions";

	@Instance(MODID)
	public static ExtensionMod instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Ores.init();
		Blocks.init();
		Tools.init();
		Items.init();
		Armors.init();
		Apparatuses.init();
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		Handlers.init();
		Recipes.init();
	}
}
