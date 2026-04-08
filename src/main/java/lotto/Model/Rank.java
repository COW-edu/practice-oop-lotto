package lotto.Model;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    Rank(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() { return matchCount; }
    public int getPrize() { return prize; }
    public boolean isBonusMatch() { return bonusMatch; }

    public static Rank of(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) return SECOND;

        return Arrays.stream(values())
                .filter(rank -> rank != SECOND && rank != MISS)
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}