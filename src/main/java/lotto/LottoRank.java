package lotto;

public enum LottoRank {
    FIRST(1000000000, 0),
    SECOND(30000000, 0),
    THIRD(1500000, 0),
    FOURTH(50000, 0),
    FIFTH(5000,  0);

    private final int lottoPrize;

    private int quantity;

    LottoRank(int lottoPrize, int quantity) {
        this.lottoPrize = lottoPrize;
        this.quantity = quantity;
    }

    public int getLottoPrize() {
        return lottoPrize;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLottoTotalPrize() {
        return getLottoPrize() * getQuantity();
    }
}
