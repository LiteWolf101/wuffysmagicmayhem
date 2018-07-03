package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by LiteWolf101 on 7/3/2018.
 */
public class BlockDarkInfusedDirt extends Block{
    public BlockDarkInfusedDirt(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setTickRandomly(true);
        setSoundType(SoundType.GROUND);
    }
}
