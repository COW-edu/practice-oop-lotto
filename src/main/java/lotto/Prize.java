package lotto;

public enum Prize {
    FirstPrize(6, false, 2000000000),
    SecondPrize(5, true, 30000000),
    ThirdPrize(5, false, 1500000),
    FourthPrize(4, false, 50000),
    FifthPrize(3, false, 5000),
    NoPrize(0, false, 0);

    private final int matchCount;
    private final boolean bonusNumMatch;
    private final int prizeMoney;
    private int winnersCount;

    Prize(int matchCount, boolean bonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.bonusNumMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
        this.winnersCount = 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNumMatch() {return bonusNumMatch;}

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getWinnersCount() {
        return winnersCount;
    }

    public void increaseCount() {
        winnersCount++;
    }

    public static Prize calculatePrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.bonusNumMatch == bonusMatch) {
                return prize;
            }
        }
        return NoPrize;
    }
}
