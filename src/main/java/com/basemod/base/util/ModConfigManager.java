package com.basemod.base.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;

/**
 * This class is used to generate our config! to add a new configuration file,
 * simply copy "WorldGenerationConfig" and rename/modify it!
 */
public class ModConfigManager {

    // int / float / string / boolean variables we are using in our Config!
    public static boolean oreCopper;
    public static int copperMinHeight;
    public static int copperMaxHeight;
    public static int copperSpawnTries;
    public static int copperVeinSize;
    public static boolean oreTin;
    public static int tinMinHeight;
    public static int tinMaxHeight;
    public static int tinSpawnTries;
    public static int tinVeinSize;

    public static void WorldGenerationConfig(FMLInitializationEvent event) {
        // Creating a new Configuration file
        Configuration config = new Configuration(new File("config/basemod/world.cfg"));
        // function to load our config (very important!)
        config.load();
        // Adding items to our config with: Category, Name of the item, Default value || Example of how it will look:
        /**
         * worldgen {
         *      B:"Copper Ore"=true
         * }
         */
        // those keys set here will control our World Generation in /world/WorldGen.java
        oreCopper = config.get("WorldGen", "Copper Ore", true).getBoolean();
        copperMinHeight = config.get("WorldGen", "Copper min spawn height", 16).getInt();
        copperMaxHeight = config.get("WorldGen", "Copper max spawn height", 80).getInt();
        copperSpawnTries = config.get("WorldGen", "Copper spawn tries", 15).getInt();
        copperVeinSize = config.get("WorldGen", "Copper vein size", 20).getInt();
        oreTin = config.get("WorldGen", "Tin Ore", true).getBoolean();
        tinMinHeight = config.get("WorldGen", "Tin min spawn height", 16).getInt();
        tinMaxHeight = config.get("WorldGen", "Tin max spawn height", 80).getInt();
        tinSpawnTries = config.get("WorldGen", "Tin spawn tries", 15).getInt();
        tinVeinSize = config.get("WorldGen", "Tin vein size", 20).getInt();
        // function to save our config (very important!)
        config.save();
    }
}
