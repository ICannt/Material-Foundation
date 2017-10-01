package org.icannt.materialfoundation.common.block.metadata;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 01/10/17.
 */
public enum EnumMetalPainted implements IStringSerializable {
	
    WHITE ("white", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    PINK ("pink", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    ORANGE ("orange", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    LIGHT_BLUE ("light_blue", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    YELLOW ("yellow", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    MAGENTA ("magenta", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    PURPLE ("purple", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    GRAY ("gray", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    LIME ("lime", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    CYAN ("cyan", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    RED ("red", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    BLUE ("blue", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    BROWN ("brown", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    GREEN ("green", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    LIGHT_GRAY ("light_gray", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    BLACK ("black", EnumRarity.COMMON, "", "", 0, 1, 3, 30);

    private String name;
    private EnumRarity rarity;
    private String recipeOreDict;
    private String furnaceOreDict;
    private int light;
    private int harvestLevel;
    private float hardness;
    private float resistance;

    EnumMetalPainted(String name, EnumRarity rarity, String recipeOreDict, String furnaceOreDict, int light, int harvestLevel, float hardness, float resistance) {
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
