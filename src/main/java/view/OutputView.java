package view;

import model.Rank;
import java.util.List;
import java.util.Map;
import model.LottoResult;

public class OutputView {

    public static void printLottos(int count, List<List<Integer>> lottoNumbers) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

        public static void printWinningStatistics(LottoResult result) {
            System.out.println("\n당첨 통계");
            System.out.println("---");

            Map<Rank, Integer> results = result.getResults();
            System.out.printf("3개 일치 (5,000원) - %d개%n", results.get(Rank.FIFTH));
            System.out.printf("4개 일치 (50,000원) - %d개%n", results.get(Rank.FOURTH));
            System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.get(Rank.THIRD));
            System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.get(Rank.SECOND));
            System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.get(Rank.FIRST));

            System.out.println("총 수익률은 " + result.calculateProfitRate() + "%입니다.");
        }
}
