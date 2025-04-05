package global.enums;

public enum MagicNumber {
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_LENGTH(6);

    private final int value;

    MagicNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
