package litewolf101.wuffysmagicmayhem.tileentity;

/**
 * Created by LiteWolf101 on 5/15/2018.
 */
public class TileEntityBlockTotemUpgradeBase extends TileEntityInventoryBase {

    public TileEntityBlockTotemUpgradeBase(){
        super(5);
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }
}