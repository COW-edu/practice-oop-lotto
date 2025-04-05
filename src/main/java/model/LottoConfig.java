package model;

public enum LottoConfig {
    LOTTO_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
