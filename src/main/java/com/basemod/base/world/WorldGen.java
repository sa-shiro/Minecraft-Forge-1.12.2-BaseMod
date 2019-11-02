package com.basemod.base.world;

import com.basemod.base.init.ModBlocks;
import com.basemod.base.util.ModConfigManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator {

    private WorldGenMinable worldGenMinable;

    /**
     * function to generate Ores in the specified Dimension
     */
    // Overworld id = 0, Nether id = -1, The End id = 1
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider ) {
        if (world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
        if (world.provider.getDimension() == -1) {
            generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }
    // change or remove those values!
    private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(Blocks.REDSTONE_ORE.getDefaultState(),
                world, random, chunkX * 16, chunkZ * 16, 1, 255, random.nextInt(30) + 10, 24,BlockMatcher.forBlock(Blocks.NETHERRACK));

    }

    /**
     * function to declare what ores will be generated
     */
    // We replace the Values minY, maxY, size (VALUE ONLY!), spawnTries with our config variables
    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        // We are using an if(statement is true) { function } else { nothing } function to check if our ore is enabled in our config!
        if (ModConfigManager.oreCopper) {
            generateOre(ModBlocks.ORE_COPPER.getDefaultState(),
                    world, random, chunkX * 16, chunkZ * 16, ModConfigManager.copperMinHeight, ModConfigManager.copperMaxHeight, random.nextInt(ModConfigManager.copperVeinSize) + 1, ModConfigManager.copperSpawnTries, BlockMatcher.forBlock(Blocks.STONE));
        } else { }
        if (ModConfigManager.oreTin) {
            generateOre(ModBlocks.ORE_TIN.getDefaultState(),
                    world, random, chunkX * 16, chunkZ * 16, ModConfigManager.tinMinHeight, ModConfigManager.tinMaxHeight, random.nextInt(ModConfigManager.tinVeinSize) + 1, ModConfigManager.tinSpawnTries, BlockMatcher.forBlock(Blocks.STONE));
        }  else { }
    }

    /**
     * function to declare the generation of the ores (min/max height, cluster size, spawn tries
     */
    private void generateOre(IBlockState ore, World world, Random rand, int chunkX, int chunkZ, int minY, int maxY, int size, int spawnTries, BlockMatcher block) {
        int deltaY = maxY - minY + 1;
        if (minY < 0) minY = 0;
        if (maxY > 255) maxY = 255;

        for (int i = 0; i < spawnTries; i++) {
            BlockPos pos = new BlockPos(chunkX + rand.nextInt(16), minY + rand.nextInt(deltaY), chunkZ + rand.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size, block);
            generator.generate(world, rand, pos);
        }
    }
}
