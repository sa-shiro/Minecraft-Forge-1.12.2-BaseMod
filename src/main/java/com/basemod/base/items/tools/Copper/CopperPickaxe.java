package com.basemod.base.items.tools.Copper;

import com.basemod.base.Base;
import com.basemod.base.init.ModItems;
import com.basemod.base.util.Resource;
import com.basemod.base.util.IHasModel;
import net.minecraft.item.ItemPickaxe;

public class CopperPickaxe extends ItemPickaxe implements IHasModel {

    /**
     * Creating the Base of a new Mod Item
     */
    public CopperPickaxe(String name, ToolMaterial material) {
        super(material);
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
