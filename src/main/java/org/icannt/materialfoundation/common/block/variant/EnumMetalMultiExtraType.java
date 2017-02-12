package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 29/01/17.
 */
public enum EnumMetalMultiExtraType implements IStringSerializable {

	DARK_STEEL_GOLD ("dark_steel_gold", "DARK_STEEL", "ROUND_OFFSET_GOLD", 0, 2, 30, EnumRarity.COMMON),
	DARK_STEEL_IRON ("dark_steel_iron", "DARK_STEEL", "ROUND_OFFSET_IRON", 0, 2, 30, EnumRarity.COMMON),
	FLUXED_BLAZE ("fluxed_blaze", "FLUXED", "ROUND_OFFSET_BLAZE", 0, 2, 30, EnumRarity.COMMON),
	FLUXED_IRON ("fluxed_iron", "FLUXED", "ROUND_OFFSET_IRON", 0, 2, 30, EnumRarity.COMMON),
	FLUXED_LAPIS ("fluxed_lapis", "FLUXED", "ROUND_OFFSET_LAPIS", 0, 2, 30, EnumRarity.COMMON),
	FLUXED_SLIME ("fluxed_slime", "FLUXED", "ROUND_OFFSET_SLIME", 0, 2, 30, EnumRarity.COMMON),
	IRON_BLAZE ("iron_blaze", "IRON", "ROUND_OFFSET_BLAZE", 0, 2, 30, EnumRarity.COMMON),
	IRON_LAPIS ("iron_lapis", "IRON", "ROUND_OFFSET_LAPIS", 0, 2, 30, EnumRarity.COMMON),
	IRON_SLIME ("iron_slime", "IRON", "ROUND_OFFSET_SLIME", 0, 2, 30, EnumRarity.COMMON),
	TIN_BLAZE ("tin_blaze", "TIN", "ROUND_OFFSET_BLAZE", 0, 2, 30, EnumRarity.COMMON),
	TIN_GOLD ("tin_gold", "TIN", "ROUND_OFFSET_GOLD", 0, 2, 30, EnumRarity.COMMON),
	TIN_LAPIS ("tin_lapis", "TIN", "ROUND_OFFSET_LAPIS", 0, 2, 30, EnumRarity.COMMON),
	TIN_SLIME ("tin_slime", "TIN", "ROUND_OFFSET_SLIME", 0, 2, 30, EnumRarity.COMMON);

    private String name;
    private String plateName;
    private String grillName;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumMetalMultiExtraType(String name, String plateName, String grillName, int light, float hardness, float resistance, EnumRarity rarity) {
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
