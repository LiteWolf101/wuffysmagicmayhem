package litewolf101.wuffysmagicmayhem.objects.blocks.item;

import litewolf101.wuffysmagicmayhem.utils.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class ItemBlockVariants extends ItemBlock{
    public ItemBlockVariants(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "_" + ((IMetaName)this.block).getSpecialName(stack);
    }
}
