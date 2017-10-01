package org.icannt.materialfoundation.common.block.metadata;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 24/09/17.
 */
public enum EnumMetalThree implements IStringSerializable {
	
    ELECTRICAL_STEEL ("electrical_steel", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    ENERGETIC_ALLOY ("energetic_alloy", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    VIBRANT_ALLOY ("vibrant_alloy", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    REDSTONE_ALLOY ("redstone_alloy", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    CONDUCTIVE_IRON ("conductive_iron", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    PULSATING_IRON ("pulsating_iron", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    DARK_STEEL ("dark_steel", EnumRarity.COMMON, "", "", 0, 1, 3, 45),
    SOULARIUM ("soularium", EnumRarity.COMMON, "", "", 0, 1, 3, 45),
    REFINED_OBSIDIAN ("refined_obsidian", EnumRarity.COMMON, "", "", 0, 1, 3, 500),
    REFINED_GLOWSTONE ("refined_glowstone", EnumRarity.COMMON, "", "", 15, 1, 3, 133);

    private String name;
    private EnumRarity rarity;
    private String recipeOreDict;
    private String furnaceOreDict;
    private int light;
    private int harvestLevel;
    private float hardness;
    private float resistance;

    EnumMetalThree(String name, EnumRarity rarity, String recipeOreDict, String furnaceOreDict, int light, int harvestLevel, float hardness, float resistance) {
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
