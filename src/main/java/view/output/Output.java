package view.output;

import model.lotto.LottosData;
import model.win.WinData;

public interface Output {
  void outPutMessage(String message);
  void outPutLottoResult(WinData winData);
  void outPutBuyLotto(LottosData lottosData);
}
