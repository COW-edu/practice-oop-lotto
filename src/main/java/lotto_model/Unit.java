package lotto_model;

public enum Unit {
    UNIT_MONEY(1000),
    PERCENT_UNIT(100),
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    UNIT_LOTTO_NUMBER(6);

    private final int value;

    Unit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
