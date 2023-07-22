package model.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottos {

  private final List<Lotto> purchasedLottos = new ArrayList<>();

  public void addPurchasedLotto(Lotto lotto) {
    purchasedLottos.add(lotto);
  }

  public int getPurchasedLottosCount() {
    return purchasedLottos.size();
  }

  public List<String> getLottosValue() {
    return purchasedLottos.stream().map(lotto -> String.valueOf(lotto))
        .collect(Collectors.toList());
  }

  public List<Integer> getEqualWinCounts(Lotto winLotto) {
    return purchasedLottos.stream()
        .map(ticket -> ticket.checkEqualNumbersCount(winLotto.getNumbers()))
        .collect(Collectors.toList());
  }

  public List<Boolean> getEqualBonusNumber(int bonusNumber) {
    return purchasedLottos.stream().map(lotto -> lotto.checkEqualNumber(bonusNumber))
        .collect(Collectors.toList());

  }


}
