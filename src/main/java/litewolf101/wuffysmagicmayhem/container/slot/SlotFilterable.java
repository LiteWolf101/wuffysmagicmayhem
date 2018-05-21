package litewolf101.wuffysmagicmayhem.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

/**
 * Created by Ethan Migit on 5/16/2018.
 */
public class SlotFilterable extends Slot {
    private Predicate<ItemStack> filter;

    public SlotFilterable(IInventory inventoryIn, int index, int xPosition, int yPosition, Predicate<ItemStack> filter) {
        super(inventoryIn, index, xPosition, yPosition);
        this.filter = filter;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return filter.test(stack);
    }
}
