package lotto_model;

public enum LottoRank {
    FIRST(1000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int lottoPrize;

    LottoRank(int lottoPrize) {
        this.lottoPrize = lottoPrize;
    }

    public int getLottoPrize() {
        return lottoPrize;
    }
}
