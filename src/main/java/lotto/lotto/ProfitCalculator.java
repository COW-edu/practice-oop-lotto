package lotto.lotto;

import java.util.Map;
import java.util.Set;

public class ProfitCalculator {

  public double calcProfit(Map<Integer, Integer> prizeRanking, int inputPrice) {
    final int FIRST_PLACE = 6;
    final int SECOND_PLACE = 5;
    final int THIRD_PLACE = 4;
    final int FOURTH_PLACE = 3;
    final int FIFTH_PLACE = 2;

    int totalPrize = prizeRanking.get(FIRST_PLACE) * 2000000000 + prizeRanking.get(SECOND_PLACE) * 30000000 + prizeRanking.get(THIRD_PLACE) * 1500000 + prizeRanking.get(FOURTH_PLACE) * 50000 + prizeRanking.get(FIFTH_PLACE) * 5000;

    double profitRate = (double) totalPrize/ inputPrice * 100;

    return profitRate;
  }

}
