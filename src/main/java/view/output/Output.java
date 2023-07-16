package view.output;

import model.lotto.PayLottosData;
import model.win.WinLottoResult;

public interface Output {
  void outPutMessage(String message);
  void outPutLottoResult(double profitRate, WinLottoResult winLottoResult);
  void outPutBuyLotto(PayLottosData lottosData);
}
