package org.icannt.materialfoundation.common.block.blocks;

import java.util.List;
import java.util.Map;

import org.icannt.materialfoundation.common.block.BlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeWallPlasterType;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ICannt on 14/02/17.
 */
public class BlockCompositeWallPlaster extends BlockVariantBase {

    private static final PropertyEnum<EnumCompositeWallPlasterType> VARIANT = PropertyEnum.create("composite", EnumCompositeWallPlasterType.class);

    public BlockCompositeWallPlaster() {
        super(Material.ROCK, MapColor.GRAY, "composite_wall_plaster");
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (EnumCompositeWallPlasterType type : EnumCompositeWallPlasterType.values()) {
            list.add(new ItemStack(this, 1, type.ordinal()));
        }
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(VARIANT, EnumCompositeWallPlasterType.values()[meta]);
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
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return blockState.getValue(VARIANT).getHardness();
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        return world.getBlockState(pos).getValue(VARIANT).getResistance() / 5F;
    }

    @SideOnly(Side.CLIENT)
    public void initClient() {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(this), stack -> {
            int meta = stack.getMetadata();

            EnumCompositeWallPlasterType composite = EnumCompositeWallPlasterType.values()[meta];
            BlockRendererDispatcher dispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            Map<IBlockState, ModelResourceLocation> variants = dispatcher.getBlockModelShapes().getBlockStateMapper().getVariants(BlockCompositeWallPlaster.this);
            return variants.get(BlockCompositeWallPlaster.this.getDefaultState().withProperty(VARIANT, composite));
        });
    }
}