package com.basemod.base;

import com.basemod.base.init.ModRecipes;
import com.basemod.base.init.ModTab;
import com.basemod.base.proxy.CommonProxy;
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
    private static Logger logger;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("initializing WorldGenerator");
        GameRegistry.registerWorldGenerator(new WorldGen(), 3);
        logger.info("finished initializing WorldGenerator");
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        // Initializing all Recipes
        logger.info("initializing Recipes");
        ModRecipes.init();
        logger.info("finished initializing Recipes");
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }
}