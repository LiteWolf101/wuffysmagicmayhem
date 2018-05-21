package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

/**
 * Created by LiteWolf101 on 11/17/2017.
 */
public class DarkInfusedLeaves extends Block {
    public DarkInfusedLeaves(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setSoundType(SoundType.PLANT);
    }
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
