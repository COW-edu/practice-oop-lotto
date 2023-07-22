package model.customer;

import java.util.stream.IntStream;
import model.lotto.Lotto;
import model.lotto.PurchasedLottos;

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
}
