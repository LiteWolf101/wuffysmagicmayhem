package litewolf101.wuffysmagicmayhem.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import javax.annotation.Nonnull;

/**
 * Created by LiteWolf101 on 5/16/2018.
 */
//Ripped from CCL, all credit goes to chicken_bones & covers1624
//Original source: https://github.com/TheCBProject/CodeChickenLib
public class UtilsInventory {
    @Nonnull
    public static ItemStack decrStackSize(IInventory inv, int slot, int size) {
        ItemStack item = inv.getStackInSlot(slot);

        if (!item.isEmpty()) {
            if (item.getCount() <= size) {
                inv.setInventorySlotContents(slot, ItemStack.EMPTY);
                inv.markDirty();
                return item;
            }
            ItemStack itemstack1 = item.splitStack(size);
            if (item.getCount() == 0) {
                inv.setInventorySlotContents(slot, ItemStack.EMPTY);
            } else {
                inv.setInventorySlotContents(slot, item);
            }

            inv.markDirty();
            return itemstack1;
        }
        return ItemStack.EMPTY;
    }

    public static ItemStack removeStackFromSlot(IInventory inv, int slot) {
        ItemStack stack = inv.getStackInSlot(slot);
        inv.setInventorySlotContents(slot, ItemStack.EMPTY);
        return stack;
    }

    public static NBTTagList writeItemStacksToTag(ItemStack[] items, int maxQuantity) {
        NBTTagList tagList = new NBTTagList();
        for (int i = 0; i < items.length; i++) {
            NBTTagCompound tag = new NBTTagCompound();
            tag.setShort("Slot", (short) i);
            items[i].writeToNBT(tag);

            if (maxQuantity > Short.MAX_VALUE) {
                tag.setInteger("Quantity", items[i].getCount());
            } else if (maxQuantity > Byte.MAX_VALUE) {
                tag.setShort("Quantity", (short) items[i].getCount());
            }

            tagList.appendTag(tag);
        }
        return tagList;
    }

    public static void readItemStacksFromTag(ItemStack[] items, NBTTagList tagList) {
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            int b = tag.getShort("Slot");
            items[b] = new ItemStack(tag);
            if (tag.hasKey("Quantity")) {
                items[b].setCount(((NBTPrimitive) tag.getTag("Quantity")).getInt());
            }
        }
    }
}
