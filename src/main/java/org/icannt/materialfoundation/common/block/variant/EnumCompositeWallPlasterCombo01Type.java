package org.icannt.materialfoundation.common.block.variant;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 14/02/17.
 */
public enum EnumCompositeWallPlasterCombo01Type implements IStringSerializable {
	
	WALL_PLASTER_COMBO_NORMAL_STAIRWELL_01A ("wall_plaster_combo_normal_stairwell_01a", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_NORMAL_STAIRWELL_01B ("wall_plaster_combo_normal_stairwell_01b", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_NORMAL_STAIRWELL_01C ("wall_plaster_combo_normal_stairwell_01c", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_NORMAL_STAIRWELL_01D ("wall_plaster_combo_normal_stairwell_01d", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_FLIPPED_STAIRWELL_01A ("wall_plaster_combo_flipped_stairwell_01a", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_FLIPPED_STAIRWELL_01B ("wall_plaster_combo_flipped_stairwell_01b", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_FLIPPED_STAIRWELL_01C ("wall_plaster_combo_flipped_stairwell_01c", 0, 2, 30, EnumRarity.COMMON),
	WALL_PLASTER_COMBO_FLIPPED_STAIRWELL_01D ("wall_plaster_combo_flipped_stairwell_01d", 0, 2, 30, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumCompositeWallPlasterCombo01Type(String name, int light, float hardness, float resistance, EnumRarity rarity) {
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
