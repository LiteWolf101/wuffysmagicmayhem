package litewolf101.wuffysmagicmayhem.items;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.client.wmmgui.GUIHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by LiteWolf101 on 6/8/2018.
 */
public class ItemBookSpecial extends Item {
    public ItemBookSpecial(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.openGui(WuffysMagicMayhem.instance, GUIHandler.ITEM_BOOK_SPECIAL, world, 0, 0, 0);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.AQUA + "This book is filled with a cool story about how this mod was created! Wow!");
    }
}
