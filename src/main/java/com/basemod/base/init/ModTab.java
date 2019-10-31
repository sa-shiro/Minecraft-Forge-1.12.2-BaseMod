package com.basemod.base.init;

import com.basemod.base.util.Resource;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTab extends CreativeTabs {

    /**
     * creating the Name of a new Creative Tab
     */
    public ModTab(String name) {
        super(Resource.MOD_ID + "." + name);
    }

    /**
     * adding an Icon to the new Creative Tab
     */
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.INGOT_TIN);
    }
}
