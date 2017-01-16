package org.icannt.materialfoundation.common.block;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

import java.util.Random;

/**
 * Created by ICannt on 14/1/17.
 */
public class BlockGlassVariantBase extends BlockGlass {
	
    public BlockGlassVariantBase(Material material, boolean ignoreSimilarityIn, String registry) {
        super(material, ignoreSimilarityIn);
        setRegistryName(MaterialFoundation.MOD_ID, registry);
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
    }
    
    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }

}
