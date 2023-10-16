package lotto.domain;

public enum Result {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int requiredMatchCount;
    private final int prize;

    Result(int requiredMatchCount, int prize) {
        this.requiredMatchCount = requiredMatchCount;
        this.prize = prize;
    }

    public int getRequiredMatchCount() {
        return requiredMatchCount;
    }

    public int getPrize() {
        return prize;
    }

}
