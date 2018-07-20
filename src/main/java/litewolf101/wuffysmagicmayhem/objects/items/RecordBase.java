package litewolf101.wuffysmagicmayhem.objects.items;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.handlers.WMMSoundHandler;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 7/19/2018.
 */
public class RecordBase extends ItemRecord implements IHasModel{
    private final SoundEvent sound;
    public RecordBase(String name, SoundEvent soundIn) {
        super(name, soundIn);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
        this.sound = soundIn;

        ItemsInit.ITEMS.add(this);
    }

    @Nullable
    @SideOnly(Side.CLIENT)
    public static ItemRecord getBySound(SoundEvent soundIn)
    {
        return null;
    }

    @Override
    public void registerModels() {
        WuffysMagicMayhem.proxy.registerItemRenderer(this, 0, "inventory");
    }

    //TODO: Fix
    @SideOnly(Side.CLIENT)
    public SoundEvent getSound()
    {
        return WMMSoundHandler.WMM_RECORD_WIZARD;
    }
}
