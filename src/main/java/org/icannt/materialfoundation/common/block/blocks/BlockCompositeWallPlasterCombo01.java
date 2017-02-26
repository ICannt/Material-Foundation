package org.icannt.materialfoundation.common.block.blocks;

import org.icannt.materialfoundation.common.block.BlockVariantBase;
import org.icannt.materialfoundation.common.block.variant.EnumCompositeWallPlasterCombo01Type;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;

/**
 * Created by ICannt on 14/02/17.
 */
public class BlockCompositeWallPlasterCombo01 extends BlockVariantBase {

    private static final PropertyEnum<EnumCompositeWallPlasterCombo01Type> VARIANT = PropertyEnum.create("composite", EnumCompositeWallPlasterCombo01Type.class);
    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockCompositeWallPlasterCombo01() {
        super(Material.ROCK, MapColor.GRAY, "composite_wall_plaster_combo_01");
    }

//    @Override
//    protected BlockStateContainer createBlockState() {
//    	return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING,VARIANT});
//    }
//
//    @Override
//    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
//        for (EnumCompositeWallPlasterCombo01Type type : EnumCompositeWallPlasterCombo01Type.values()) {
//            list.add(new ItemStack(this, 1, type.ordinal()));
//        }
//    }
//      
//    @SuppressWarnings("deprecation")
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//    	EnumFacing facing = EnumFacing.getHorizontal(meta);
//    	System.out.println(facing);
//    	System.out.println(meta);
//        return getDefaultState().withProperty(VARIANT, EnumCompositeWallPlasterCombo01Type.values()[meta]).withProperty(PROPERTYFACING, facing);
//    }
//
//    @Override
//    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
//    {
//      // find the quadrant the player is facing
//    	
//    	System.out.println(meta);
//      EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
//      System.out.println(enumfacing);
//      
//      return this.getDefaultState();
//    }
//    
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return state.getValue(VARIANT).ordinal();
//    }
//    
//    @Override
//    public int damageDropped(IBlockState state) {
//        return getMetaFromState(state);
//    }
//
//    @Override
//    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
//        return state.getValue(VARIANT).getLight();
//    }
//
//    @SuppressWarnings("deprecation")
//    @Override
//    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
//        return blockState.getValue(VARIANT).getHardness();
//    }
//
//    @Override
//    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
//        return world.getBlockState(pos).getValue(VARIANT).getResistance() / 5F;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void initClient() {
//        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(this), stack -> {
//            int meta = stack.getMetadata();
//
//            EnumCompositeWallPlasterCombo01Type composite = EnumCompositeWallPlasterCombo01Type.values()[meta];
//            BlockRendererDispatcher dispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
//            Map<IBlockState, ModelResourceLocation> variants = dispatcher.getBlockModelShapes().getBlockStateMapper().getVariants(BlockCompositeWallPlasterCombo01.this);
//            return variants.get(BlockCompositeWallPlasterCombo01.this.getDefaultState().withProperty(VARIANT, composite));
//        });
//    }
}
