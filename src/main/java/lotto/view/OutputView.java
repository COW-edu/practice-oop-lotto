package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final DecimalFormat RATE_FORMAT = new DecimalFormat("#,##0.0");

    private OutputView() {
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printStatistics(LottoStatistics statistics, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.winningRanks()) {
            System.out.println(formatRankLine(rank, statistics.getCount(rank)));
        }
        System.out.println("총 수익률은 " + RATE_FORMAT.format(profitRate) + "%입니다.");
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    private static String formatRankLine(Rank rank, int count) {
        String prize = String.format("%,d", rank.getPrize());
        return rank.getDescription() + " (" + prize + "원) - " + count + "개";
    }
}
