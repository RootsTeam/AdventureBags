package sirshadow.adventurebags.common.items.bags;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import sirshadow.adventurebags.client.EnumIDs;
import sirshadow.adventurebags.common.utils.Util;
import sirshadow.adventurebags.common.utils.handler.ConfigurationHandler;
import sirshadow.adventurebags.lib.ModLibrary;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class itemEnderBag extends ItemBag {

    public itemEnderBag() {
        super(ModLibrary.LibNames.ender_bag);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        if (!worldIn.isRemote) {
            if (!ConfigurationHandler.dimension_Lock) {
                Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BAG, false);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
            } else {
                if (playerIn.dimension == DimensionType.OVERWORLD.getId()) {
                    Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BAG, false);
                    return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
                } else {
                    return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, itemStackIn);
    }
}
