package global;

public class Constants {

    public static final int SINGLE_LOTTO_PRICE = 1_000;

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static final int FIRST_PRIZE = 2_000_000_000;
    public static final int SECOND_PRIZE = 30_000_000;
    public static final int THIRD_PRIZE = 1_500_000;
    public static final int FOURTH_PRIZE = 50_000;
    public static final int FIFTH_PRIZE = 5_000;

    public enum WinningRank {
        FIRST(6, false, FIRST_PRIZE),
        SECOND(5, true, SECOND_PRIZE),
        THIRD(5, false, THIRD_PRIZE),
        FOURTH(4, false, FOURTH_PRIZE),
        FIFTH(3, false, FIFTH_PRIZE),
        NONE(0, false, 0);

        private final int matchCount;
        private final boolean bonusRequired;
        private final int prizeMoney;

        WinningRank(int matchCount, boolean bonusRequired, int prizeMoney) {
            this.matchCount = matchCount;
            this.bonusRequired = bonusRequired;
            this.prizeMoney = prizeMoney;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }

        public static WinningRank getRank(int matchCount, boolean bonusMatch) {
            for (WinningRank rank : values()) {
                if (rank.matchCount == matchCount && rank.bonusRequired == bonusMatch) {
                    return rank;
                }
            }
            return NONE;
        }
    }
}
