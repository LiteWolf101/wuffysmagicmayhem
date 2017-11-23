package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Created by Ethan Migit on 11/18/2017.
 */
public class StarlightPlanks extends Block {
    public StarlightPlanks(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.WOOD);
    }
}