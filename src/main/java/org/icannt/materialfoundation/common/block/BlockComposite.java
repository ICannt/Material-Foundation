package org.icannt.materialfoundation.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.state.EnumCompositeType;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

import java.util.Map;

/**
 * Created by ICannt on 23/12/16.
 */
public class BlockComposite extends Block {

    public static final PropertyEnum<EnumCompositeType> COMPOSITE_VARIANT = PropertyEnum.create("composite", EnumCompositeType.class);

    public BlockComposite() {
        super(Material.ROCK, MapColor.GRAY);
        setRegistryName(MaterialFoundation.MOD_ID, "composite");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, COMPOSITE_VARIANT);
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(COMPOSITE_VARIANT, EnumCompositeType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(COMPOSITE_VARIANT).ordinal();
    }

    @SuppressWarnings("deprecation")
    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return blockState.getValue(COMPOSITE_VARIANT).getHardness();
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        return world.getBlockState(pos).getValue(COMPOSITE_VARIANT).getResistance();
    }

    @SideOnly(Side.CLIENT)
    public void initClient() {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(this), stack -> {
            int meta = stack.getItemDamage();

            EnumCompositeType composite = EnumCompositeType.values()[meta];
            BlockRendererDispatcher dispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            Map<IBlockState, ModelResourceLocation> variants = dispatcher.getBlockModelShapes().getBlockStateMapper().getVariants(BlockComposite.this);
            return variants.get(BlockComposite.this.getDefaultState().withProperty(COMPOSITE_VARIANT, composite));
        });
    }
}
