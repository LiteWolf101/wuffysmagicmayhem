package litewolf101.wuffysmagicmayhem.utils.container;

import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import litewolf101.wuffysmagicmayhem.utils.container.slot.SlotFilterable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by LiteWolf101 on 5/15/2018.
 */
public class ContainerBlockTotemUpgradeBase extends Container {
    private TileEntityBlockTotemUpgradeBase te;

    public ContainerBlockTotemUpgradeBase(IInventory playerInv, TileEntityBlockTotemUpgradeBase te) {
        this.te = te;
        //Container Slots
        this.addSlotToContainer(new SlotFilterable(te, 0, 44, 35, stack -> stack.getItem() == ItemsInit.RANGE_UPGRADE));
        this.addSlotToContainer(new SlotFilterable(te, 1, 62, 35, stack -> stack.getItem() == ItemsInit.POWER_UPGRADE));
        this.addSlotToContainer(new SlotFilterable(te, 2, 80, 35, stack -> stack.getItem() == ItemsInit.SPEED_UPGRADE));
        this.addSlotToContainer(new SlotFilterable(te, 3, 98, 35, stack -> stack.getItem() == Item.getItemFromBlock(Blocks.AIR)));
        this.addSlotToContainer(new SlotFilterable(te, 4, 116, 35, stack -> stack.getItem() == Item.getItemFromBlock(Blocks.AIR)));

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
    public boolean canInteractWith(EntityPlayer player) {
        return te.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
            int inventorySize = te.getSizeInventory();

            if (fromSlot < inventorySize) {
                // From container inventory to player's inventory
                if (!this.mergeItemStack(current, inventorySize, inventorySize + 36, true))
                    return ItemStack.EMPTY;
            } else {
                // From the player's inventory to container
                if(current.getItem() == ItemsInit.RANGE_UPGRADE) {
                    if(!this.mergeItemStack(current, 0, inventorySize, false))
                        return ItemStack.EMPTY;
                }
                if (!this.mergeItemStack(current, 0, inventorySize, false))
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
