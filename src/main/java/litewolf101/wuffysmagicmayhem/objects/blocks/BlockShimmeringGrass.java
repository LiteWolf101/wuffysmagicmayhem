package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.client.fx.WMMParticleType;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by LiteWolf101 on 6/27/2018.
 */
public class BlockShimmeringGrass extends BlockBush implements IHasModel{
    public BlockShimmeringGrass(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
        this.setLightLevel(1F);
        setTickRandomly(true);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    @Override
    public int tickRate(World worldIn) {
        return 5;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        world.scheduleUpdate(pos, this, 5);
        randomDisplayTick(state, world, pos, rand);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 5);
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        Random random = new Random();
        double randomX = random.nextInt(50);
        double randomY = random.nextInt(3);
        double randomZ = random.nextInt(50);
        if (!world.isDaytime()) {
            WuffysMagicMayhem.proxy.spawnParticle(world, WMMParticleType.SHIMMERING_GRASS, d0 + (randomX / 5) - 5, d1 + randomY, d2 + (randomZ / 5) - 5, 0.0D, 0.1D, 0.0D);
        }
    }

    @Override
    public void registerModels() {
        WuffysMagicMayhem.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
