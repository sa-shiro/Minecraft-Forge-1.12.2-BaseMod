package com.basemod.base.init;

import com.basemod.base.items.ItemBase;
import com.basemod.base.items.armor.ArmorBase;
import com.basemod.base.items.tools.Copper.*;
import com.basemod.base.items.tools.Tin.*;
import com.basemod.base.util.Resource;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    /**
     * Storing all Mod Items in an Array List
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();
    /**
     * function  to create new Items
     */
    public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
    public static final Item INGOT_TIN = new ItemBase("ingot_tin");
    /**
     * function to create new Materials
     */
    private static final ToolMaterial MATERIAL_COPPER = EnumHelper.addToolMaterial("material_copper", 2, 285, 6.5f, 2.5f, 14);
    /**
     * function to create new Tools
     */
    // Copper Tools
    public static final ItemSword COPPER_Sword = new CopperSword("copper_sword", MATERIAL_COPPER);
    public static final ItemPickaxe COPPER_PICKAXE = new CopperPickaxe("copper_pickaxe", MATERIAL_COPPER);
    public static final ItemSpade COPPER_SHOVEL = new CopperSpade("copper_shovel", MATERIAL_COPPER);
    public static final ItemAxe COPPER_AXE = new CopperAxe("copper_axe", MATERIAL_COPPER);
    public static final ItemHoe COPPER_HOE = new CopperHoe("copper_hoe", MATERIAL_COPPER);
    private static final ToolMaterial MATERIAL_TIN = EnumHelper.addToolMaterial("material_tin", 2, 230, 5.5F, 1.5F, 14);
    // Tin Tools
    public static final ItemSword TIN_Sword = new TinSword("tin_sword", MATERIAL_TIN);
    public static final ItemPickaxe TIN_PICKAXE = new TinPickaxe("tin_pickaxe", MATERIAL_TIN);
    public static final ItemSpade TIN_SHOVEL = new TinSpade("tin_shovel", MATERIAL_TIN);
    public static final ItemAxe TIN_AXE = new TinAxe("tin_axe", MATERIAL_TIN);
    public static final ItemHoe TIN_HOE = new TinHoe("tin_hoe", MATERIAL_TIN);
    /**
     * function to create new Armor Materials
     */
    // new int[] { BOOTS, LEGGINGS, CHESTPLATE, HELMET }
    private static final ArmorMaterial ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial("armor_material_copper", Resource.MOD_ID + ":copper", 10,
            new int[]{2, 5, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
    /**
     * function to create new Armor
     */
    // Copper Armor
    public static final Item COPPER_HELMET = new ArmorBase("copper_helmet", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.HEAD);
    public static final Item COPPER_CHESTPLATE = new ArmorBase("copper_chestplate", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.CHEST);
    public static final Item COPPER_LEGGINGS = new ArmorBase("copper_leggings", ARMOR_MATERIAL_COPPER, 2, EntityEquipmentSlot.LEGS);
    public static final Item COPPER_BOOTS = new ArmorBase("copper_boots", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.FEET);

    /** function to create new Food */
    // https://minecraft.gamepedia.com/Hunger
    // public static final Item FOOD_NAME = new FoodBase("food_name", 2, 3.5f, false);

    /** function to create new Food with Effects */
    // public static final Item FOOD_NAME = new FoodEffectBase("food_name", 2, 3.5f, false,
    //		new PotionEffect(MobEffects.HASTE, 60*20, 0, false, true));
}