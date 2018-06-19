package sirshadow.adventurebags.common.items;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.registry.RegistryManager;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class ItemBase extends Item implements IItemVariantHolder<ItemBase>
    {
        private final String BASE_NAME;
        private final String[] VARIANTS;

public ItemBase(String name, String ... variants) {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(AdventureBags.tabAdventure);
        setMaxStackSize(1);
        setNoRepair();

        BASE_NAME = name;
        if (variants.length == 0) {
            VARIANTS = new String[] { "normal" };
        }
        else {
            VARIANTS = variants;
        }

        RegistryManager.ITEMS.add(this);
    }

        @Override
        public String getUnlocalizedName(ItemStack itemStack) {

        if (hasSubtypes && itemStack.getMetadata() < VARIANTS.length) {
            return String.format("%s", VARIANTS[itemStack.getMetadata()]);
        }
        return super.getUnlocalizedName(itemStack);
    }

        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> list) {

        if (!getHasSubtypes()) {
            super.getSubItems(creativeTab, list);
        }
        else {
            for (int meta = 0; meta < VARIANTS.length; ++meta) {
                list.add(new ItemStack(this, 1, meta));
            }
        }
    }

        @SideOnly(Side.CLIENT)
        public void initModelsAndVariants() {
        if (getCustomMeshDefinition() != null) {

            ModelLoader.setCustomMeshDefinition(this, getCustomMeshDefinition());
            for (int i = 0; i < VARIANTS.length; i++) {
                ModelBakery.registerItemVariants(this, getCustomModelResourceLocation(VARIANTS[i]));
            }
        }
        else {
            if (!getHasSubtypes()) {
                ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
            }
            else {
                for (int i = 0; i < VARIANTS.length; i++) {
                    ModelLoader.setCustomModelResourceLocation(this, i, getCustomModelResourceLocation(VARIANTS[i]));
                }
            }
        }
    }

        @Override
        public ItemBase getItem() {
        return this;
    }



        @Override
        public String[] getVariants() {
        return VARIANTS;
    }

        @Override
        public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    protected ModelResourceLocation getCustomModelResourceLocation(String variant) {
        return new ModelResourceLocation(variant);
    }
}
