package ramin.seyghaly.banner_view.actions;

public enum Action {

    NONE(-1),
    OPEN_BROWSER(0),
    CALL(1),
    SMS(2);

    private int value;

    Action(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Action getVal(int val) {
        for (Action ac : values()) {
            if (ac.value == val) return ac;
        }
        return NONE;
    }

}
