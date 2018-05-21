package litewolf101.wuffysmagicmayhem.proxy;


import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by LiteWolf101 on 11/16/2017.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    public void init(FMLInitializationEvent event)
    {
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    }

    public void registerModelBakeryStuff() {
    }

    public void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityBlockTotemUpgradeBase.class, Reference.MODID + ":block_totem_upgrade_base_te");
    }
}
