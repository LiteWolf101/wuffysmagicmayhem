package litewolf101.wuffysmagicmayhem.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

import java.util.Arrays;

/**
 * Created by LiteWolf101 on 5/16/2018.
 */
public class TileEntityInventoryBase extends TileEntityBase implements IInventory{
    private ItemStack[] inventory;

    public TileEntityInventoryBase(int size) {
        inventory = new ItemStack[size];
        Arrays.fill(inventory, ItemStack.EMPTY);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        UtilsInventory.readItemStacksFromTag(inventory, compound.getTagList("inventory", Constants.NBT.TAG_COMPOUND));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("inventory", UtilsInventory.writeItemStacksToTag(inventory, 64));
        return compound;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return UtilsInventory.decrStackSize(this, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return UtilsInventory.removeStackFromSlot(this, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory[index] = stack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < inventory.length; i++){
            setInventorySlotContents(i, ItemStack.EMPTY);
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }
}
