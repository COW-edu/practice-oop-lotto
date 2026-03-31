package kr.abins.lotto.model;

public class LottoRecipe {
    private final Lotto lotto;
    private final LottoPrize prize;

    public LottoRecipe(final Lotto lotto, final LottoPrize prize) {
        this.lotto = lotto;
        this.prize = prize;
    }

    public Lotto lotto() {
        return lotto;
    }

    public LottoPrize prize() {
        return prize;
    }
}
