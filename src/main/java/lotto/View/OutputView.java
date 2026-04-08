package lotto.View;

import lotto.Model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Rank, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        List<Rank> printOrder = List.of(
                Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST
        );
        for (Rank rank : printOrder) {
            int count = result.getOrDefault(rank, 0);
            System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                    rank.getMatchCount(),
                    rank.isBonusMatch() ? ", 보너스 볼 일치" : "",
                    rank.getPrize(),
                    count
            );
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}