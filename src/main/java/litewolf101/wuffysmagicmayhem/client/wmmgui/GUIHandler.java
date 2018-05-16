package litewolf101.wuffysmagicmayhem.client.wmmgui;

import litewolf101.wuffysmagicmayhem.container.ContainerBlockTotemUpgradeBase;
import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * Created by Ethan Migit on 5/15/2018.
 */
public class GUIHandler implements IGuiHandler {
    public  static final int BLOCK_TOTEM_UPGRADE_BASE = 0;

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == BLOCK_TOTEM_UPGRADE_BASE)
            return new GUIBlockTotemUpgradeBase(player.inventory, (TileEntityBlockTotemUpgradeBase) world.getTileEntity(new BlockPos(x, y, z)));
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
