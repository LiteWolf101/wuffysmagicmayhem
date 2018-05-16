package litewolf101.wuffysmagicmayhem.container;

import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by Ethan Migit on 5/15/2018.
 */
public class ContainerBlockTotemUpgradeBase extends Container {
    private TileEntityBlockTotemUpgradeBase te;
    private IItemHandler handler;

    public ContainerBlockTotemUpgradeBase(IInventory playerInv, TileEntityBlockTotemUpgradeBase te) {
        this.te = te;
        this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        //Container Slots
        this.addSlotToContainer(new SlotItemHandler(handler, 0, 44, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 62, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 80, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 3, 98, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 4, 116, 35));

        int xPos = 8;
        int yPos = 84;

        //playerInv Slots
        for (int y = 0; y < 3; ++y){
            for (int x = 0; x < 9; ++x){
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
            }
        }

        //PlayerHotbar Slots
        for (int x = 0; x < 9; ++x){
            this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.te.isUseableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < handler.getSlots()) {
                // From container inventory to player's inventory
                if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
                    return ItemStack.EMPTY;
            } else {
                // From the player's inventory to container
                if(current.getItem() == Items.ENCHANTED_BOOK) {
                    if(!this.mergeItemStack(current, 0, handler.getSlots(), false))
                        return ItemStack.EMPTY;
                }
                if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
                    return ItemStack.EMPTY;
            }

            if (current.getCount() == 0)
                slot.putStack(ItemStack.EMPTY);
            else
                slot.onSlotChanged();

            if (current.getCount() == previous.getCount())
                return null;
            slot.onTake(playerIn, current);
        }
        return previous;
    }
}
