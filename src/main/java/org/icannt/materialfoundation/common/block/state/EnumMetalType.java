package org.icannt.materialfoundation.common.block.state;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by Liam on 21/12/16.
 */
public enum EnumMetalType implements IStringSerializable {

    IRON("iron", 0, 5, 30, EnumRarity.COMMON),
    GOLD("gold", 0, 3, 30, EnumRarity.COMMON),
    COPPER("copper", 0, 5, 6, EnumRarity.COMMON),
    TIN("tin", 0, 5, 6, EnumRarity.COMMON),
    SILVER("silver", 4, 5, 6, EnumRarity.COMMON),
    LEAD("lead", 0, 4, 12, EnumRarity.COMMON),
    NICKEL("nickel", 0, 10, 6, EnumRarity.COMMON),
    PLATINUM("platinum", 4, 5, 6, EnumRarity.UNCOMMON),
    MITHRIL("mithril", 8, 30, 120, EnumRarity.RARE),
    ELECTRUM("electrum", 0, 4, 6, EnumRarity.COMMON),
    INVAR("invar", 0, 20, 12, EnumRarity.COMMON),
    BRONZE("bronze", 0, 5, 6, EnumRarity.COMMON),
    SIGNALUM("signalum", 7, 5, 9, EnumRarity.UNCOMMON),
    LUMIUM("lumium", 15, 5, 9, EnumRarity.UNCOMMON),
    ENDERIUM("enderium", 4, 40, 120, EnumRarity.RARE);

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
