package model.customer;

import java.util.Map;
import java.util.stream.IntStream;
import model.lotto.Lotto;
import model.lotto.PurchasedLottos;
import model.win.WinLottoCount;

public class CustomerService {

  public long createWinCount(PurchasedLottos purchasedLottos, double winNumber, Lotto winLotto, int bonusNumber) {
    boolean isInteger = (winNumber % 1 == 0);
    return IntStream.range(0, purchasedLottos.getpayLottosSize())
        .filter(index -> {
          double countValue = purchasedLottos.getEqualWinCounts(winLotto).get(index);
          boolean isBonusNumberEqual = purchasedLottos.getEqualBonusNumber(bonusNumber).get(index);
          if (!isInteger && countValue == (int) winNumber && isBonusNumberEqual) {
            return true;
          }
          if (isInteger && countValue == winNumber && isBonusNumberEqual) {
            return false;
          }
          return countValue == winNumber;
        })
        .count();
  }

  public double createProfitRate(Map<String, Integer> winLottoResult, int payMoney) {
    long profit = profitCalculate(winLottoResult);
    double profitRate = ((double) profit / payMoney) * 1000.0;
    return Math.round(profitRate) / 10.0;
  }
  private long profitCalculate(Map<String, Integer> winLottoResult) {
    long profitTemp = 0;
    for (WinLottoCount wincountdata : WinLottoCount.values()) {
      long winningPrice = wincountdata.getLottoWinningPrice();
      long winningCount = winLottoResult.get(wincountdata.getCount());
      profitTemp += winningPrice * winningCount;
    }
    return profitTemp;
  }
}
