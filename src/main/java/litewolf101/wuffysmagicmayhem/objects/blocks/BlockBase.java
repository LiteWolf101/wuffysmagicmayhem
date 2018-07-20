package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class BlockBase extends Block implements IHasModel{
    public BlockBase(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        WuffysMagicMayhem.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
