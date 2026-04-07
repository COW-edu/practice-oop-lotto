package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoResult result, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoRank, Integer> stats = result.getStats();
        long totalPrize = 0;

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue;
            int count = stats.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + count + "개");
            totalPrize += (long) rank.getPrize() * count;
        }

        printProfitRate(totalPrize, money);
    }

    private void printProfitRate(long totalPrize, int money) {
        double profitRate = ((double) totalPrize / money) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}