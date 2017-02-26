package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 23/12/16.
 */
public enum EnumCompositeType implements IStringSerializable {
	
    BASE ("base", 0, 2, 30, EnumRarity.COMMON),
    REINFORCED_GRATING_DARK ("reinforced_grating_dark", 0, 2, 100, EnumRarity.COMMON),
    REINFORCED_GRATING_LIGHT ("reinforced_grating_light", 0, 2, 100, EnumRarity.COMMON),
    REINFORCED_PLATED_ARMOR_IRON ("reinforced_plated_armor_iron", 0, 2, 200, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumCompositeType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
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
