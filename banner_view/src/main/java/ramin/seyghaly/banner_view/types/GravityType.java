package ramin.seyghaly.banner_view.types;

public enum GravityType {

    TOP(0),
    CENTER(1),
    BOTTOM(2);

    private int value;

    GravityType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GravityType getVal(int val) {
        for (GravityType ac : values()) {
            if (ac.value == val) return ac;
        }
        return BOTTOM;
    }

}
