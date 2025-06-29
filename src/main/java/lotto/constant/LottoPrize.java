package lotto.constant;

public enum LottoPrize {
    MATCH_3(3, false, 5000),
    MATCH_4(4, false, 50000),
    MATCH_5(5, false, 1500000),
    MATCH_5_BONUS(5, true, 30000000),
    MATCH_6(6, false, 2000000000);

    private final Integer matchedCount;
    private final Boolean isBonusMatched;
    private final Integer prizeAmount;

    LottoPrize(Integer matchedCount, Boolean isBonusMatched, Integer prizeAmount) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeAmount = prizeAmount;
    }

    public boolean isWinning(int matchedCount, boolean hasBonusMatched) {
        return this.matchedCount == matchedCount && this.isBonusMatched == hasBonusMatched;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoPrize getRank(int matchCount, boolean hasBonusMatched) {
        for (LottoPrize rankValue : values()) {
            if (rankValue.isWinning(matchCount, hasBonusMatched)) {
                return rankValue;
            }
        }
        return null;
    }
}