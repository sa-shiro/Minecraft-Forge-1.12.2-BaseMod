package com.basemod.base.blocks;

import com.basemod.base.Base;
import com.basemod.base.init.ModBlocks;
import com.basemod.base.init.ModItems;
import com.basemod.base.util.Resource;
import com.basemod.base.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    /**
     * Creating the Base of a new Mod Block
     */
    public BlockBase(String name, Material material) {
        super(material);
        /* Setting the Name of the Block */
        setTranslationKey(name);
        /* Sets the Sound type when you're Placing/Walking on it */
        setSoundType(SoundType.METAL);
        /* Setting the Registry Name of the Block / Item */
        setRegistryName(Resource.MOD_ID, name);
        /* The Tab where the Item will be placed */
        setCreativeTab(Base.MOD_TAB);
        /* Hardness of the Block; 5.0f = Iron Block || https://minecraftmodcustomstuff.fandom.com/wiki/Hardness */
        setHardness(5.0f);
        /* Explosion Resistance of an Block; 30.0F = Iron Block || https://minecraft.gamepedia.com/Explosion */
        setResistance(30.0f);
        /* HarvestLevel: 0 = Wood, 1 = Stone/Gold, 2 = Iron, 3 = Diamond || https://minecraftmodcustomstuff.fandom.com/wiki/HarvestLevel*/
        setHarvestLevel("pickaxe", 2);
        /* Set LightLevel of the Block || https://minecraft.gamepedia.com/Light */
        // setLightLevel(1.0f);
        /* Light Opacity, used for Windows */
        // setLightOpacity(1);
        /* Making the Block unbreakable! */
        // setBlockUnbreakable();

        /** Blocks need to be added as an Block and as an Item*/
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    /**
     * Registering the Model of the Mod Blocks
     */
    @Override
    public void registerModels() {
        Base.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
