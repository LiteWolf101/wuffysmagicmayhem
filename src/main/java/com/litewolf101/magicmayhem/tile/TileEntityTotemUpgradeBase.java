package com.litewolf101.magicmayhem.tile;

import de.kitsunealex.silverfish.tile.TileEntityInventoryBase;

public class TileEntityTotemUpgradeBase extends TileEntityInventoryBase {

    public TileEntityTotemUpgradeBase() {
        super(5);
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

}
