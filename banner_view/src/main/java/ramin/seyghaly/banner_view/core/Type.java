package ramin.seyghaly.banner_view.core;

public enum Type {

    NONE("None"),
    BANNER("Banner");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Type getVal(String val) {
        for (Type ac : values()) {
            if (ac.value == val) return ac;
        }
        return NONE;
    }

}
