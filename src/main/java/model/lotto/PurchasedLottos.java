package model.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.win.WinLottoCount;

public class PurchasedLottos {

  private final List<Lotto> payLottos = new ArrayList<>();

  public void addPayLotto(Lotto lotto) {
    payLottos.add(lotto);
  }
  public int getpayLottosSize(){
    return payLottos.size();
  }

  public List<Integer> getEqualWinCounts(Lotto winLotto) {
    return payLottos.stream().map(ticket -> ticket.checkEqualNumbersCount(winLotto.getNumbers()))
        .collect(Collectors.toList());

  }

  public List<Boolean> getEqualBonusNumber(int bonusNumber) {
    return payLottos.stream().map(lotto -> lotto.checkEqualNumber(bonusNumber))
        .collect(Collectors.toList());

  }


}
