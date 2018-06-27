package litewolf101.wuffysmagicmayhem.handlers;

import net.minecraft.util.IStringSerializable;

/**
 * Created by LiteWolf101 on 3/5/2018.
 */
public class EnumHandler {
    public static enum BubbleshroomType implements IStringSerializable {
        GRAY(0, "gray"),
        BLUE(1, "blue"),
        GREEN(2, "green"),
        PINK(3, "pink");


        private int ID;
        private String name;

        private BubbleshroomType(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return ID;
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    public static enum StrangeGrassType implements IStringSerializable {
        BULB(0, "bulb"),
        NO_BULB(1, "no_bulb");


        private int ID;
        private String name;

        private StrangeGrassType(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return ID;
        }

        @Override
        public String toString() {
            return getName();
        }
    }
}
