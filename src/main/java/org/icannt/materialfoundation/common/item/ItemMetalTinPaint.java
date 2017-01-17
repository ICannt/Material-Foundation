package org.icannt.materialfoundation.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ICannt on 26/12/16.
 */
public class ItemMetalTinPaint extends Item {

    public ItemMetalTinPaint() {
        setRegistryName(MaterialFoundation.MOD_ID, "metal_tin_paint");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(1);
        setMaxDamage(80);
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
        return super.getUnlocalizedName() + "." + ItemMetalTinPaint.getVariant(stack).getName();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ItemMetalTinPaint.getVariant(stack).getLocalisedName());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (EnumPaintType type : EnumPaintType.values()) {
            subItems.add(ItemMetalTinPaint.create(type));
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return ItemMetalTinPaint.getVariant(stack) != EnumPaintType.EMPTY;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack container = stack.copy();

        if (container.getItemDamage() < getMaxDamage(container) - 1) {
            container.attemptDamageItem(1, itemRand);
            return container;
        } else {
            return ItemMetalTinPaint.create(EnumPaintType.EMPTY, true);
        }
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    /**
     * Helper method for determining if a paint tin is a certain colour
     * @param stack ItemStack of ItemMetalTinPaint to check
     * @param paint EnumPaintType of which colour to look for
     * @return Boolean true if matches, or false
     */
    public static boolean isColour(ItemStack stack, EnumPaintType paint) {
        if (!stack.getItem().equals(ModItems.TIN_METAL_PAINT))
            return false;

        if (stack.getTagCompound() != null) {
            if (stack.getTagCompound().hasKey("colour")) {
                return stack.getTagCompound().getString("colour").equalsIgnoreCase(paint.getName());
            }
        }

        return false;
    }

    /**
     * Helper method for passing an ItemStack of ItemMetalTinPaint and returning the appropriate variant based on NBT
     * @param stack ItemStack of ItemMetalTinPaint
     * @return EnumPaintType Enum containing the variant
     */
    public static EnumPaintType getVariant(ItemStack stack) {
        if (!stack.getItem().equals(ModItems.TIN_METAL_PAINT))
            return EnumPaintType.EMPTY;

        EnumPaintType result = EnumPaintType.EMPTY;

        if (stack.getTagCompound() != null) {
            if (stack.getTagCompound().hasKey("colour")) {
                String colour = stack.getTagCompound().getString("colour");
                result = Arrays.stream(EnumPaintType.values()).filter(type -> type.getName().equals(colour)).findFirst().get();
            }
        }

        return result;
    }

    /**
     * Helper method for creating an ItemStack with the appropriate variant NBT tags
     * @param paint EnumPaintType The EnumPaintType variant to create
     * @param wildcard Boolean A flag whether to set the stack's damage to OreDictionary.WILDCARD_VALUE
     * @return ItemStack of variant
     */
    public static ItemStack create(EnumPaintType paint, boolean wildcard) {
        ItemStack out = new ItemStack(ModItems.TIN_METAL_PAINT);
        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("colour", paint.getName());
        out.setTagCompound(tag);

        if (wildcard)
            out.setItemDamage(OreDictionary.WILDCARD_VALUE);

        return out;
    }

    public static ItemStack create(EnumPaintType paint) {
        return create(paint, false);
    }
    
}
