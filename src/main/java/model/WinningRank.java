package model;

public enum WinningRank {
    THREE(3, false, 5_000, "3개 일치 (5,000원)"),
    FOUR(4, false, 50_000, "4개 일치 (50,000원)"),
    FIVE(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private final String description;

    WinningRank(int matchCount, boolean bonusMatch, int prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static WinningRank of(int matchCount, boolean bonusMatch) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return null;
    }
}
