package org.icannt.materialfoundation.block;

import java.util.List;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.gui.MFCreativeTab;
import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;
import org.icannt.materialfoundation.lib.MFMaterial;

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

/**
 * Metal Plate Checker
 */

public class BlockMetalPlateChecker extends Block
{
	
	public static String[] meta;
	public static int[] light;
	public static float[] hardness;
	public static float[] resistance;
	public static int[] rarity;
	
	public static String namePath;
		
	private static String texturePath;
	private static String blockName;
	
    public BlockMetalPlateChecker(String mfMaterial, String mfType, String mfSubType, String mfMeta[], int mfLight[], float mfHardness[], float mfResistance[], int mfRarity[])
    {
        super(Material.IRON);
        
		meta = mfMeta;
		light = mfLight;
		hardness = mfHardness;
		resistance = mfResistance;
		rarity = mfRarity;
		
		
		namePath = "." + mfMaterial.toLowerCase() + "." + mfType.toLowerCase() + "." + mfSubType.toLowerCase() + ".";
		texturePath = ":" + mfMaterial.toLowerCase() + "/" + mfType.toLowerCase() + "/" + mfSubType.toLowerCase() + "/" + mfType + "_" + mfSubType + "_";
		
		blockName = mfMaterial.toLowerCase() + "." + mfType.toLowerCase() + "." + mfSubType.toLowerCase();
		
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
