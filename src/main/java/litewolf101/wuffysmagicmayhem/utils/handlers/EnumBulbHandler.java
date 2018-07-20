package litewolf101.wuffysmagicmayhem.utils.handlers;

import net.minecraft.util.IStringSerializable;

/**
 * Created by LiteWolf101 on 7/7/2018.
 */
public class EnumBulbHandler {
    public static enum EnumType implements IStringSerializable
    {
        NO_BULB(0, "no_bulb"),
        HAS_BULB(1, "has_bulb");

        private static final EnumBulbHandler.EnumType[] META_LOOKUP = new EnumBulbHandler.EnumType[values().length];
        private final int meta;
        private final String name, unlocializedName;

        private EnumType(int meta, String name)
        {
            this(meta, name, name);
        }

        private EnumType(int meta, String name, String unlocializedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocializedName = unlocializedName;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        public int getMeta()
        {
            return this.meta;
        }

        public String getUnlocializedName()
        {
            return this.unlocializedName;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumBulbHandler.EnumType byMetadata(int meta)
        {
            return META_LOOKUP[meta];
        }

        static
        {
            for(EnumBulbHandler.EnumType enumtype : values())
            {
                META_LOOKUP[enumtype.getMeta()] = enumtype;
            }
        }
    }
}
