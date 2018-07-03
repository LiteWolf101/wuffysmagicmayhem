package litewolf101.wuffysmagicmayhem.blocks.enums;

import net.minecraft.util.IStringSerializable;

/**
 * Created by LiteWolf101 on 6/28/2018.
 */
public enum WMMWoodType implements IStringSerializable {
    STARLIGHT(0, "starlight"),
    DARKENED(1, "darkened"),
    ASHENED(2, "ashened"),
    ENCHANTED(3, "enchanted");

    private final int meta;
    private final String name;
    private final String unlocalizedName;
    private static final WMMWoodType[] META_LOOKUP = new WMMWoodType[values().length];

    WMMWoodType(int metaIn, String nameIn)
    {
        this(metaIn, nameIn, nameIn);
    }

    WMMWoodType(int metaIn, String nameIn, String unlocalizedNameIn)
    {
        this.meta = metaIn;
        this.name = nameIn;
        this.unlocalizedName = unlocalizedNameIn;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    public static WMMWoodType byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    static
    {
        for (WMMWoodType woodType : values())
        {
            META_LOOKUP[woodType.getMetadata()] = woodType;
        }
    }
}
