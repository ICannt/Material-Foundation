package org.icannt.materialfoundation.common.block.state;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 25/12/16.
 */
public enum EnumMetalPaintedType implements IStringSerializable {

	BLACK ("black", 0, 5, 30, EnumRarity.COMMON),
	BLUE ("blue", 0, 5, 30, EnumRarity.COMMON),
	BROWN ("brown", 0, 5, 30, EnumRarity.COMMON),
	CYAN ("cyan", 0, 5, 30, EnumRarity.COMMON),
	GRAY ("gray", 0, 5, 30, EnumRarity.COMMON),
	GREEN ("green", 0, 5, 30, EnumRarity.COMMON),
	LIGHT_BLUE ("light_blue", 0, 5, 30, EnumRarity.COMMON),
	LIME ("lime", 0, 5, 30, EnumRarity.COMMON),
	MAGENTA ("magenta", 0, 5, 30, EnumRarity.COMMON),
	ORANGE ("orange", 0, 5, 30, EnumRarity.COMMON),
	PINK ("pink", 0, 5, 30, EnumRarity.COMMON),
	PURPLE ("purple", 0, 5, 30, EnumRarity.COMMON),
	RED ("red", 0, 5, 30, EnumRarity.COMMON),
	SILVER ("silver", 0, 5, 30, EnumRarity.COMMON),
	WHITE ("white", 0, 5, 30, EnumRarity.COMMON),
	YELLOW ("yellow", 0, 5, 30, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumMetalPaintedType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
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
