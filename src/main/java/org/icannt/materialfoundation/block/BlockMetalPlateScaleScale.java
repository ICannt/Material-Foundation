package org.icannt.materialfoundation.block;

import org.icannt.materialfoundation.gui.MFCreativeTab;
import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by trab
 */

public class BlockMetalPlateScaleScale extends Block
{
	
	public static String[] meta;
	public static int[] light;
	public static float[] hardness;
	public static float[] resistance;
	public static int[] rarity;
	
	public static String namePath;

	private static String topBottomTextureFolder;
	private static String sideTextureFolder;
	private static String topBottomSubType;
	private static String sideSubType;
	
	private static String topBottomTexturePath;
	private static String sideTexturePath;
	private static String blockName;
	
    public BlockMetalPlateScaleScale(String mfMaterial, String mfType, String mfSubType, String mfMeta[], int mfLight[], float mfHardness[], float mfResistance[], int mfRarity[])
    {
        super(Material.IRON);
        
		meta = mfMeta;
		light = mfLight;
		hardness = mfHardness;
		resistance = mfResistance;
		rarity = mfRarity;       
        
		topBottomSubType = mfSubType.split(":")[1];
		sideSubType = mfSubType.split(":")[0];

		topBottomTextureFolder = topBottomSubType.split("_")[0].toLowerCase();
		sideTextureFolder = sideSubType.split("_")[0].toLowerCase();

		topBottomSubType = mfSubType.split(":")[1];
		sideSubType = mfSubType.split(":")[0];
		
		topBottomTexturePath = ":" + mfMaterial.toLowerCase() + "/" + mfType.toLowerCase() + "/" + topBottomTextureFolder + "/" + mfType + "_" + topBottomSubType + "_";
		sideTexturePath = ":" + mfMaterial.toLowerCase() + "/" + mfType.toLowerCase() + "/" + sideTextureFolder + "/" + mfType + "_" + sideSubType + "_";
		
		blockName = mfMaterial.toLowerCase() + "." + mfType.toLowerCase() + "." + sideTextureFolder + "_" + topBottomTextureFolder;
		namePath = "." + blockName + ".";
		
		// this.setBlockName(Constants.MODID + "." + blockName);
		// this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab(MFCreativeTab.mfCreativeTab);
    }

    /*
    @Override
    public int damageDropped(int i)
    {
        return i;
    }
    */

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < meta.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    /*
    @Override
    public float getBlockHardness(World world, int x, int y, int z)
    {
        return hardness[world.getBlockMetadata(x, y, z)];
    }
    
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
       	return light[world.getBlockMetadata(x, y, z)];
    }
    
    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
    	return resistance[world.getBlockMetadata(x, y, z)];
    }   
    */
}
