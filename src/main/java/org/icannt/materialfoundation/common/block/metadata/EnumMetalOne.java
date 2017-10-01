package org.icannt.materialfoundation.common.block.metadata;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 24/09/17.
 */
public enum EnumMetalOne implements IStringSerializable {
	
    IRON ("iron", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    GOLD ("gold", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    COPPER ("copper", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    TIN ("tin", EnumRarity.COMMON, "", "", 0, 1, 3, 30),
    SILVER ("silver", EnumRarity.COMMON, "", "", 4, 2, 3, 30),
    LEAD ("lead", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    ALUMINUM ("aluminum", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    NICKEL ("nickel", EnumRarity.COMMON, "", "", 0, 2, 3, 35),
    PLATINUM ("platinum", EnumRarity.UNCOMMON, "", "", 4, 3, 3, 30),
    IRIDIUM ("iridium", EnumRarity.UNCOMMON, "", "", 0, 3, 3, 30),
    MITHRIL ("mithril", EnumRarity.RARE, "", "", 8, 3, 3, 200),
    ARDITE ("ardite", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    COBALT ("cobalt", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    OSMIUM ("osmium", EnumRarity.COMMON, "", "", 0, 2, 3, 133),
    YELLORIUM ("yellorium", EnumRarity.COMMON, "", "", 0, 2, 3, 30),
    URANIUM ("uranium", EnumRarity.COMMON, "", "", 0, 2, 3, 30);

    private String name;
    private EnumRarity rarity;
    private String recipeOreDict;
    private String furnaceOreDict;
    private int light;
    private int harvestLevel;
    private float hardness;
    private float resistance;

    EnumMetalOne(String name, EnumRarity rarity, String recipeOreDict, String furnaceOreDict, int light, int harvestLevel, float hardness, float resistance) {
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
