package com.JayPi4c.extensionmod;

import com.JayPi4c.extensionmod.blocks.Blocks;
import com.JayPi4c.extensionmod.blocks.apparatuses.Apparatuses;
import com.JayPi4c.extensionmod.blocks.ores.Ores;
import com.JayPi4c.extensionmod.crafting.Recipes;
import com.JayPi4c.extensionmod.dimension.Dimensions;
import com.JayPi4c.extensionmod.handler.Handlers;
import com.JayPi4c.extensionmod.items.Items;
import com.JayPi4c.extensionmod.items.armors.Armors;
import com.JayPi4c.extensionmod.items.tools.Tools;
import com.JayPi4c.extensionmod.utils.OreGenerator;

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
	public static final String MODID = "extensionmod";
	public static final String VERSION = "0.1";
	public static final String NAME = "ExtensionMod";

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
		Dimensions.init();
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		Handlers.init();
		Recipes.init();
	}
}
