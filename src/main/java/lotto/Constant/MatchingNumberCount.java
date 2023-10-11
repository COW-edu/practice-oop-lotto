package lotto.Constant;

public enum MatchingNumberCount {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(7, 30000000),
    SIX(6, 2000000000);

    private final int matchingNumber;
    private final int winningPrice;
    private int count;

    MatchingNumberCount(int matchingNumber, int winningPrice) {
        this.matchingNumber = matchingNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getWinningPrices(int matchingNumberCount) {
        return matchingNumberCount * winningPrice;
    }
}
