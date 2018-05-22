package com.litewolf101.magicmayhem.container;

import com.litewolf101.magicmayhem.init.ModItems;
import com.litewolf101.magicmayhem.tile.TileEntityTotemUpgradeBase;
import com.litewolf101.magicmayhem.util.EnumUpgradeType;
import de.kitsunealex.silverfish.container.ContainerBase;
import de.kitsunealex.silverfish.container.slot.SlotFilterable;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ContainerTotemUpgradeBase extends ContainerBase<TileEntityTotemUpgradeBase> {

    public ContainerTotemUpgradeBase(InventoryPlayer inventoryPlayer, TileEntityTotemUpgradeBase tile) {
        super(inventoryPlayer, tile, 8, 84);
    }

    @Override
    public void addSlots(List<Slot> slots) {
        slots.add(new SlotFilterable(tile, 0, 44, 35, stack -> isUpgrade(stack, EnumUpgradeType.RANGE)));
        slots.add(new SlotFilterable(tile, 1, 62, 35, stack -> isUpgrade(stack, EnumUpgradeType.POWER)));
        slots.add(new SlotFilterable(tile, 2, 80, 35, stack -> isUpgrade(stack, EnumUpgradeType.SPEED)));
        slots.add(new SlotFilterable(tile, 3, 98, 35, stack -> false));
        slots.add(new SlotFilterable(tile, 4, 116, 35, stack -> false));
    }

    private boolean isUpgrade(ItemStack stack, EnumUpgradeType type) {
        return stack.getItem() == ModItems.UPGRADE && stack.getMetadata() == type.ordinal();
    }

}
