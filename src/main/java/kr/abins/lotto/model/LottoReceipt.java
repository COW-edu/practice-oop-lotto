package kr.abins.lotto.model;

// record class 쓰고싶어요 ㅠ.ㅠ

/**
 * 당첨 번호와 대조(긁기)가 완료된 로또 한 장과 그 결과 등수를 담습니다.
 */
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
