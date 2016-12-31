package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 30/12/16.
 */
public enum EnumMetalMultiType implements IStringSerializable {

	IRON ("iron", 0, 5, 30, EnumRarity.COMMON),
	IRON_GOLD ("iron_gold", 0, 5, 30, EnumRarity.COMMON),
	TIN_IRON ("tin_iron", 0, 5, 30, EnumRarity.COMMON),
	DARK_STEEL_BLAZE ("dark_steel_blaze", 0, 5, 30, EnumRarity.COMMON),
	DARK_STEEL_LAPIS ("dark_steel_lapis", 0, 5, 30, EnumRarity.COMMON),
	DARK_STEEL_SLIME ("dark_steel_slime", 0, 5, 30, EnumRarity.COMMON),
	FLUXED_GOLD ("fluxed_gold", 0, 5, 30, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumMetalMultiType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
        this.name = name;
        this.light = light;
        this.hardness = hardness;
        this.resistance = resistance;
        this.rarity = rarity;
    }

    @Override
    public String getName() {
        return name;
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
