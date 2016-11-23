package org.icannt.materialfoundation.lib;

public class MFMaterial
{
	public static final String[] MFRarity = { "Common", "Uncommon", "Rare", "Epic" };
	
	public static final String[] Metal = { "Iron", "Gold", "Copper", "Tin", "Silver", "Lead", "Nickel",
	"Platinum", "Mithril", "Electrum", "Invar", "Bronze", "Signalum", "Lumium", "Enderium" };
	public static final int[] MetalLight = { 0, 0, 0, 0, 4, 0, 0, 4, 8, 0, 0, 0, 7, 15, 4 };
	public static final float[] MetalHardness = { 5, 3, 5, 5, 5, 4, 10, 5, 30, 4, 20, 5, 5, 5, 40 };
	public static final float[] MetalResistance = { 30, 30, 6, 6, 6, 12, 6, 6, 120, 6, 12, 6, 9, 9, 120 };
	public static final int[] MetalRarity = { 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 1, 1, 2 };

	public static final String[] Composite = { "Basic" };
	public static final int[] CompositeLight = { 0 };
	public static final float[] CompositeHardness = { 5 };
	public static final float[] CompositeResistance = { 30 };
	public static final int[] CompositeRarity = { 0 };
	
	
	/*
	public static final String[] MetalType = { "Plate" };
	public static final String[] MetalSubtype = { "Checker", "Scale_Checker" };
	public static final Object[] MetalIngots = { Items.iron_ingot, Items.gold_ingot, TFItems.ingotCopper };
	public static final Object[] MetalIngots = { Items.iron_ingot, Items.gold_ingot };
	*/
}
