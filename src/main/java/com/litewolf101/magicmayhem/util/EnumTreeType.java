package com.litewolf101.magicmayhem.util;

import net.minecraft.block.state.IBlockState;

public enum EnumTreeType {

    ASHENED("ashened", null, null),
    DARK_INFUSED("dark_infused", null, null),
    ENCHANTED("enchanted", null, null),
    STARLIGHT("starlight", null, null);

    private String name;
    private IBlockState leavesState;
    private IBlockState logState;

    EnumTreeType(String name, IBlockState leavesState, IBlockState logState) {
        this.name = name;
        this.leavesState = leavesState;
        this.logState = logState;
    }

    public String getName() {
        return name;
    }

    public IBlockState getLeavesState() {
        return leavesState;
    }

    public IBlockState getLogState() {
        return logState;
    }

}
