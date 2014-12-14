package org.icannt.materialfoundation.block;

import org.icannt.materialfoundation.gui.MFCreativeTab;
import org.icannt.materialfoundation.lib.Constants;
import org.icannt.materialfoundation.lib.DB;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by trab
 */

public class BlockMetalPlateScaleChecker extends Block
{
	
	public static String[] meta;
	public static int[] light;
	public static float[] hardness;
	public static float[] resistance;
	public static int[] rarity;
	
	public static String namePath;

	@SideOnly(Side.CLIENT)
	public IIcon[] topBottomTexture;
	@SideOnly(Side.CLIENT)
	public IIcon[] sideTexture;

	private static String topBottomTextureFolder;
	private static String sideTextureFolder;
	private static String topBottomSubType;
	private static String sideSubType;
	
	private static String topBottomTexturePath;
	private static String sideTexturePath;
	private static String blockName;
	
    public BlockMetalPlateScaleChecker(String mfMaterial, String mfType, String mfSubType, String mfMeta[], int mfLight[], float mfHardness[], float mfResistance[], int mfRarity[])
    {
        super(Material.iron);
        
		meta = mfMeta;
		light = mfLight;
		hardness = mfHardness;
		resistance = mfResistance;
		rarity = mfRarity;       
        
		topBottomSubType = mfSubType.split(":")[1];
		sideSubType = mfSubType.split(":")[0];

		topBottomTextureFolder = topBottomSubType.split("_")[0].toLowerCase();
		sideTextureFolder = sideSubType.split("_")[0].toLowerCase();
	
		topBottomTexture = new IIcon[meta.length];
		sideTexture = new IIcon[meta.length];

		topBottomSubType = mfSubType.split(":")[1];
		sideSubType = mfSubType.split(":")[0];
		
		topBottomTexturePath = ":" + mfMaterial.toLowerCase() + "/" + mfType.toLowerCase() + "/" + topBottomTextureFolder + "/" + mfType + "_" + topBottomSubType + "_";
		sideTexturePath = ":" + mfMaterial.toLowerCase() + "/" + mfType.toLowerCase() + "/" + sideTextureFolder + "/" + mfType + "_" + sideSubType + "_";
		
		blockName = mfMaterial.toLowerCase() + "." + mfType.toLowerCase() + "." + sideTextureFolder + "_" + topBottomTextureFolder;
		namePath = "." + blockName + ".";
		
		this.setBlockName(Constants.MODID + "." + blockName);
		this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab(MFCreativeTab.mfCreativeTab);
    }

    @Override
    public int damageDropped(int i)
    {
        return i;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < meta.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
   
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
		if(side == 0 || side == 1)
		{
			return topBottomTexture[metadata];
		}
		else
		{
			return sideTexture[metadata];
		}
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        for (int i = 0; i < meta.length; i++)
        {
    		topBottomTexture[i] = ir.registerIcon(Constants.MODID + topBottomTexturePath + meta[i]);
    		sideTexture[i] = ir.registerIcon(Constants.MODID + sideTexturePath + meta[i]);
        }
    }
    
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
    
}
