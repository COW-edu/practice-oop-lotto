package global.enums;

public enum MagicNumber {
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_LENGTH(6),
    THREE_MATCH_PRIZE(5000),
    FOUR_MATCH_PRIZE(50000),
    FIVE_MATCH_PRIZE(1500000),
    FIVE_BONUS_MATCH_PRIZE(30000000),
    SIX_MATCH_PRIZE(2000000000);

    private final int value;

    MagicNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
