package litewolf101.wuffysmagicmayhem.objects.items;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.client.wmmgui.GUIHandler;
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
public class ItemBookIndex extends Item implements IHasModel{
    public ItemBookIndex(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

        ItemsInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.openGui(WuffysMagicMayhem.instance, GUIHandler.ITEM_BOOK_INDEX, world, 0, 0, 0);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
        //add advancement: Title:"Do u kno de wey?" Desc: "You know it now."
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.LIGHT_PURPLE + "This book is filled with information about this mod. Cool!");
    }

    @Override
    public void registerModels() {
        WuffysMagicMayhem.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
