package com.litewolf101.magicmayhem.util;

import com.litewolf101.magicmayhem.init.ModBlocks;
import net.minecraft.block.state.IBlockState;

@SuppressWarnings("deprecation")
public enum EnumTreeType {

    ASHENED         ("ashened", ModBlocks.LEAVES.getStateFromMeta(0), ModBlocks.LOG.getStateFromMeta(0), ModBlocks.PLANKS.getStateFromMeta(0)),
    DARK_INFUSED    ("dark_infused", ModBlocks.LEAVES.getStateFromMeta(1), ModBlocks.LOG.getStateFromMeta(5), ModBlocks.PLANKS.getStateFromMeta(1)),
    ENCHANTED       ("enchanted", ModBlocks.LEAVES.getStateFromMeta(2), ModBlocks.LOG.getStateFromMeta(9), ModBlocks.PLANKS.getStateFromMeta(2)),
    STARLIGHT       ("starlight", ModBlocks.LEAVES.getStateFromMeta(3), ModBlocks.LOG.getStateFromMeta(13), ModBlocks.PLANKS.getStateFromMeta(3));

    private String name;
    private IBlockState leavesState;
    private IBlockState logState;
    private IBlockState planksState;

    EnumTreeType(String name, IBlockState leavesState, IBlockState logState, IBlockState planksState) {
        this.name = name;
        this.leavesState = leavesState;
        this.logState = logState;
        this.planksState = planksState;
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

    public IBlockState getPlanksState() {
        return planksState;
    }

}
