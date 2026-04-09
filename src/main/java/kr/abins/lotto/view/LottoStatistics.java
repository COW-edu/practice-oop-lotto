package kr.abins.lotto.view;

import kr.abins.lotto.model.LottoPrize;
import kr.abins.lotto.model.LottoResult;

public class LottoStatistics {

    public void print(final LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printLottoPrizes(result);
        printProfitRate(result);
    }

    private void printLottoPrizes(final LottoResult result) {
        final String results = String.format(
            "3개 일치 (%s) - %d개\n" +
            "4개 일치 (%s) - %d개\n" +
            "5개 일치 (%s) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (%s) - %d개\n" +
            "6개 일치 (%s) - %d개",
            money(LottoPrize.PRIZE_5TH), result.count(LottoPrize.PRIZE_5TH),
            money(LottoPrize.PRIZE_4TH), result.count(LottoPrize.PRIZE_4TH),
            money(LottoPrize.PRIZE_3RD), result.count(LottoPrize.PRIZE_3RD),
            money(LottoPrize.PRIZE_2ND), result.count(LottoPrize.PRIZE_2ND),
            money(LottoPrize.PRIZE_1ST), result.count(LottoPrize.PRIZE_1ST)
        );
        System.out.println(results);
    }

    private void printProfitRate(final LottoResult result) {
        double profitRatePercent = result.profitRate();
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", profitRatePercent);
    }

    private String money(final LottoPrize prize) {
        final long money = prize.prizeMoney();
        return String.format("%,d원", money);
    }
}
