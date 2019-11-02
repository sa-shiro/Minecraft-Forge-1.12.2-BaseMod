package com.basemod.base;

import com.basemod.base.init.ModRecipes;
import com.basemod.base.init.ModTab;
import com.basemod.base.proxy.CommonProxy;
import com.basemod.base.util.ModConfigManager;
import com.basemod.base.util.Resource;
import com.basemod.base.world.WorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = Resource.MOD_ID, name = Resource.NAME, version = Resource.VERSION)
public class Base {

    public static final CreativeTabs MOD_TAB = new ModTab("tabModTab");
    @Instance
    public static Base instance;
    @SidedProxy(clientSide = Resource.CLIENT_PROXY_CLASS, serverSide = Resource.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    private static Logger logger; // used to print messages to our console output

    /** This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.*/
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("initializing WorldGenerator");
        // initializing and loading our WorldGeneration into the game
        GameRegistry.registerWorldGenerator(new WorldGen(), 3);
        logger.info("finished initializing WorldGenerator");
    }

    /** This is the second initialization event. Register custom recipes*/
    @EventHandler
    public static void init(FMLInitializationEvent event) {
        // Initializing all Recipes
        logger.info("initializing Recipes");
        ModRecipes.init();
        logger.info("finished initializing Recipes");
        logger.info("saving / loading mod configuration");
        // we need to call our function here, in order to execute the save / load
        ModConfigManager.WorldGenerationConfig(event);
        logger.info("finished saving / loading mod configuration");
    }

    /** This is the final initialization event. Register actions from other mods here*/
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }
}