package com.litewolf101.magicmayhem.network;

import com.litewolf101.magicmayhem.client.gui.GuiTotemUpgradeBase;
import com.litewolf101.magicmayhem.container.ContainerTotemUpgradeBase;
import com.litewolf101.magicmayhem.tile.TileEntityTotemUpgradeBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    private static final int BASE = 0;
    public static final int TOTEM_UPGRADE_BASE = BASE;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if(tile != null) {
            if(ID == TOTEM_UPGRADE_BASE) {
                return new ContainerTotemUpgradeBase(player.inventory, (TileEntityTotemUpgradeBase)tile);
            }
        }

        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if(tile != null) {
            if(ID == TOTEM_UPGRADE_BASE) {
                return new GuiTotemUpgradeBase(player.inventory, (TileEntityTotemUpgradeBase)tile);
            }
        }

        return null;
    }

}
