package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import machine.MakeWinResultMachine;
import model.win.WinLottoResult;

public class LottoStore {

  private final MakeWinResultMachine makeWinResult;
  private final PayLottos payLottos = new PayLottos();

  public LottoStore() {
    makeWinResult = new MakeWinResultMachine();
  }

  public PayLottos createPayLottos(int payMoney) {
    payLottos.addPayLotto(createLotto(), payMoney);
    return payLottos;
  }

  public Lotto createLotto() {
    return new Lotto(createLottoNumbers());
  }

  private List<Integer> createLottoNumbers() {
    return Randoms.pickUniqueNumbersInRange(LottoData.START_LOTTO_NUMBER,
        LottoData.END_LOTTO_NUMBER, LottoData.COUNT_OF_LOTTO_NUMBER);
  }

  public List<Integer> getEqualWinCounts(Lotto winLotto) {
   return payLottos.getEqualWinCounts(winLotto);
  }

  public List<Boolean> getEqualBonusNumber(int bonusNumber) {
    return payLottos.getEqualBonusNumber(bonusNumber);
  }

  public WinLottoResult createWinLottoResult(int[] equalCounts, boolean[] bonusCounts) {
    return new WinLottoResult(
        makeWinResult.makeWinLottoResultData(equalCounts, bonusCounts, countOfLotto));
  }


}
