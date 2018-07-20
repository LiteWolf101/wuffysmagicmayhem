package litewolf101.wuffysmagicmayhem.objects.items;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import net.minecraft.item.Item;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

        ItemsInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        WuffysMagicMayhem.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
