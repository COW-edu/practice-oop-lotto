package model.lotto;

import java.util.ArrayList;
import java.util.List;
import machine.MakeWinResultMachine;
import model.win.WinLottoResult;

public class LottoStore {

  private static final List<Lotto> lottos = new ArrayList<>();
  private int countOfLotto;
  private MakeWinResultMachine makeWinResult;

  public LottoStore() {
    makeWinResult = new MakeWinResultMachine();
  }

  public List<Lotto> makeLottoList(int payMoney) {
    countOfLotto = lottoSizeCount(payMoney);
    return makeWinResult.makeLottoList(lottos, countOfLotto);
  }

  public int lottoSizeCount(int payMoney) {
    return payMoney / LottoData.LOTTO_PRICE;
  }

  public PayLottosData makePayLottosData() {
    return new PayLottosData();
  }

  public WinLottoResult makeWinLottoResult(int[] equalCounts, boolean[] bonusCounts) {
    return new WinLottoResult(
        makeWinResult.makeWinLottoResultData(equalCounts, bonusCounts, countOfLotto));
  }

}
