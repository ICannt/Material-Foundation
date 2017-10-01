package org.icannt.materialfoundation.common.block.metadata;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 24/09/17.
 */
public enum EnumMetalTwo implements IStringSerializable {
	
    STEEL ("steel", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    ELECTRUM ("electrum", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    INVAR ("invar", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    BRONZE ("bronze", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    CONSTANTAN ("constantan", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    SIGNALUM ("signalum", EnumRarity.UNCOMMON, "", "", 7, 2, 3, 30),
    LUMIUM ("lumium", EnumRarity.UNCOMMON, "", "", 15, 2, 3, 30),
    ENDERIUM ("enderium", EnumRarity.RARE, "", "", 4, 3, 3, 200),
    MANYULLYN ("manyullyn", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    KNIGHTSLIME ("knightslime", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    PIGIRON ("pigiron", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    ALUMINUM_BRASS ("aluminum_brass", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    CYANITE ("cyanite", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    GRAPHITE ("graphite", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    BLUTONIUM ("blutonium", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    LUDICRITE ("ludicrite", EnumRarity.COMMON, "", "", 0, 1, 3, 30);

    private String name;
    private EnumRarity rarity;
    private String recipeOreDict;
    private String furnaceOreDict;
    private int light;
    private int harvestLevel;
    private float hardness;
    private float resistance;

    EnumMetalTwo(String name, EnumRarity rarity, String recipeOreDict, String furnaceOreDict, int light, int harvestLevel, float hardness, float resistance) {
        this.name = name;
        this.rarity = rarity;
        this.recipeOreDict = recipeOreDict;
        this.furnaceOreDict = furnaceOreDict;
        this.light = light;
        this.harvestLevel = harvestLevel;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    @Override
    public String getName() {
        return name;
    }
    
    public EnumRarity getRarity() {
        return rarity;
    }
    
    public String getRecipeOreDict() {
        return recipeOreDict;
    }
    
    public String getFurnaceOreDict() {
        return furnaceOreDict;
    }

    public int getLight() {
        return light;
    }
    
    public int getHarvestLevel() {
        return harvestLevel;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

}
