package lotto.lotto;

import java.util.Map;
import lotto.io.InputHandler;

public class ProfitCalculator {

  double profitRate = 0;
  LottoMatchCounter lottoMatchCounter;
  InputHandler inputHandler;

  public ProfitCalculator(LottoMatchCounter lottoMatchCounter, InputHandler inputHandler) {
    this.lottoMatchCounter = lottoMatchCounter;
    this.inputHandler = inputHandler;
    calcProfit(lottoMatchCounter, inputHandler);
  }

  public void calcProfit(LottoMatchCounter lottoMatchCounter, InputHandler inputHandler) {
    Map<Integer, Integer> prizeRanking = lottoMatchCounter.getPrizeRanking();
    int inputPrice = inputHandler.getInputPrice();
    final int FIRST_PLACE = 6;
    final int SECOND_PLACE = 5;
    final int THIRD_PLACE = 4;
    final int FOURTH_PLACE = 3;
    final int FIFTH_PLACE = 2;

    int totalPrize = prizeRanking.get(FIRST_PLACE) * 2000000000 + prizeRanking.get(SECOND_PLACE) * 30000000 + prizeRanking.get(THIRD_PLACE) * 1500000 + prizeRanking.get(FOURTH_PLACE) * 50000 + prizeRanking.get(FIFTH_PLACE) * 5000;

    profitRate = (double) totalPrize/ inputPrice * 100;
  }

  public double getProfitRate() {
    return profitRate;
  }

}
