package com.JayPi4c.minecraftextensions.fluids;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class Fluids {

	public static Fluid AdiomantiumFluid = new BasicFluid("adiomantium_fluid");
	public static Block AdiomantiumFluidBlock;
	public static Item AdiomantiumBucket;

	public static void init() {
		FluidRegistry.registerFluid(AdiomantiumFluid);
		AdiomantiumFluidBlock = new BasicFluidBlock(AdiomantiumFluid, Material.water, "adiomantium_fluid",
				"adiomantium_fluid");
		AdiomantiumBucket = new ItemBucket(AdiomantiumFluidBlock, "adiomantium_bucket", "adiomantium_bucket");
		GameRegistry.registerBlock(AdiomantiumFluidBlock, "TestFluidBlock");
		GameRegistry.registerItem(AdiomantiumBucket, "TestBucket");
		FluidContainerRegistry.registerFluidContainer(AdiomantiumFluid, new ItemStack(AdiomantiumBucket),
				new ItemStack(Items.bucket));
		BucketHandler.INSTANCE.buckets.put(AdiomantiumFluidBlock, AdiomantiumBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
}
