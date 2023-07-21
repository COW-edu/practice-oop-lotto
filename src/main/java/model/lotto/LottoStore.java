package model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import machine.MakeWinResultMachine;
import model.win.WinLottoResult;

public class LottoStore {

  private static final List<Lotto> lottos = new ArrayList<>();
  private final MakeWinResultMachine makeWinResult;

  public LottoStore() {
    makeWinResult = new MakeWinResultMachine();
  }

  public PayLottos createPayLottos(int payMoney) {
    PayLottos payLottos = new PayLottos();
    payLottos.addLotto(createLotto(), payMoney);
    return payLottos;
  }

  public Lotto createLotto() {
    return new Lotto(createLottoNumbers());
  }

  private List<Integer> createLottoNumbers() {
    return Randoms.pickUniqueNumbersInRange(LottoData.START_LOTTO_NUMBER,
        LottoData.END_LOTTO_NUMBER, LottoData.COUNT_OF_LOTTO_NUMBER);
  }

  public WinLottoResult createWinLottoResult(int[] equalCounts, boolean[] bonusCounts) {
    return new WinLottoResult(
        makeWinResult.makeWinLottoResultData(equalCounts, bonusCounts, countOfLotto));
  }

}
