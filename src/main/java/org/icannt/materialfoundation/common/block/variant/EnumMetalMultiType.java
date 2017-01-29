package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 30/12/16.
 */
public enum EnumMetalMultiType implements IStringSerializable {

	IRON ("iron", "IRON", "ROUND_OFFSET_IRON", 0, 5, 30, EnumRarity.COMMON),
	IRON_GOLD ("iron_gold", "IRON", "ROUND_OFFSET_GOLD", 0, 5, 30, EnumRarity.COMMON),
	TIN_IRON ("tin_iron", "TIN", "ROUND_OFFSET_IRON", 0, 5, 30, EnumRarity.COMMON),
	DARK_STEEL_BLAZE ("dark_steel_blaze", "DARK_STEEL", "ROUND_OFFSET_BLAZE", 0, 5, 30, EnumRarity.COMMON),
	DARK_STEEL_LAPIS ("dark_steel_lapis", "DARK_STEEL", "ROUND_OFFSET_LAPIS", 0, 5, 30, EnumRarity.COMMON),
	DARK_STEEL_SLIME ("dark_steel_slime", "DARK_STEEL", "ROUND_OFFSET_SLIME", 0, 5, 30, EnumRarity.COMMON),
	FLUXED_GOLD ("fluxed_gold", "FLUXED", "ROUND_OFFSET_GOLD", 0, 5, 30, EnumRarity.COMMON);

    private String name;
    private String plateName;
    private String grillName;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumMetalMultiType(String name, String plateName, String grillName, int light, float hardness, float resistance, EnumRarity rarity) {
        this.name = name;
        this.plateName = plateName;
        this.grillName = grillName;
        this.light = light;
        this.hardness = hardness;
        this.resistance = resistance;
        this.rarity = rarity;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPlateName() {
        return plateName;
    }
    
    public String getGrillName() {
        return grillName;
    }
    
    public int getLight() {
        return light;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    public EnumRarity getRarity() {
        return rarity;
    }
}
