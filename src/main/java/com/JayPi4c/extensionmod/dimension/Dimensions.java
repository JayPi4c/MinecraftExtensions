package com.JayPi4c.extensionmod.dimension;

import net.minecraftforge.common.DimensionManager;

public class Dimensions {
	public static final int ADIOMANTIUM_DIMENSION_ID = 8;

	public static void init() {
		DimensionManager.registerProviderType(ADIOMANTIUM_DIMENSION_ID, AdiomantiumWorldProvider.class, false);
		DimensionManager.registerDimension(ADIOMANTIUM_DIMENSION_ID, ADIOMANTIUM_DIMENSION_ID);
		;
	}
}
