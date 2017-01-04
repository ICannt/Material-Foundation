package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 04/01/17.
 */
public enum EnumMetalGrillType implements IStringSerializable {

	ROUND_OFFSET_BLAZE ("round_offset_blaze", 0, 5, 30, EnumRarity.COMMON),
	ROUND_OFFSET_GOLD ("round_offset_gold", 0, 5, 30, EnumRarity.COMMON),
	ROUND_OFFSET_IRON ("round_offset_iron", 0, 5, 30, EnumRarity.COMMON),
	ROUND_OFFSET_LAPIS ("round_offset_lapis", 0, 5, 30, EnumRarity.COMMON),
	ROUND_OFFSET_SLIME ("round_offset_slime", 0, 5, 30, EnumRarity.COMMON),
	SQUARE_ANGLED_DARK ("square_angled_dark", 0, 5, 30, EnumRarity.COMMON),
	SQUARE_ANGLED_LIGHT ("square_angled_light", 0, 5, 30, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumMetalGrillType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
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
