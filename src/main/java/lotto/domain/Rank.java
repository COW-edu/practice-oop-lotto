package lotto.domain;

import java.util.List;

public enum Rank {
    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    MISS(0, false, 0, "");

    private final int matchCount;
    private final boolean bonusMatched;
    private final int prize;
    private final String description;

    Rank(int matchCount, boolean bonusMatched, int prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
        this.description = description;
    }

    public static Rank of(int matchCount, boolean bonusMatched) {
        for (Rank rank : matchRanks()) {
            if (rank.matches(matchCount, bonusMatched)) {
                return rank;
            }
        }
        return MISS;
    }

    private boolean matches(int matchCount, boolean bonusMatched) {
        if (this.matchCount != matchCount) {
            return false;
        }
        if (this.matchCount != THIRD.matchCount) {
            return true;
        }
        return this.bonusMatched == bonusMatched;
    }

    private static List<Rank> matchRanks() {
        return List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);
    }

    public static List<Rank> winningRanks() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
