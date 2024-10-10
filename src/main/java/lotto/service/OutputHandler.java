package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.ResultConstants;
import java.util.List;
import java.util.Map;
import static lotto.utils.OutputConstants.*;

public class OutputHandler {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + BoughtCount_PROMPT);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void print(Object message) {
        System.out.println(message);
    }

    public void printStatistics(Map<ResultConstants, Integer> resultMap) {
        System.out.println(STATISTIC_PROMPT);
        System.out.println(PARSING);

        resultMap.forEach((rank, count) -> {
            if (count > ZERO) {
                System.out.printf(RESULTCOUNT, rank.getRank(), rank.getPrize(), count);
            }
        });
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFITRATE, profitRate);
    }
}
