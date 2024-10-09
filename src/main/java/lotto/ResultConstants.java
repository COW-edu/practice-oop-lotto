package lotto;

public enum ResultConstants {
    FIRST(6, false, 2_000_000_000, "1등"),
    SECOND(5, true, 30_000_000, "2등"),
    THIRD(5, false, 1_500_000, "3등"),
    FOURTH(4, false, 50_000, "4등"),
    FIFTH(3, false, 5_000, "5등"),
    NO_MATCH(0, false, 0, "낙첨");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String rank;

    ResultConstants(int matchCount, boolean bonusMatch, int prize, String rank) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.rank = rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getRank() {
        return rank;
    }

    public static ResultConstants valueOf(int matchCount, boolean bonusMatch) {
        for (ResultConstants resultConstants : values()) {
            if (resultConstants.matchCount == matchCount && resultConstants.bonusMatch == bonusMatch) {
                return resultConstants;
            }
        }
        return NO_MATCH;
    }
}
