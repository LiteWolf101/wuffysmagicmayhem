package com.litewolf101.magicmayhem.util;

import codechicken.lib.util.ItemNBTUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.function.Consumer;

public class StackUtils extends de.kitsunealex.silverfish.util.StackUtils {

    //TODO: move this into Silverfish...

    public static ItemStack fromState(IBlockState state) {
        return fromState(state, 1);
    }

    public static ItemStack fromState(IBlockState state, int amount) {
        return fromState(state, amount, null);
    }

    public static ItemStack fromState(IBlockState state, int amount, Consumer<NBTTagCompound> consumer) {
        ItemStack stack = new ItemStack(state.getBlock(), amount, state.getBlock().getMetaFromState(state));

        if(consumer != null) {
            ItemNBTUtils.validateTagExists(stack);
            consumer.accept(stack.getTagCompound());
        }

        return stack;
    }

}
