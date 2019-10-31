package com.basemod.base.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        /* Adding Smelting Recipes to the Furnace */
        GameRegistry.addSmelting(ModBlocks.ORE_COPPER, new ItemStack(ModItems.INGOT_COPPER, 1), 0.1f);
        GameRegistry.addSmelting(ModBlocks.ORE_TIN, new ItemStack(ModItems.INGOT_TIN, 1), 0.1f);
    }
}