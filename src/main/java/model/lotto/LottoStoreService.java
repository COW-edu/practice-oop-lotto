package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.customer.Customer;
import model.win.WinLottoCount;

public class LottoStoreService {

  public PurchasedLottos createPurchaseLottos(int payMoney) {
    PurchasedLottos purchasedLottos = new PurchasedLottos();
    int countOfLotto = payMoney / LottoData.LOTTO_PRICE;
    for (int index = 0; index < countOfLotto; index++) {
      purchasedLottos.addPurchasedLotto(createLotto());
    }
    return purchasedLottos;
  }

  public Map<String, Integer> createWinLottoResult(Customer customer, Lotto winLotto,
      int bonusNumber) {
    Map<String, Integer> winCountContainer = new HashMap<>();
    for (WinLottoCount winLottoCount : WinLottoCount.values()) {
      double winNumber = Double.parseDouble(winLottoCount.getCount());
      winCountContainer.put(winLottoCount.getCount(),
          countWin(customer, winNumber, winLotto, bonusNumber));
    }
    return winCountContainer;
  }

  private int countWin(Customer customer, double winNumber, Lotto winLotto, int bonusNumber) {
    return (int) customer.getWinCount(winNumber, winLotto, bonusNumber);
  }

  private Lotto createLotto() {
    return new Lotto(createLottoNumbers());
  }

  private List<Integer> createLottoNumbers() {
    return Randoms.pickUniqueNumbersInRange(LottoData.START_LOTTO_NUMBER,
        LottoData.END_LOTTO_NUMBER, LottoData.COUNT_OF_LOTTO_NUMBER);
  }


}
