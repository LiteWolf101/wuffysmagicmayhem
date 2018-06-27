package litewolf101.wuffysmagicmayhem.items;

import litewolf101.wuffysmagicmayhem.handlers.WMMSoundHandler;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 6/19/2018.
 */
public class ItemWWMRecord1 extends ItemRecord{
    public ItemWWMRecord1(String name, SoundEvent record){
        super(name, record);
        setRegistryName(name);
        setUnlocalizedName(name);
    }

    @Nullable
    @SideOnly(Side.CLIENT)
    public static ItemRecord getBySound(SoundEvent soundIn)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public SoundEvent getSound()
    {
        return WMMSoundHandler.WMM_RECORD_WIZARD;
    }
}
