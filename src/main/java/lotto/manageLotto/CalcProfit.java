package lotto.manageLotto;

import java.util.Map;

public class CalcProfit {
  public static double calcProfit(Map prize, int inputPrice) {
    int totalPrize = (int) prize.get("1등") * 2000000000 + (int) prize.get("2등") * 30000000 + (int) prize.get("3등") * 1500000 + (int) prize.get("4등") * 50000 + (int) prize.get("5등") * 5000;
    double profitRate = (double) totalPrize/ inputPrice * 100;

    return profitRate;
  }
}
