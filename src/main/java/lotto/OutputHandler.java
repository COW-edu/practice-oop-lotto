package lotto;

import java.util.List;
import java.util.Map;

public class OutputHandler {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void print(Object message) {
        System.out.println(message);
    }

    public void printStatistics(Map<ResultConstants, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("-----------------------------------------");

        resultMap.forEach((rank, count) -> {
            if (count > 0) {
                System.out.printf("%s (%d원) - %d개%n", rank.getRank(), rank.getPrize(), count);
            }
        });
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
