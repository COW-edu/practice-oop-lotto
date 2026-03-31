package kr.abins.lotto.view;

import kr.abins.lotto.model.LottoPrize;
import kr.abins.lotto.model.LottoResult;

public interface LottoStatistics {

    static void print(final LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

    }


    private static String money(final LottoPrize prize) {
        final long money = prize.prizeMoney();
        return String.format("%,d원", money);
    }
}
