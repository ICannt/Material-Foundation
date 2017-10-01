package org.icannt.materialfoundation.common.item.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import org.icannt.materialfoundation.MaterialFoundation;
import org.icannt.materialfoundation.client.creativetab.TabMaterialFoundation;
import org.icannt.materialfoundation.client.model.ItemPaintTinMesher;
import org.icannt.materialfoundation.common.item.metadata.EnumPaintType;
import org.icannt.materialfoundation.common.registry.ItemRegistry;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by ICannt on 01/10/17.
 */
public class ItemMetalTinPaint extends Item {

    public ItemMetalTinPaint() {
        setRegistryName(MaterialFoundation.MOD_ID, "metal_tin_paint");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(1);
        setMaxDamage(80);
        setNoRepair();
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public boolean getHasSubtypes() {
        return true;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (ItemMetalTinPaint.getVariant(stack).isPresent()) {
            return super.getUnlocalizedName() + "." + ItemMetalTinPaint.getVariant(stack).get().getName();
        } else {
            return super.getUnlocalizedName();
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (ItemMetalTinPaint.getVariant(stack).isPresent())
            tooltip.add(ItemMetalTinPaint.getVariant(stack).get().getLocalisedName());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (EnumPaintType type : EnumPaintType.values()) {
            items.add(ItemMetalTinPaint.create(type));
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
    	return true;
    }
    
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack container = stack.copy();

        if (container.getItemDamage() < getMaxDamage(container) - 1) {
            container.attemptDamageItem(1, itemRand, null);
            return container;
        } else {
        	return new ItemStack(ItemRegistry.METAL_TIN_PAINT_EMPTY);
        }
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    /**
     * Helper method for determining if a paint tin is a certain color
     * @param stack ItemStack of ItemMetalTinPaint to check
     * @param paint EnumPaintType of which color to look for
     * @return Boolean true if matches, or false
     */
    public static boolean isColour(ItemStack stack, EnumPaintType paint) {
        if (stack.getItem() != ItemRegistry.METAL_TIN_PAINT)
            return false;

        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().hasKey("color")) {
                return stack.getTagCompound().getString("color").equalsIgnoreCase(paint.getName());
            }
        }

        return false;
    }

    /**
     * Helper method for passing an ItemStack of ItemMetalTinPaint and returning the appropriate variant based on NBT
     * @param stack ItemStack of ItemMetalTinPaint
     * @return Optional<EnumPaintType> Enum containing the variant
     */
    public static Optional<EnumPaintType> getVariant(ItemStack stack) {
    	EnumPaintType result = null;
    	
        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().hasKey("color")) {
                String color = stack.getTagCompound().getString("color");
                for (EnumPaintType paint : EnumPaintType.values()) {
                    if (paint.getName().equalsIgnoreCase(color))
                        result = paint;
                }
            }
        }

        return Optional.ofNullable(result);
    }

    /**
     * Helper method for creating an ItemStack with the appropriate variant NBT tags
     * @param paint EnumPaintType The EnumPaintType variant to create
     * @param wildcard Boolean A flag whether to set the stack's damage to OreDictionary.WILDCARD_VALUE
     * @return ItemStack of variant
     */
    public static ItemStack create(EnumPaintType paint, boolean wildcard) {
        ItemStack out = new ItemStack(ItemRegistry.METAL_TIN_PAINT);
        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("color", paint.getName());
        out.setTagCompound(tag);

        if (wildcard)
            out.setItemDamage(OreDictionary.WILDCARD_VALUE);

        return out;
    }

    public static ItemStack create(EnumPaintType paint) {
        return create(paint, false);
    }
    
    @SideOnly(Side.CLIENT)
    public void initItemModels() {
    	
        List<ModelResourceLocation> modelsPaint = new ArrayList<>();
        
        for (EnumPaintType variant : EnumPaintType.values()) {
            modelsPaint.add(new ModelResourceLocation(this.getRegistryName() + "_" + variant.getName(), "inventory"));
        }
        
        ModelBakery.registerItemVariants(this, modelsPaint.toArray(new ModelResourceLocation[modelsPaint.size()]));
        ModelLoader.setCustomMeshDefinition(this, new ItemPaintTinMesher());
    }
    
}
