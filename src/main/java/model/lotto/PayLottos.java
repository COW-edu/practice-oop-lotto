package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PayLottos {

  private final List<Lotto> payLottos = new ArrayList<>();

  public void addPayLotto(Lotto lotto, int payMoney) {
    int countOfLotto = payMoney / LottoData.LOTTO_PRICE;
    for (int i = 0; i < countOfLotto; i++) {
      payLottos.add(lotto);
    }
  }

  public List<Integer> getEqualWinCounts(Lotto winLotto) {
    List<Integer> equalWinCounts = payLottos.stream()
        .map(ticket -> ticket.checkEqualNumbersCount(winLotto.getNumbers()))
        .collect(Collectors.toList());
    return equalWinCounts;
  }

  public List<Boolean> getEqualBonusNumber(int bonusNumber) {
    List<Boolean> equalBonusCounts = payLottos.stream()
        .map(lotto -> lotto.checkEqualNumber(bonusNumber))
        .collect(Collectors.toList());
    return equalBonusCounts;
  }
}
