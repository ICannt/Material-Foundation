package org.icannt.materialfoundation.common.block;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.client.creativetab.TabMaterialFoundation;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;


/**
 * Created by ICannt on 24/09/17.
 */
public class BlockVariantBase extends Block {
	
    public BlockVariantBase(Material material, MapColor mapColor, String registry) {
        super(material, mapColor);
        setRegistryName(MaterialFoundation.MOD_ID, registry);
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setHarvestLevel("pickaxe", 0);
    }
    
}