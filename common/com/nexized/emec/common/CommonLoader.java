package com.nexized.emec.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

import com.nexized.emec.blocks.*;
import com.nexized.emec.items.*;
import com.nexized.emec.items.tools.*;
import com.nexized.emec.items.weapons.swordPlatinum;
import com.nexized.emec.world.*;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonLoader {

	// @Block Ores
	public static Block OrePlatinum;
	// @Blocks
	public static Block BlockPlatinum;
	
	// @Items
	public static Item IngotPlatinum;
	
	// @Material 
	public static EnumToolMaterial PLATINUM;
	
	// @Tools
	public static Item AxePlatinum;
	public static Item HoePlatinum;
	public static Item PickPlatinum;
	public static Item ShovelPlatinum;
	public static Item SwordPlatinum;
	
	public static void init() {
		PLATINUM = EnumHelper.addToolMaterial("PLATINUM", 4, 300, 6.5F, 4.0F, 16);
	}
	
	public static void addBlocks(ConfigurationHandler common) {
		// @Add Blocks
		OrePlatinum = (new orePlatinum(common.orePlatinumID));
		BlockPlatinum = (new blockPlatinum(common.blockPlatinumID, Material.iron)); 
		// @Register Blocks
		GameRegistry.registerBlock(OrePlatinum, "PlatinumOre");
		GameRegistry.registerBlock(BlockPlatinum, "PlatinumBlock");
		// @BlockHarvest
		MinecraftForge.setBlockHarvestLevel(OrePlatinum, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(BlockPlatinum, "Pickaxe", 2);
	}
	
	public static void addItems(ConfigurationHandler common) {
		// @Add Items
		IngotPlatinum = (new ingotPlatinum(common.ingotPlatinumID).setUnlocalizedName("Platinum Ingot"));
		AxePlatinum = (new axePlatinum(common.axePlatinumID, PLATINUM).setUnlocalizedName("Platinum Axe"));
		HoePlatinum = (new hoePlatinum(common.hoePlatinumID, PLATINUM).setUnlocalizedName("Platinum Hoe"));
		PickPlatinum = (new pickPlatinum(common.pickPlatinumID, PLATINUM).setUnlocalizedName("Platinum Pickaxe"));
		ShovelPlatinum = (new shovelPlatinum(common.shovelPlatinumID, PLATINUM).setUnlocalizedName("Platinum Shovel"));
		SwordPlatinum = (new swordPlatinum(common.swordPlatinumID, PLATINUM).setUnlocalizedName("Platinum Sword"));
		// @Register Items
		GameRegistry.registerItem(IngotPlatinum, "Platinum Ingot");
		GameRegistry.registerItem(AxePlatinum, "Platinum Axe");
		GameRegistry.registerItem(HoePlatinum, "Platinum Hoe");
		GameRegistry.registerItem(PickPlatinum, "Platinum Pick");
		GameRegistry.registerItem(ShovelPlatinum, "Platinum Shovel");
		GameRegistry.registerItem(SwordPlatinum, "Platinum Sword");
	}
	
	public static void addNames() {
		// @Add Block Names
		LanguageRegistry.addName(BlockPlatinum, "Block of Platinum");
		LanguageRegistry.addName(OrePlatinum, "Platinum Ore");
		// @Add Item Names
		LanguageRegistry.addName(IngotPlatinum, "Platinum Ingot");
		LanguageRegistry.addName(AxePlatinum, "Platinum Axe");
		LanguageRegistry.addName(HoePlatinum, "Platinum Hoe");
		LanguageRegistry.addName(PickPlatinum, "Platinum Pickaxe");
		LanguageRegistry.addName(ShovelPlatinum, "Platinum Shovel");
		LanguageRegistry.addName(SwordPlatinum, "Platinum Sword");
	}
	
	public static void addRecipes() {
		// @Add Block Recipes
		GameRegistry.addSmelting(OrePlatinum.blockID, new ItemStack(IngotPlatinum), 10.0F);
		GameRegistry.addRecipe(new ItemStack(BlockPlatinum), new Object[] {"XXX", "XXX", "XXX", 'X', IngotPlatinum});
		// @Add Item Recipes
		GameRegistry.addRecipe(new ItemStack(AxePlatinum), new Object[] {" XX", " *X", " * ", 'X', IngotPlatinum, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(HoePlatinum), new Object[] {" XX", " * ", " * ", 'X', IngotPlatinum, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(PickPlatinum), new Object[] {"XXX", " * ", " * ", 'X', IngotPlatinum, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ShovelPlatinum), new Object[] {" X ", " * ", " * ", 'X', IngotPlatinum, '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(SwordPlatinum), new Object[] {" X ", " X ", " * ", 'X', IngotPlatinum, '*', Item.stick});
	}

	public static void toolClasses() {
		MinecraftForge.setToolClass(PickPlatinum, "pickaxe", 2);
        MinecraftForge.setToolClass(AxePlatinum, "axe", 2);
        MinecraftForge.setToolClass(ShovelPlatinum, "shovel", 2);
        MinecraftForge.setToolClass(HoePlatinum, "hoe", 2);
	}
	
	public static void postInit() {
		// @Add WorldGenerator
		GameRegistry.registerWorldGenerator(new emecWorldGenerator());
	}
	
}
