package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 14/02/17.
 */
public enum EnumCompositeWallPlasterComboType implements IStringSerializable {
	
	COMBO_01 ("combo_01", 0, 2, 10, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumCompositeWallPlasterComboType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
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
