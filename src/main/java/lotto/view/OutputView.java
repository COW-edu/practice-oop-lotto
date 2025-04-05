package lotto.view;

import lotto.constant.LottoPrize;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printMyLottos(List<Lotto> myLottos) {
        for (Lotto lotto : myLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResults(Map<LottoPrize, Integer> winningResults) {
        System.out.println();
        System.out.println("당첨 통계 \n---");
        System.out.println("3개 일치 (5,000원) - " + winningResults.getOrDefault(LottoPrize.MATCH_3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResults.getOrDefault(LottoPrize.MATCH_4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResults.getOrDefault(LottoPrize.MATCH_5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResults.getOrDefault(LottoPrize.MATCH_5_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResults.getOrDefault(LottoPrize.MATCH_6, 0) + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
