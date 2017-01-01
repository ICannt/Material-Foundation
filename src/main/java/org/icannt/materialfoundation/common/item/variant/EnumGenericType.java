package org.icannt.materialfoundation.common.item.variant;

import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 01/01/17.
 */
public enum EnumGenericType implements IStringSerializable {

	MINERAL_LIME_BURNT ("mineral_burnt_lime"),
	MINERAL_LIME_SLIME ("mineral_lime_slime");

    private String name;

    EnumGenericType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}