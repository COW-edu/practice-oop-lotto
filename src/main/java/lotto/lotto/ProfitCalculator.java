package lotto.lotto;

import java.util.Map;

public class ProfitCalculator {

  public static double calcProfit(Map prizeRanking, int inputPrice) {
    int totalPrize = (int) prizeRanking.get("1등") * 2000000000 + (int) prizeRanking.get("2등") * 30000000 + (int) prizeRanking.get("3등") * 1500000 + (int) prizeRanking.get("4등") * 50000 + (int) prizeRanking.get("5등") * 5000;

    double profitRate = (double) totalPrize/ inputPrice * 100;

    return profitRate;
  }

}
