package litewolf101.wuffysmagicmayhem.proxy;


import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.client.fx.WMMParticleType;
import litewolf101.wuffysmagicmayhem.init.ModEntities;
import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;
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
        ModEntities.init();
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

    public void spawnParticle(World world, WMMParticleType particle, double x, double y, double z, double velX, double velY, double velZ) {
    }
}
