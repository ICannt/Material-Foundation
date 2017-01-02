package org.icannt.materialfoundation.common.item.variant;

import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 26/12/16.
 */
public enum EnumPaintType implements IStringSerializable {

	EMPTY ("empty", "Empty"),
	BLACK ("black", "Black"),
	SILVER ("silver", "Silver"),
	GREEN ("green", "Green"),
	BROWN ("brown", "Brown"),
	BLUE ("blue", "Blue"),
	RED ("red", "Red"),
	CYAN ("cyan", "Cyan"),
	LIME ("lime", "Lime"),
	GRAY ("gray", "Gray"),
	PURPLE ("purple", "Purple"),
	MAGENTA ("magenta", "Magenta"),
	YELLOW ("yellow", "Yellow"),
	LIGHT_BLUE ("light_blue", "Light Blue"),
	ORANGE ("orange", "Orange"),
	PINK ("pink", "Pink"),
	WHITE ("white", "White");

    private String name;
    private String localised;

    EnumPaintType(String name, String localised) {
        this.name = name;
        this.localised = localised;
    }

    @Override
    public String getName() {
        return name;
    }

	public String getLocalised() {
		return localised;
	}
}