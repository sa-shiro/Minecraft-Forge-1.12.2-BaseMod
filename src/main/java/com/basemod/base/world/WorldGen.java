package com.basemod.base.world;

import com.basemod.base.init.ModBlocks;
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
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    /**
     * function to declare what ores will be generated
     */
    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(ModBlocks.ORE_COPPER.getDefaultState(),
                world, random, chunkX * 16, chunkZ * 16, 16, 70, random.nextInt(9) + 4, 18, BlockMatcher.forBlock(Blocks.STONE));

        generateOre(ModBlocks.ORE_TIN.getDefaultState(),
                world, random, chunkX * 16, chunkZ * 16, 32, 70, random.nextInt(10) + 5, 17, BlockMatcher.forBlock(Blocks.STONE));
    }

    // BlockMatcher block can be removed since it doesn't have any effect!

    /**
     * function to declare the generation of the ores (min/max height, cluster size, spawn tries
     */
    private void generateOre(IBlockState ore, World world, Random rand, int chunkX, int chunkZ, int minY, int maxY, int size, int spawnTries, BlockMatcher block) {
        int deltaY = maxY - minY + 1;
        if (minY < 0) minY = 0;
        if (maxY > 255) maxY = 255;

        for (int i = 0; i < spawnTries; i++) {
            BlockPos pos = new BlockPos(chunkX + rand.nextInt(16), minY + rand.nextInt(deltaY), chunkZ + rand.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, rand, pos);
        }
    }
}
