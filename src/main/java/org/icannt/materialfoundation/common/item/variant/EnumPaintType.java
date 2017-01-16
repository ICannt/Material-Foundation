package org.icannt.materialfoundation.common.item.variant;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 26/12/16.
 */
public enum EnumPaintType implements IStringSerializable {

	EMPTY ("empty", "Empty", new Object[]{}),
	BLACK ("black", "Black", new Object[]{"dyeBlack"}),
	SILVER ("silver", "Silver", new Object[]{"dyeLightGray"}),
	GREEN ("green", "Green", new Object[]{"dyeGreen"}),
	BROWN ("brown", "Brown", new Object[]{"dyeBrown"}),
	BLUE ("blue", "Blue", new Object[]{"dyeBlue"}),
	RED ("red", "Red", new Object[]{"dyeRed"}),
	CYAN ("cyan", "Cyan", new Object[]{"dyeCyan"}),
	LIME ("lime", "Lime", new Object[]{"dyeLime"}),
	GRAY ("gray", "Gray", new Object[]{"dyeGray"}),
	PURPLE ("purple", "Purple", new Object[]{"dyePurple"}),
	MAGENTA ("magenta", "Magenta", new Object[]{"dyeMagenta"}),
	YELLOW ("yellow", "Yellow", new Object[]{"dyeYellow"}),
	LIGHT_BLUE ("light_blue", "Light Blue", new Object[]{"dyeLightBlue"}),
	ORANGE ("orange", "Orange", new Object[]{"dyeOrange"}),
	PINK ("pink", "Pink", new Object[]{"dyePink"}),
	WHITE ("white", "White", new Object[]{"dyeWhite"}),
	SLIME("slime", "Slime", new Object[]{new ItemStack(Items.SLIME_BALL)}),
	BLAZE("blaze", "Blaze", new Object[]{new ItemStack(Items.BLAZE_POWDER)}),
	FLUXED("fluxed", "Fluxed", new Object[]{new ItemStack(Items.REDSTONE)});

    private String name;
    private String localised;
    private Object[] catalyst;

    EnumPaintType(String name, String localised, Object[] catalyst) {
        this.name = name;
        this.localised = localised;
        this.catalyst = catalyst;
    }

    @Override
    public String getName() {
        return name;
    }

	public String getLocalisedName() {
		return localised;
	}

	public Object[] getRecipeCatalyst() {
		return catalyst;
	}
}