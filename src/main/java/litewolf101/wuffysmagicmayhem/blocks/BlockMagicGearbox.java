package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by LiteWolf101 on 5/22/2018.
 */
public class BlockMagicGearbox extends Block {
    public BlockMagicGearbox(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
        blockResistance = 7000;
        blockHardness = 1;
    }
    //TODO Needs facing rotation (X, Z, -X, -Z)
}
