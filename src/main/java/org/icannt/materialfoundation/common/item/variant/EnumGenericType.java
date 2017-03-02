package org.icannt.materialfoundation.common.item.variant;

import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 01/01/17.
 */
public enum EnumGenericType implements IStringSerializable {

	MINERAL_LIME_BLAZE ("mineral_lime_blaze","dustBlazeLime","dustBlaze"),
	MINERAL_LIME_BURNT ("mineral_lime_burnt","dustBurntLime","dustBurntLime"),
	MINERAL_LIME_FLUXED ("mineral_lime_fluxed","dustFluxedLime","dustRedstone"),
	MINERAL_LIME_SLIME ("mineral_lime_slime","dustSlimeLime","slimeball"),
	MINERAL_CLINKER_CEMENT ("mineral_clinker_cement","dustCementClinker","dustCementClinker"),
	MINERAL_CEMENT_PORTLAND ("mineral_cement_portland","dustPortlandCement","dustCementClinker");

    private String name;
    private String oreDict;
    private String craftWith;

    EnumGenericType(String name, String oreDict, String craftWith) {
        this.name = name;
        this.oreDict = oreDict;
        this.craftWith = craftWith;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getOreDict() {
        return oreDict;
    }
    
    public String getCraftWith() {
        return craftWith;
    }

}