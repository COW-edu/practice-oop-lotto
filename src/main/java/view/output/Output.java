package view.output;

import model.lotto.PayLottosData;
import model.win.WinData;

public interface Output {
  void outPutMessage(String message);
  void outPutLottoResult(WinData winData);
  void outPutBuyLotto(PayLottosData lottosData);
}
