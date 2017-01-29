package org.icannt.materialfoundation.common.block.variant;

import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 25/12/16.
 */
public enum EnumMetalPaintedType implements IStringSerializable {

	WHITE ("white", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.WHITE),
	PINK ("pink", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.PINK),
	ORANGE ("orange", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.ORANGE),
	LIGHT_BLUE ("light_blue", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.LIGHT_BLUE),
	YELLOW ("yellow", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.YELLOW),
	MAGENTA ("magenta", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.MAGENTA),
	PURPLE ("purple", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.PURPLE),
	GRAY ("gray", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.GRAY),
	LIME ("lime", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.LIME),
	CYAN ("cyan", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.CYAN),
	RED ("red", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.RED),
	BLUE ("blue", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.BLUE),
	BROWN ("brown", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.BROWN),
	GREEN ("green", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.GREEN),
	SILVER ("silver", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.SILVER),
	BLACK ("black", 0, 5, 30, EnumRarity.COMMON, EnumPaintType.BLACK);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;
    private EnumPaintType paint;

    EnumMetalPaintedType(String name, int light, float hardness, float resistance, EnumRarity rarity, EnumPaintType paint) {
        this.name = name;
        this.light = light;
        this.hardness = hardness;
        this.resistance = resistance;
        this.rarity = rarity;
        this.paint = paint;
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

    public EnumPaintType getPaintColour() {
        return paint;
    }
}
