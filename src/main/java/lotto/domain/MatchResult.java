package lotto.domain;

public class MatchResult {

    private final int matchCount;
    private final boolean bonusMatch;

    public MatchResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
