package model;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
