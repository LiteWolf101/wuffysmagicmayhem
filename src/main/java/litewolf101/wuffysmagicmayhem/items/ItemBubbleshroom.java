package litewolf101.wuffysmagicmayhem.items;

import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created by LiteWolf101 on 3/5/2018.
 */
public class ItemBubbleshroom extends Item {
    public ItemBubbleshroom(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        this.hasSubtypes = true;
    }

    public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> items) {
        for (int i = 0; i < EnumHandler.BubbleshroomType.values().length; i++) {
            items.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        for (int i = 0; i < EnumHandler.BubbleshroomType.values().length; i++) {
            if(stack.getItemDamage() == i) {
                return this.getUnlocalizedName() + "." + EnumHandler.BubbleshroomType.values()[i].getName();
            } else continue;
        }
        return this.getUnlocalizedName() + "." + EnumHandler.BubbleshroomType.GRAY.getName();
    }
}
