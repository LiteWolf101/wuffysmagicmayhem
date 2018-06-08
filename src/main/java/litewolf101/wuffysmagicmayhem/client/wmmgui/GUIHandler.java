package litewolf101.wuffysmagicmayhem.client.wmmgui;

import litewolf101.wuffysmagicmayhem.container.ContainerBlockTotemUpgradeBase;
import litewolf101.wuffysmagicmayhem.init.ModItems;
import litewolf101.wuffysmagicmayhem.items.ItemBookIndex;
import litewolf101.wuffysmagicmayhem.items.ItemBookSpecial;
import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 5/15/2018.
 */
public class GUIHandler implements IGuiHandler {
    public static final int BLOCK_TOTEM_UPGRADE_BASE = 0;
    public static final int ITEM_BOOK_SPECIAL = 1;
    public static final int ITEM_BOOK_INDEX = 2;

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        ItemStack stack = player.getHeldItemMainhand();
        if (ID == BLOCK_TOTEM_UPGRADE_BASE)
            return new GUIBlockTotemUpgradeBase(player.inventory, (TileEntityBlockTotemUpgradeBase) world.getTileEntity(new BlockPos(x, y, z)));

        if (ID == ITEM_BOOK_SPECIAL)
            if (stack.getItem() instanceof ItemBookSpecial)
                return new GUIItemBookSpecial();

        if (ID == ITEM_BOOK_INDEX)
            if (stack.getItem() instanceof ItemBookIndex)
                return new GUIItemBookIndex();

        return null;
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == BLOCK_TOTEM_UPGRADE_BASE){
            return new ContainerBlockTotemUpgradeBase(player.inventory, (TileEntityBlockTotemUpgradeBase) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }
}
