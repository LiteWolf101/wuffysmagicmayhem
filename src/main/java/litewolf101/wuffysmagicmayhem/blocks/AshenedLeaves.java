package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

/**
 * Created by Ethan Migit on 11/19/2017.
 */
public class AshenedLeaves extends Block {

    public AshenedLeaves(String name,Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
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

    /**Needs a particle inside the block.*/
}
