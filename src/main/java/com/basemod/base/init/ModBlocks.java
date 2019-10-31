package com.basemod.base.init;

import com.basemod.base.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    /**
     * Storing all Mod Blocks in an Array List
     */
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    /**
     * function  to create new Ores
     */
    public static final Block ORE_COPPER = new BlockBase("ore_copper", Material.IRON);
    public static final Block ORE_TIN = new BlockBase("ore_tin", Material.IRON);

    /**
     * function to create new Blocks
     */
    public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.ROCK);
    public static final Block BLOCK_TIN = new BlockBase("block_tin", Material.ROCK);
}