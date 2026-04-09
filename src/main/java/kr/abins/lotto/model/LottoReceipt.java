package kr.abins.lotto.model;

// record class 쓰고싶어요 ㅠ.ㅠ
public class LottoReceipt {

    private final Lotto lotto;
    private final LottoPrize prize;

    public LottoReceipt(final Lotto lotto, final LottoPrize prize) {
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
