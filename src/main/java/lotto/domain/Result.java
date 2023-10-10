package lotto.domain;

public enum Result {
    FIRST(6, 2000000000, 0),
    SECOND(5, 30000000, 0),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0);

    private final int requiredMatchCount;
    private final int prize;
    private int totalCount;

    Result(int requiredMatchCount, int prize, int totalCount) {
        this.requiredMatchCount = requiredMatchCount;
        this.prize = prize;
        this.totalCount = totalCount;
    }

    public int getRequiredMatchCount() {
        return requiredMatchCount;
    }
    public int getPrize() {
        return prize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void plusTotalCount() {
        totalCount += 1;
    }

}
