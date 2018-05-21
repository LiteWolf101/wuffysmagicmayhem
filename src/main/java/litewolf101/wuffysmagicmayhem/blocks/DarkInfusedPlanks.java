package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by LiteWolf101 on 11/17/2017.
 */
public class DarkInfusedPlanks extends Block {
    public DarkInfusedPlanks(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setSoundType(SoundType.WOOD);
    }
}
