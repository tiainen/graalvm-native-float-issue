public class Simple {

    private final boolean aBoolean;
    private final char aChar;
    private final byte aByte;
    private final int anInt;
    private final long aLong;
    private final double aDouble;
    private final float aFloat;
    private final short aShort;

    public Simple(boolean aBoolean, char aChar, byte aByte, int anInt, long aLong, double aDouble, float aFloat, short aShort) {
        this.aBoolean = aBoolean;
        this.aChar = aChar;
        this.aByte = aByte;
        this.anInt = anInt;
        this.aLong = aLong;
        this.aDouble = aDouble;
        this.aFloat = aFloat;
        this.aShort = aShort;
    }

    @Override
    public String toString() {
        return "Simple:" +
            "\n\taBoolean=" + aBoolean +
            "\n\taChar=" + aChar +
            "\n\taByte=" + aByte +
            "\n\tanInt=" + anInt +
            "\n\taLong=" + aLong +
            "\n\taDouble=" + aDouble +
            "\n\taFloat=" + aFloat +
            "\n\taShort=" + aShort;
    }
}

