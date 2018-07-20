package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.objects.items.ItemBase;
import litewolf101.wuffysmagicmayhem.objects.items.ItemBookIndex;
import litewolf101.wuffysmagicmayhem.objects.items.ItemBookSpecial;
import litewolf101.wuffysmagicmayhem.objects.items.RecordBase;
import litewolf101.wuffysmagicmayhem.utils.handlers.WMMSoundHandler;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class ItemsInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item MAGICAL_INSPECTOR = new ItemBase("magical_inspector");
    public static final Item SPEED_UPGRADE = new ItemBase("wmm_speed_upgrade");
    public static final Item POWER_UPGRADE = new ItemBase("wmm_power_upgrade");
    public static final Item RANGE_UPGRADE = new ItemBase("wmm_range_upgrade");
    public static final Item WMMRECORD_1 = new RecordBase("wmm_record_1", WMMSoundHandler.ENTITY_DARKENED_KNIGHT_DEATH);
    public static final Item BOOK_INDEX = new ItemBookIndex("wmm_book_index");
    public static final Item BOOK_SPECIAL = new ItemBookSpecial("wmm_book_special");
}
