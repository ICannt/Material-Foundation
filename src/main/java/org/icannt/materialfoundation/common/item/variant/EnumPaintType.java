package org.icannt.materialfoundation.common.item.variant;

import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 26/12/16.
 */
public enum EnumPaintType implements IStringSerializable {

	EMPTY ("empty"),
	BLACK ("black"),
	SILVER ("silver"),
	GREEN ("green"),
	BROWN ("brown"),
	BLUE ("blue"),
	RED ("red"),
	CYAN ("cyan"),
	LIME ("lime"),
	GRAY ("gray"),
	PURPLE ("purple"),
	MAGENTA ("magenta"),
	YELLOW ("yellow"),
	LIGHT_BLUE ("light_blue"),
	ORANGE ("orange"),
	PINK ("pink"),
	WHITE ("white");

    private String name;

    EnumPaintType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}