package com.JayPi4c.extensionmod.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class AdiomantiumWorldProvider extends WorldProvider {

	@Override
	protected void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.forest, 0.8F);
		this.dimensionId = Dimensions.ADIOMANTIUM_DIMENSION_ID;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new AdiomantiumChunkProvider(worldObj, worldObj.getSeed(), true);
	}

	@Override
	public String getDimensionName() {
		return "AdiomantiumDimension";
	}

}
