package com.basemod.base.items.tools.Copper;

import com.basemod.base.Base;
import com.basemod.base.init.ModItems;
import com.basemod.base.util.Resource;
import com.basemod.base.util.IHasModel;
import net.minecraft.item.ItemAxe;

public class CopperAxe extends ItemAxe implements IHasModel {

    /**
     * Creating the Base of a new Mod Tool
     */
    public CopperAxe(String name, ToolMaterial material) {
        super(material, 6.0f, -3.2f);
        setTranslationKey(name);
        setRegistryName(Resource.MOD_ID, name);
        setCreativeTab(Base.MOD_TAB);

        ModItems.ITEMS.add(this);
    }

    /**
     * Registering the Model of the Mod Items
     */
    @Override
    public void registerModels() {
        Base.proxy.registerItemRenderer(this, 0, "inventory");
    }
}