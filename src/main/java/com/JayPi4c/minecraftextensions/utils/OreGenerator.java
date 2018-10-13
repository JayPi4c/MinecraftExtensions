package com.JayPi4c.minecraftextensions.utils;

import java.util.Random;

import com.JayPi4c.minecraftextensions.blocks.ores.Ores;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverword(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		default:

		}
	}

	public void generateEnd(World world, Random random, int x, int z) {

	}

	public void generateOverword(World world, Random random, int x, int z) {
		generateOre(Ores.adiomantium_ore, world, random, x, z, 4, 12, 12, 0, 100, Blocks.stone);
		generateOre(Ores.ragonid_ore, world, random, x, z, 5, 15, 15, 0, 100, Blocks.stone);
		generateOre(Ores.vagonid_ore, world, random, x, z, 5, 10, 10, 0, 100, Blocks.stone);
		generateOre(Ores.zagonid_ore, world, random, x, z, 5, 10, 10, 0, 100, Blocks.stone);

	}

	public void generateNether(World world, Random random, int x, int z) {

	}

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize,
			int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, vienSize, generateIn);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}

}
