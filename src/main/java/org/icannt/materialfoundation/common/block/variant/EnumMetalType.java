package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 21/12/16.
 */
public enum EnumMetalType implements IStringSerializable {

	IRON ("iron", 0, 5, 30, EnumRarity.COMMON),
	GOLD ("gold", 0, 5, 30, EnumRarity.COMMON),
	COPPER ("copper", 0, 5, 30, EnumRarity.COMMON),
	TIN ("tin", 0, 5, 30, EnumRarity.COMMON),
	BRONZE ("bronze", 0, 5, 30, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumMetalType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
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
