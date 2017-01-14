package org.icannt.materialfoundation.common.block.blocks;

import java.util.List;

import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.variant.EnumMetalGrillType;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;
import org.icannt.materialfoundation.common.init.ModBlocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ICannt on 04/01/17.
 */
public class BlockMetalGrill extends BlockPane {

	private static final PropertyEnum<EnumMetalGrillType> VARIANT = PropertyEnum.create("grill", EnumMetalGrillType.class);
	
	public BlockMetalGrill() {
		super(Material.IRON, true);
        setRegistryName(MaterialFoundation.MOD_ID, "metal_grill");
        setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(VARIANT, EnumMetalGrillType.ROUND_OFFSET_BLAZE));
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
	}

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,new IProperty[]{NORTH, SOUTH, EAST, WEST, VARIANT});
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (EnumMetalGrillType type : EnumMetalGrillType.values()) {
            list.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(VARIANT, EnumMetalGrillType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getValue(VARIANT).getLight();
    }

    @SuppressWarnings("deprecation")
    @Override
    public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
        return state.getValue(VARIANT).getHardness();
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        return world.getBlockState(pos).getValue(VARIANT).getResistance();
    }

    @Override
    public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return super.canPaneConnectTo(world, pos, dir) && world.getBlockState(pos).getBlock() == ModBlocks.METAL_GRILL;
    }

    @SideOnly(Side.CLIENT)
    public void initClient() {
	    for (EnumMetalGrillType variant : EnumMetalGrillType.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), variant.ordinal(), new ModelResourceLocation(ModBlocks.METAL_GRILL.getRegistryName() + "_" + variant.getName(), "inventory"));
        }
	    /*
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(this), stack -> {
            int meta = stack.getMetadata();

            EnumMetalGrillType metal = EnumMetalGrillType.values()[meta];
            BlockRendererDispatcher dispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            Map<IBlockState, ModelResourceLocation> variants = dispatcher.getBlockModelShapes().getBlockStateMapper().getVariants(BlockMetalGrill.this);
            return variants.get(BlockMetalGrill.this.getDefaultState().withProperty(VARIANT, metal));
        });
        */
    }
}
