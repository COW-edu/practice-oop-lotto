package Entity;

public enum Prize {
    FIRSTPRIZE(6, false, 2_000_000_000),
    SECONDPRIZE(5, true, 30_000_000),
    THIRDPRIZE(5, false, 1_500_000),
    FOURTHPRIZE(4, false, 50_000),
    FIFTHPRIZE(3, false, 5_000),
    NOPRIZE(0, false, 0);

    public static final int WIN_FIFTH_PRIZE = 3;
    public static final int WIN_FOURTH_PRIZE = 4;
    public static final int WIN_THIRD_PRIZE = 5;
    public static final int WIN_SECOND_PRIZE = 7;
    public static final int WIN_FIRST_PRIZE = 6;

    private final int matchCount;
    private final boolean bonusNumMatch;
    private final int prizeMoney;
    private int winnersCount;

    Prize(int matchCount, boolean bonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.bonusNumMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNumMatch() {
        return bonusNumMatch;
    }

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
        return NOPRIZE;
    }
}